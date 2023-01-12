package com.mycompany.pem.dao;

import com.mycompany.pem.domain.Expense;
import java.sql.Date;
import java.util.List;

/*
 * @author Vikram
 */
public interface ExpenseDAO {

    public void save(Expense u);

    public void update(Expense u);

    public void delete(Integer e);

    public void deleteByDate(Date from,Date to);

    public List<Expense> findByDate(Date from,Date to);

    public List<Expense> findAll();

    public List<Expense> findByProperty(String propName, Object propValue);

    public Expense findById(Integer Id);
}
