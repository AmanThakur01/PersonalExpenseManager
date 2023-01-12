package com.mycompany.pem.dao;

import com.mycompany.pem.domain.Budget;
import com.mycompany.pem.rm.BudgetRowMapper;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/*
 * @author amanm
 */
@Repository
public class BudgetDAOImpl extends BaseDAO implements BudgetDAO {
//`from`, `to`, `amount`, `personalCare`, `transportational`, `rent`, `food`, `miscellaneous`, `bills`

    @Override
    public void save(Budget b) {
        String sql = "INSERT INTO budget(`from`, `to`, `amount`, `personalCare`, `transportational`, `rent`, `food`, `miscellaneous`, `bills`)"
                + " VALUES(:from, :to, :amount,:personalCare,:transportational,:rent,:food,:miscellaneous,:bills)";
        Map m = new HashMap();
        m.put("from", b.getFrom());
        m.put("to", b.getTo());
        m.put("amount", b.getAmount());
        m.put("personalCare", b.getPersonalCare());
        m.put("transportational", b.getTransportational());
        m.put("rent", b.getRent());
        m.put("food", b.getFood());
        m.put("miscellaneous", b.getMiscellaneous());
        m.put("bills", b.getBills());

        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps);
    }

    @Override
    public void update(Budget b) {
        String sql = "UPDATE expense "
                + " SET from=:from,"
                + " to=:to, "
                + " amount=:amount,"
                + " personalCare=:personalCare,"
                + " transportational=:transportational,"
                + " rent=:rent,"
                + " food=:food,"
                + " miscellaneous=:miscellaneous,"
                + " bills=:bills,";
        Map m = new HashMap();
        m.put("from", b.getFrom());
        m.put("to", b.getTo());
        m.put("amount", b.getAmount());
        m.put("personalCare", b.getPersonalCare());
        m.put("transportational", b.getTransportational());
        m.put("rent", b.getRent());
        m.put("food", b.getFood());
        m.put("miscellaneous", b.getMiscellaneous());
        m.put("bills", b.getBills());

        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Date b) {
        String sql = "DELETE FROM budget WHERE `from`= DATE '"+b+"'";
        getJdbcTemplate().update(sql);
    }

//    @Override
//    public List<Budget> findByDate(Date date) {
//        String sql = "SELECT sr, date,category, amount,remark FROM expense WHERE date = ?";
//        return getJdbcTemplate().query(sql, new BudgetRowMapper(), date);
//    }
    @Override
    public Budget findBtwDate(Date date) {
        String sql = "SELECT `from`, `to`, `amount`, `personalCare`, `transportational`, `rent`, `food`, `miscellaneous`, `bills` FROM budget WHERE `from` <= DATE '"+date+"' AND `to`>= DATE '"+date+"'";
       
        return getJdbcTemplate().queryForObject(sql, new BudgetRowMapper());
    }

    @Override
    public List<Budget> findAll() {
        String sql = "SELECT * FROM budget";
        return getJdbcTemplate().query(sql, new BudgetRowMapper());
    }

}
