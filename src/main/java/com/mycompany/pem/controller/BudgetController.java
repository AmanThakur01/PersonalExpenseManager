package com.mycompany.pem.controller;

import com.mycompany.pem.command.BudgetCommand;
import com.mycompany.pem.domain.Budget;
import com.mycompany.pem.domain.Expense;
import com.mycompany.pem.service.BudgetService;
import com.mycompany.pem.service.ExpenseService;
import com.mycompany.pem.util.TotalAmount;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author amanm
 */
@Controller
public class BudgetController {
    @Autowired
    BudgetService budgetService;
    ExpenseService expenseService;
    
    @RequestMapping(value = "/new_budget")
    public String newBudget(Model m) {
        m.addAttribute("command", new BudgetCommand());
        System.out.println("this is new budget url assining budgetcommand");
        return "newBudget";
    }

    @RequestMapping(value = "/add_budget")
    public String addBudget(@ModelAttribute("command") BudgetCommand cmd, Model m) {
        System.out.println("this is new budget2 url assining budgetcommand");
        try {
//            
            Budget b = cmd.getBudget();
            b=TotalAmount.addAmount(b);
            System.out.println("controller from = " + b.getFrom());
            budgetService.save(b);
            return "redirect:index?act=reg"; //add budget/redirect:index?act=reg
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            m.addAttribute("err", "Budget is already Added. Please select another Date.");
            return "newBudget";//JSP
        }
    }
    @RequestMapping(value = "/view_Budget")
    public String viewBudget(Model m) {
        m.addAttribute("budgetList", budgetService.findAll());
        return "viewBudget";
    }
    @RequestMapping(value = "/budget_search")
    public String budgetSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
        m.addAttribute("budgetList", budgetService.findBudget(freeText));
        return "viewBudget"; //JSP
    }

    @RequestMapping(value = "/bulk_bdelete")
    public String deleteBulkBudget(@RequestParam("bid") Date[] from) {
        System.out.println("bulk delete inside");
        budgetService.delete(from);
        return "redirect:view_Budget?act=del";
    }

    @RequestMapping(value = "/report_budget")
    public String prepareReport(Model m, HttpSession session, @RequestParam("bid") Integer Id) {
       
        return "index";//JSP form view
    }
    @RequestMapping(value = "/del_budget")
    public String deleteExpense(@RequestParam("bid") Date bId) {
        budgetService.delete(bId);
        return "redirect:view_Budget?act=del";
    }
    @RequestMapping(value = "/check_avail")
    @ResponseBody
    public String checkAvailablity(@RequestParam Date datef,@RequestParam Date datet) {
        System.out.println("date = "+datef);
        System.out.println("date = "+datet);
        if(!(datef.compareTo(datet)<0)){
            return "Budget From is grater than Budget To";
        }
        Date d = new Date(System.currentTimeMillis());
        if(datef.compareTo(d)<0){
            return "Enter Future Budget";
        }
        Budget lastRow = budgetService.getLastRow();
        if (lastRow.getTo().compareTo(datet)>0) {
            return "Budget Already Exist with this date";
        }
        if (lastRow.getFrom().compareTo(datef)>0) {
            return "Budget Already Exist with this date";
        }
        System.out.println("no if executed");
        return "true";
    }
    @RequestMapping(value = "/report")
    public String report(Model m) {
        Date d = new Date(System.currentTimeMillis());
        Budget b = budgetService.findBtwDate(d);
        
//        List<Expense> e = expenseService.findByDate(b.getFrom(), b.getTo());
        
//        System.out.println("e = "+e.get(1));
        System.out.println("b = "+b.getAmount());
        m.addAttribute("budget", b);
//        m.addAttribute("expenseList", e);
        return "report";//JSP
    }
}
