package com.mycompany.pem.command;

import com.mycompany.pem.domain.Expense;

/**
 *
 * @author amanm
 */
public class ExpenseCommand {
    Expense expense;

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
    
}
