package com.SpringExample.Student;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource(value = "classpath:Database-Properties")
@ComponentScan(basePackages = {"com.SpringExample.Student"})

public class StudentConfiguration {
	

		@Value("${jdbc.driverClassName}")
		private String driverClassName;
		@Value("${jdbc.url}")
		private String URL;
		@Value("${jdbc.username}")
		private String userName;
		@Value("${jdbc.password}")
		private String password;
	
		@Bean
        public DataSource dataSource() 
		{	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(driverClassName);
	        dataSource.setUrl(URL);	       
	        dataSource.setUsername(userName);
	        dataSource.setPassword(password);
	        return dataSource;
		}

	 @Bean
	 public JdbcTemplate jdbcTemplate(DataSource dataSource) 
	 {
	     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	     jdbcTemplate.setResultsMapCaseInsensitive(true);
	     return jdbcTemplate;
	 }
	 
	 @Bean
	 public StudentDAO studentDAO(JdbcTemplate jdbcTemplate)
	 {
		 return new StudentDAOImpl();
	 }
	 
	 @Bean
	 public StudentService studentService(StudentDAO studentDAO)
	 {
		 return new StudentServiceImpl();
	 }
	 

}

 
