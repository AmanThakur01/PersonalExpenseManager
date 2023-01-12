package com.mycompany.pem.test;

import com.mycompany.pem.config.SpringRootConfig;
import java.sql.Date;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * @author amanm
 */
public class TestDataSource {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql="INSERT INTO expense(`date`, `category`, `amount`, `remark`) VALUES(?,?,?,?)";
        Object[] param = new Object[]{date, "Rent", 9000, "advance month feb"};
        jt.update(sql, param);
        System.out.println("------SQL executed-----");
    }
}
