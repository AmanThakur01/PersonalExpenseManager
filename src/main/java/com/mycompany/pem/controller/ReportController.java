
package com.mycompany.pem.controller;

import com.mycompany.pem.domain.Budget;
import com.mycompany.pem.domain.Expense;
import com.mycompany.pem.service.BudgetService;
import com.mycompany.pem.service.ExpenseService;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author amanm
 */
@Controller
public class ReportController {

    @Autowired
    BudgetService budgetService;
    @Autowired
    ExpenseService expenseService;

    @RequestMapping(value = "/report")
    public String report(Model m) {
        Date d = new Date(System.currentTimeMillis());
        Budget b = budgetService.findBtwDate(d);

        List<Expense> e = expenseService.findByDate(b.getFrom(), b.getTo());

        System.out.println("e = " + e.size());
        System.out.println("b = " + b.getAmount());
        m.addAttribute("budget", b);
        m.addAttribute("expenseList", expenseService.findByDate(b.getFrom(), b.getTo()));
        return "report";//JSP
    }
}
