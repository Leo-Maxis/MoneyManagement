package org.collection.dao;

import org.collection.entity.Expenditure;
import org.collection.entity.Receipt;
import org.collection.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceiptDAO {
    public Receipt insert(Receipt entity) throws SQLException, ClassNotFoundException {
        String sql = "insert into Receipts(name, amount, note, receiptDate, type) values (?,?,?,?,?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ptsmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ptsmt.setString(1, entity.getName());
            ptsmt.setDouble(2, entity.getAmount());
            ptsmt.setString(3, entity.getNote());
            java.sql.Date date = new Date(entity.getReceiptDate().getTime());
            ptsmt.setDate(4, date);
            ptsmt.setInt(5, entity.getType());
            ptsmt.executeUpdate();
            ResultSet rs = ptsmt.getGeneratedKeys();
            if (rs.next()) {
                entity.setId(rs.getInt(1));
            }
            return entity;
        }
    }
    public boolean update(Receipt entity) throws SQLException, ClassNotFoundException {
        String sql = "update Receipts set name=?, amount =?, note=?, receiptDate=?, type=? where id=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ptsmt = conn.prepareStatement(sql)) {
            ptsmt.setString(1, entity.getName());
            ptsmt.setDouble(2, entity.getAmount());
            ptsmt.setString(3, entity.getNote());
            java.sql.Date date = new Date(entity.getReceiptDate().getTime());
            ptsmt.setDate(4, date);
            ptsmt.setInt(5, entity.getType());
            ptsmt.setInt(6, entity.getId());
            return ptsmt.executeUpdate() > 0;

        }
    }
    public List<Receipt> findAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from Receipts";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            List<Receipt> list = new ArrayList<>();

            try(ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Receipt entity = new Receipt();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    entity.setAmount(rs.getDouble("amount"));
                    entity.setReceiptDate(rs.getDate("expenditureDate"));
                    entity.setNote(rs.getString("note"));
                    entity.setType(rs.getInt("type"));
                    list.add(entity);
                }
            }
            return list;
        }
    }
}
