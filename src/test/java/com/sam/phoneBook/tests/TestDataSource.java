package com.sam.phoneBook.tests;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sam.phoneBook.config.SpringRootConfig;

public class TestDataSource {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds =  ctx.getBean(DataSource.class);
		
		JdbcTemplate jt = new JdbcTemplate(ds);
		
		String sql = "INSERT INTO user(`name`, `email`, `phone`, `address`, `password`, `login_name`) VALUES(?,?,?,?,?,?)";
		Object[] params = new Object[]{"Sam David", "sam@mail.com", "8665451664", "mumbai", "abcd123$", "s"};
		
		int s = jt.update(sql, params);
		System.out.println("Executed " + s);
	}

}
