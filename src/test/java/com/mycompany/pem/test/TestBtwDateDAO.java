/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pem.test;

import com.mycompany.pem.config.SpringRootConfig;
import com.mycompany.pem.dao.BudgetDAO;
import com.mycompany.pem.domain.Budget;
import java.sql.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author amanm
 */
public class TestBtwDateDAO {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        BudgetDAO ds = ctx.getBean(BudgetDAO.class);
        Date date = Date.valueOf("2023-01-12");
        Budget b = ds.findBtwDate(date);
        System.out.println("budget = "+b.getAmount());
    }
}
