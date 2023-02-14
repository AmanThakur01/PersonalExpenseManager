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
import org.springframework.web.bind.annotation.RequestParam;

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
        try {

            Date bDate = new Date(System.currentTimeMillis());
            Budget b = budgetService.findBtwDate(bDate);
            List<Expense> e = expenseService.findByDate(b.getFrom(), b.getTo());
            m.addAttribute("budget", b);
            m.addAttribute("expenseList", expenseService.findByDate(b.getFrom(), b.getTo()));
            return "report";//JSP
        } catch (Exception e) {
            return "redirect:index?act=nb";
        }

    }

    @RequestMapping(value = "/budget_date")
    public String reportDate(Model m, @RequestParam("bDate") Date bDate) {

        try {

            Budget b = budgetService.findBtwDate(bDate);

            List<Expense> e = expenseService.findByDate(b.getFrom(), b.getTo());

            m.addAttribute("budget", b);
            m.addAttribute("expenseList", expenseService.findByDate(b.getFrom(), b.getTo()));
            return "report";//JSP
        } catch (Exception e) {
            return "redirect:report?act=nr";
        }
    }

}
