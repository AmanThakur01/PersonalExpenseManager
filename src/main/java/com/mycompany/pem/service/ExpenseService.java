package com.mycompany.pem.service;

import com.mycompany.pem.domain.Expense;
import java.sql.Date;
import java.util.List;

/**
 * This interface declares business logic for Expense entity
 *
 * @author amanm
 */
public interface ExpenseService {

    /**
     * Save method will save new Expense
     *
     * @param u Expense object having updated value
     */
    public void save(Expense e);

    /**
     * This method will edit given Expense and save the changes
     *
     * @param u updated Object of expense
     */
    public void update(Expense e);

    /**
     * This method delete a single expense
     *
     * @param e expense id which will delete
     */
    public void delete(Integer e);

    /**
     * this method will delete expense in bulk
     *
     * @param e this contain list of id which will be deleted
     */
    public void delete(Integer[] e);

    /**
     *
     * @return return all expenses
     */
    public List<Expense> findAll();

    /**
     * This method will search free text.
     *
     * @param txt input free text
     * @return
     */
    public List<Expense> findExpense(String txt);

    /**
     * This method is used for searching purpose
     *
     * @param propName this contain the property name in which search has been
     * performed
     * @param propValue this contain the text value which will search in given
     * property
     * @return list of expense match the value in property
     */
    public List<Expense> findByProperty(String propName, Object propValue);

    /**
     * This method find expense that lies between this 2 date range
     *
     * @param from starting date ,which is less than another date
     * @param to end date, which is greater than first date
     * @return return list of expense
     */
    public List<Expense> findByDate(Date from, Date to);

    /**
     * find expense by expense id
     *
     * @param Id integer expense id
     * @return
     */
    public Expense findById(Integer Id);
}
