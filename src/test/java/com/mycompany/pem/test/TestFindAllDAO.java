package com.mycompany.pem.test;

import com.mycompany.pem.config.SpringRootConfig;
import com.mycompany.pem.dao.ExpenseDAO;
import com.mycompany.pem.domain.Expense;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author amanm
 */
public class TestFindAllDAO {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ExpenseDAO ds = ctx.getBean(ExpenseDAO.class);
        List<Expense> findAll = ds.findAll();
        for (Expense expense : findAll) {
            System.out.println("Expense = "+expense.getSr());
            
        }
        System.out.println("------SQL executed-----");
    }
}
