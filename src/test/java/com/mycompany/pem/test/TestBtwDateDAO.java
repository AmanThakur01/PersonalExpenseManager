package com.mycompany.pem.test;

import com.mycompany.pem.config.SpringRootConfig;
import com.mycompany.pem.dao.BudgetDAO;
import com.mycompany.pem.domain.Budget;
import java.sql.Date;
import java.time.LocalDate;
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
        Date date = Date.valueOf("2023-02-16");
        Date d = new Date(System.currentTimeMillis());
        System.out.println("d = "+date);
        Budget b = ds.findBtwDate((date));
        System.out.println("budget = "+b.getAmount());
    }
}
