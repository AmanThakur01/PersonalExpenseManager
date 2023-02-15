package com.mycompany.pem.service;

import com.mycompany.pem.domain.Budget;
import java.sql.Date;
import java.util.List;

/**
 * This interface declares business logic for Budget entity
 * @author amanm
 */
public interface BudgetService {

    /**
     * Save method will save new Budget
     *
     * @param b object having updated value
     */
    public void save(Budget b);

    /**
     * This method will find the budget from which this date belong to
     *
     * @param date this date comes under which budget,that budget will be
     * returned
     * @return
     */
    public Budget findBtwDate(Date date);

    /**
     * free text search functionality will be provided by this method
     *
     * @param freeText input text
     * @return matched budget will be returned
     */
    public List<Budget> findBudget(String freeText);

    /**
     * this method find all the budgets
     *
     * @return list of budgets
     */
    public List<Budget> findAll();

    /**
     * This method find budget having same id
     *
     * @param id
     * @return
     */
    public List<Budget> findById(Integer id);

    /**
     * this method will delete budget in bulk
     *
     * @param Ids this contain list of id which will be deleted
     */
    public void delete(Integer[] Ids);

    public void delete(Integer Id);

    /**
     * this method will return the newest budget in the database
     *
     * @return
     */
    public Budget getLastRow();
}
