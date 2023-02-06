/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pem.test;

import com.mycompany.pem.config.SpringRootConfig;
import com.mycompany.pem.dao.ExpenseDAO;
import com.mycompany.pem.domain.Expense;
import com.mycompany.pem.service.ExpenseService;
import java.sql.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author amanm
 */
public class TestFindByProp {
      public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ExpenseService ds = ctx.getBean(ExpenseService.class);
        Date from = Date.valueOf("2023-01-01");
//        Date to = Date.valueOf("2023-02");
//        Object o = new Object();
        List<Expense> f = ds.findByProperty("date","2023-02" );
        for (Expense expense : f) {
            System.out.println("Expense = " + expense.getDate());

        }
        System.out.println("------SQL executed-----");
    }
}
