package com.mycompany.pem.rm;

import com.mycompany.pem.domain.Expense;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/*
 * @author amanm
 */
public class ExpenseRowMapper implements RowMapper<Expense> {

    @Override
    public Expense mapRow(ResultSet rs, int i) throws SQLException {
        Expense e = new Expense();
        e.setCategory(rs.getString("category"));
        e.setSr(rs.getInt("sr"));
        e.setDate(rs.getDate("date"));
        e.setAmount(rs.getInt("amount"));
        e.setRemark(rs.getString("remark"));
        return e;
    }
    
}
