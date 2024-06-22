package org.collection.dao;

import org.collection.entity.ExpenditureType;
import org.collection.entity.ReceiptType;
import org.collection.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceiptTypeDAO {
    public ReceiptType insert(ReceiptType entity) throws SQLException, ClassNotFoundException {
        String sql = "insert into ReceiptType(name) values (?)";
        try(Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, entity.getName());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                entity.setId(rs.getInt(1));
            }
            return entity;
        }
    }
    public ReceiptType update(ReceiptType entity) throws SQLException, ClassNotFoundException {
        String sql = "update ReceiptType set name =? where id =?";
        try(Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getId());
            pstmt.executeUpdate();
            return entity;
        }
    }
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        String sql = "delete from ReceiptType where id =? ";
        try(Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        }
    }
    public List<ReceiptType> findAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from ReceiptType";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            List<ReceiptType> list = new ArrayList<>();

            try(ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    ReceiptType entity = new ReceiptType();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    list.add(entity);
                }
            }
            return list;
        }
    }
    public List<ReceiptType> findById(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from ReceiptType where id=?";

        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            List<ReceiptType> list = new ArrayList<>();

            try(ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    ReceiptType entity = new ReceiptType();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    list.add(entity);
                }
            }
            return list;
        }
    }
}
