package com.mycompany.pem.test;

import com.mycompany.pem.config.SpringRootConfig;
import com.mycompany.pem.domain.Budget;
import com.mycompany.pem.service.BudgetService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * @author amanm
 */
public class TestGetLastRow {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        BudgetService ds = ctx.getBean(BudgetService.class);
        Budget b =ds.getLastRow();
        System.out.println("amount = "+b.getAmount());
    }
}
