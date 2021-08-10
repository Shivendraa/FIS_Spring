package com.fis.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.springlearn.bean.Employee;
import com.fis.springlearn.bean.EmployeeController;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		//displayDate();
		//displayCountry();
		//displayCountries();
		displayEmployee();
		getEmployeeController();
	}
	static void displayDate()  {
		LOGGER.info("Start");
		 ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		 SimpleDateFormat formatUS = context.getBean("dateFormatUS", SimpleDateFormat.class);
		 try {
			Date parseDate = format.parse("31/12/2018");
			Date parseDateUS = formatUS.parse("08/15/2021");
			//System.out.println(parseDate);
			//System.out.println(parseDateUS);
			LOGGER.debug(parseDate+"");
			LOGGER.debug(parseDateUS+"");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 LOGGER.info("END");
	}
	
	static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("countryIN", Country.class);
		Country anotherCountry = context.getBean("countryIN", Country.class);
		LOGGER.debug("Country : {}", country.toString());
	}
	
	static void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = context.getBean("countryList",ArrayList.class);
		for(Country c : countries) {
			LOGGER.debug("Country : {}", c.toString());
		}
	}
	
	static void displayEmployee() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		Employee emp = (Employee) context.getBean("employee",Employee.class);
		LOGGER.debug("Employee : {}", emp.toString());
	}
	
	static void getEmployeeController() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EmployeeController employeeController = context.getBean("controller", EmployeeController.class);
		LOGGER.debug("EmployeeController : {}", employeeController);
		LOGGER.info("END");
	}
	
}
