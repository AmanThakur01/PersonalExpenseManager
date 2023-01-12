package com.mycompany.pem.service;

import com.mycompany.pem.dao.BaseDAO;
import com.mycompany.pem.dao.ExpenseDAO;
import com.mycompany.pem.domain.Expense;
import com.mycompany.pem.rm.ExpenseRowMapper;
import com.mycompany.pem.util.StringUtil;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author amanm
 */
@Service
public class ExpenseServiceImpl extends BaseDAO implements ExpenseService{

    @Autowired
    private ExpenseDAO expenseDAO;
    
    @Override
    public void save(Expense e) {
        expenseDAO.save(e);
    }

    @Override
    public void update(Expense e) {
        expenseDAO.update(e);
    }

    @Override
    public void delete(Integer e) {
        expenseDAO.delete(e);
    }

    @Override
    public List<Expense> findAll() {
        
        return expenseDAO.findAll();
    }
    @Override
    public List<Expense> findExpense(String txt) {
        String sql = "SELECT sr, date,category, amount,remark FROM expense WHERE (date LIKE '%"+txt+"%' OR category LIKE '%"+txt+"%' OR amount LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
        return getJdbcTemplate().query(sql, new ExpenseRowMapper()); 
    }
    @Override
    public void delete(Integer[] Ids) {
        String ids = StringUtil.toCommaSeparatedString(Ids);
        String sql = "DELETE FROM expense WHERE sr IN("+ids+")";
        getJdbcTemplate().update(sql);
    }
    

    @Override
    public Expense findById(Integer Id) {
        return expenseDAO.findById(Id);
    }

    @Override
    public List<Expense> findByDate(Date date, Date date1) {
        return expenseDAO.findByDate(date, date1);
    }
}
