package org.collection.dao;

import org.collection.entity.ExpenditureType;
import org.collection.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
