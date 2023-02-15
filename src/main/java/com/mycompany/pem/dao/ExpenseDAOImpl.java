package com.mycompany.pem.dao;

import com.mycompany.pem.domain.Expense;
import com.mycompany.pem.rm.ExpenseRowMapper;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amanm
 */
@Repository
public class ExpenseDAOImpl extends BaseDAO implements ExpenseDAO{

    @Override
    public void save(Expense e) {
        String sql = "INSERT INTO expense(`date`, `category`, `amount`,`remark`)"
                + " VALUES(:date, :category, :amount,:remark)";
        Map m = new HashMap();
        m.put("date", e.getDate());
        m.put("category", e.getCategory());
        m.put("amount", e.getAmount());
        m.put("remark", e.getRemark());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps,kh);
        Integer sr = kh.getKey().intValue();
        e.setSr(sr);
    }

    @Override
    public void update(Expense e) {
        String sql = "UPDATE expense "
                + " SET date=:date,"
                + " category=:category, "
                + " amount=:amount,"
                + " remark=:remark WHERE sr=:sr";
        Map m = new HashMap();
        m.put("date", e.getDate());
        m.put("category", e.getCategory());
        m.put("amount", e.getAmount());
        m.put("remark", e.getRemark());    
        m.put("sr", e.getSr());
       
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Integer e) {
        String sql="DELETE FROM expense WHERE sr=?";
        getJdbcTemplate().update(sql, e);
    }


    @Override
    public List<Expense> findByDate(Date from,Date to) {
        String sql = "SELECT * FROM expense WHERE date BETWEEN ? AND ?";
        Object[] params = new Object[]{from, to};
        return getJdbcTemplate().query(sql, new ExpenseRowMapper(),params);
    }

    @Override
    public List<Expense> findAll() {
        String sql = "SELECT * FROM expense";
        return getJdbcTemplate().query(sql, new ExpenseRowMapper());
    }

    @Override
    public List<Expense> findByProperty(String propName, Object propValue) {
        String sql = "SELECT  sr, date,category, amount,remark FROM expense WHERE (`" + propName + "` LIKE '%"+propValue+"%') ";
        return getJdbcTemplate().query(sql, new ExpenseRowMapper());
    }

    @Override
    public Expense findById(Integer Id) {
        String sql = "SELECT sr, date, category, amount, remark FROM expense WHERE sr=?";
        return getJdbcTemplate().queryForObject(sql, new ExpenseRowMapper(), Id);
    }
    
}
