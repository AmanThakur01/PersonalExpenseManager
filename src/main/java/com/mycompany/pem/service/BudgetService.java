package com.mycompany.pem.service;

import com.mycompany.pem.domain.Budget;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author amanm
 */
public interface BudgetService {

    public void save(Budget b);

    public void update(Budget b);

    public void delete(Date b);

    public Budget findBtwDate(Date date);

    public List<Budget> findBudget(String freeText);

    public List<Budget> findAll();

    public void delete(Date[] Ids);

    public Budget getLastRow();
}
