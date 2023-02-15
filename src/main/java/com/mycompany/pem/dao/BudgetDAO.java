package com.mycompany.pem.dao;

import com.mycompany.pem.domain.Budget;
import java.sql.Date;
import java.util.List;

/*
 * @author amanm
 */
public interface BudgetDAO {

    public void save(Budget u);

    public void update(Budget u);

     public void delete(Integer id);

    public List<Budget> findById(Integer id);
    
    public List<Budget> findAll();

    public Budget findBtwDate(Date date);
}
