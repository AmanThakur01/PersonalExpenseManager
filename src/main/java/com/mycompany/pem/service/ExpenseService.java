package com.mycompany.pem.service;

import com.mycompany.pem.domain.Expense;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author amanm
 */
public interface ExpenseService {

    public void save(Expense e);

    public void update(Expense e);

    /**
     * Bulk delete
     *
     * @param Expense
     */
    public void delete(Integer e);

    public void delete(Integer[] e);

    public List<Expense> findAll();

    public List<Expense> findExpense(String txt);

    public List<Expense> findByDate(Date from, Date to);

    public Expense findById(Integer Id);
}
