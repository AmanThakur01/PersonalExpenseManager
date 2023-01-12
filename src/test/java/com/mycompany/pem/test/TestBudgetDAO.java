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
public class TestBudgetDAO {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        BudgetDAO ds = ctx.getBean(BudgetDAO.class);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        
        Budget b = new Budget();
        b.setFrom(date);
        b.setTo(date);
        b.setAmount(1222);
        b.setPersonalCare(122);
        b.setTransportational(123);
        b.setRent(872);
        b.setFood(555);
        b.setMiscellaneous(444);
        b.setBills(222);
        ds.save(b);
        System.out.println("------SQL executed-----");
    }
}
