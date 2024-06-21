package org.collection.dao;

import org.collection.entity.Expenditure;
import org.collection.util.DatabaseUtil;

import java.sql.*;

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
}
