package org.collection.dao;

import org.collection.entity.ExpenditureType;
import org.collection.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureTypeDAO {
    public ExpenditureType insert(ExpenditureType entity) throws SQLException, ClassNotFoundException {
        String sql = "insert into ExpenditureType(name) values (?)";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, entity.getName());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                entity.setId(rs.getInt(1));
            }
            return entity;
        }
    }

    public ExpenditureType update(ExpenditureType entity) throws SQLException, ClassNotFoundException {
        String sql = "update ExpenditureType set name =? where id =?";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getId());
            pstmt.executeUpdate();
            return entity;
        }
    }

    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        String sql = "delete from ExpenditureType where id =?";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }
    public List<ExpenditureType> findAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from ExpenditureType";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            List<ExpenditureType> list = new ArrayList<>();

            try(ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    ExpenditureType entity = new ExpenditureType();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    list.add(entity);
                }
            }
            return list;
        }
    }
    public ExpenditureType findById(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from ExpenditureType where id = ?";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1,id);
            try(ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    ExpenditureType entity = new ExpenditureType();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    return entity;
                }
            }
            return null;
        }
    }
}
