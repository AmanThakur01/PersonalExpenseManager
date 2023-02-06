package com.mycompany.pem.controller;

import com.mycompany.pem.domain.Expense;
import com.mycompany.pem.service.ExpenseService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @author amanm
 */
@Controller
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @RequestMapping(value = {"/", "/index"})
    public String index(Model m) {

        m.addAttribute("expenseList", expenseService.findAll());
        return "index"; //JSP - /WEB-INF/view/index.jsp
    }

    @RequestMapping(value = "/expense_form")
    public String expenseForm(Model m) {
        m.addAttribute("command", new Expense());
        System.out.println("this is new Expense");
        return "expense_form";//jsp
    }

    @RequestMapping(value = "/add_expense")
    public String addExpense(@ModelAttribute("command") Expense b, Model m, HttpSession session) {
        System.out.println("this is new Expense2 url assining Expensecommand");
        Integer eId = (Integer) session.getAttribute("eId");
//        Expense b = cmd.getExpense();
        if (eId == null) {
            try {
                expenseService.save(b);
                return "redirect:expense_form?act=reg"; //add budget/redirect:index?act=reg
            } catch (DuplicateKeyException e) {
                e.printStackTrace();
                m.addAttribute("err", "Expense is already Added.");
                return "expense_form";//JSP
            }
        } else {
            //update task
            try {
                b.setSr(eId); //PK
                expenseService.update(b);
                session.removeAttribute("eId");
                return "redirect:index?act=sv";//redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to Edit contact");
                return "expense_form";
            }
        }
    }

    @RequestMapping(value = "/expense_search")
    public String expenseSearch(Model m, @RequestParam("freeText") String freeText) {
        m.addAttribute("expenseList", expenseService.findExpense(freeText));
        return "index"; //JSP
    }

    @RequestMapping(value = "/bulk_edelete")
    public String deleteBulkExpense(@RequestParam Integer[] eid) {
        try {
            expenseService.delete(eid);
            return "redirect:index?act=del";
        } catch (Exception e) {
            return "redirect:index?act=ag";

        }
    }

    @RequestMapping(value = "/edit_expense")
    public String prepareEditForm(Model m, HttpSession session, @RequestParam("eid") Integer Id) {
        session.setAttribute("eId", Id);
        Expense e = expenseService.findById(Id);
        System.out.println("find id  = " + e.getCategory());
        m.addAttribute("command", e);
        return "expense_form";//JSP form view
    }

    @RequestMapping(value = "/del_expense")
    public String deleteExpense(@RequestParam("eid") Integer eId) {
        expenseService.delete(eId);
        return "redirect:index?act=del";
    }

    @RequestMapping(value = "/expense_filter")
    public String expenseFilter(@RequestParam("filter") String filter, @RequestParam("val") String val, Model m) {
        System.out.println("filter = " + filter);
        System.out.println("val = " + val);
        if ("byCategory".equals(filter)) {
            List<Expense> l = expenseService.findByProperty("category", val);
            System.out.println("l cate = " + l);
            for (Expense expense : l) {
                System.out.println("Expense = " + expense.getDate());

            }
            m.addAttribute("expenseList", l);

        } else {
            List<Expense> l = expenseService.findByProperty("date", val);
            m.addAttribute("expenseList", l);
            System.out.println("l date = " + l);
            for (Expense expense : l) {
                System.out.println("Expense = " + expense.getDate());

            }
            m.addAttribute("expenseList", l);
        }
        return "/index";
    }

}
