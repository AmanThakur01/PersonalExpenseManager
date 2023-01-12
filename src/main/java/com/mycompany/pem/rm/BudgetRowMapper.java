package com.mycompany.pem.rm;

import com.mycompany.pem.domain.Budget;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author amanm
 */
public class BudgetRowMapper implements RowMapper<Budget>{
    @Override
    public Budget mapRow(ResultSet rs, int i) throws SQLException {
        //`from`, `to`, `amount`, `personalCare`, `transportational`, `rent`, `food`, `miscellaneous`, `bills`
        Budget b =new Budget();
        b.setFrom(rs.getDate("from"));
        b.setTo(rs.getDate("to"));
        b.setAmount(rs.getInt("amount"));
        b.setPersonalCare(rs.getInt("personalCare"));
        b.setTransportational(rs.getInt("transportational"));
        b.setRent(rs.getInt("rent"));
        b.setFood(rs.getInt("food"));
        b.setMiscellaneous(rs.getInt("miscellaneous"));
        b.setBills(rs.getInt("bills"));
        return b;
    }
}
