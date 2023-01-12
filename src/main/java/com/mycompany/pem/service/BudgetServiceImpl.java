package com.mycompany.pem.service;

import com.mycompany.pem.dao.BaseDAO;
import com.mycompany.pem.dao.BudgetDAO;
import com.mycompany.pem.domain.Budget;
import com.mycompany.pem.rm.BudgetRowMapper;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author amanm
 */
@Service
public class BudgetServiceImpl extends BaseDAO implements BudgetService{

   @Autowired
    private BudgetDAO budgetDAO;
    
    @Override
    public void save(Budget b) {
        budgetDAO.save(b);
    }

    @Override
    public void update(Budget b) {
        budgetDAO.update(b);
    }

    @Override
    public void delete(Date b) {
        budgetDAO.delete(b);
    }

    @Override
    public Budget findBtwDate(Date date) {
        return budgetDAO.findBtwDate(date);
    }

    @Override
    public List<Budget> findBudget(String txt) {
//        `from`, `to`, `amount`, `personalCare`, `transportational`, `rent`, `food`, `miscellaneous`, `bills`
        String sql = "SELECT `from`, `to`, `amount`,`personalCare`,`transportational`,`rent`,`food`,`miscellaneous`,`bills` FROM budget WHERE "
                + "(`from` LIKE '%"+txt+"%' OR `to` LIKE '%"+txt+"%' OR `amount` LIKE '%"+txt+"%' OR `personalCare` LIKE '%"+txt+"%'"
                + "OR `transportational` LIKE '%"+txt+"%' OR `rent` LIKE '%"+txt+"%' OR `food` LIKE '%"+txt+"%' OR `miscellaneous` LIKE '%"+txt+"%'"
                + " OR `bills` LIKE '%"+txt+"%')";
        return getJdbcTemplate().query(sql, new BudgetRowMapper()); 
    }
    @Override
    public List<Budget> findAll() {
        return budgetDAO.findAll();
    }
    @Override
    public void delete(Date[] Ids) {
        for (Date Id : Ids) {
            budgetDAO.delete(Id);
        }
    }
    
    @Override
    public Budget getLastRow() {
        String sql = "SELECT * FROM budget ORDER BY sr DESC LIMIT 1";
        return getJdbcTemplate().queryForObject(sql, new BudgetRowMapper());
    }
}
