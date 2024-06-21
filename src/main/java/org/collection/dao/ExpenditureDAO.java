package org.collection.dao;

import org.collection.entity.Expenditure;
import org.collection.entity.ExpenditureType;
import org.collection.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureDAO {
    public Expenditure insert(Expenditure entity) throws SQLException, ClassNotFoundException {
        String sql = "insert into Expenditure(name, amount, note, expenditureDate, type) values (?,?,?,?,?)";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getAmount());
            pstmt.setString(3, entity.getNote());
            java.sql.Date date = new Date(entity.getExpenditureDate().getTime());
            pstmt.setDate(4, date);
            pstmt.setInt(5, entity.getType());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                entity.setId(rs.getInt(1));
            }
            return entity;
        }
    }
    public boolean update(Expenditure entity) throws SQLException, ClassNotFoundException {
        String sql = "update Expenditure set name=? , amount = ?, note = ?, expenditureDate =?, type =? where id =?";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getAmount());
            pstmt.setString(3, entity.getNote());
            java.sql.Date date = new Date(entity.getExpenditureDate().getTime());
            pstmt.setDate(4, date);
            pstmt.setInt(5, entity.getType());
            pstmt.setInt(6, entity.getId());
            return pstmt.executeUpdate() > 0;
        }
    }
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        String sql = "delete from Expenditure where id =?";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }
    public List<Expenditure> findAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from Expenditure";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            List<Expenditure> list = new ArrayList<>();

            try(ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    Expenditure entity = new Expenditure();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    entity.setAmount(rs.getDouble("amount"));
                    entity.setExpenditureDate(rs.getDate("expenditureDate"));
                    entity.setNote(rs.getString("note"));
                    entity.setType(rs.getInt("type"));
                    list.add(entity);
                }
            }
            return list;
        }
    }
}
