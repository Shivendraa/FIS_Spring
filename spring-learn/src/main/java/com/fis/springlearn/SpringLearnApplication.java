package com.fis.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();
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
		LOGGER.debug("Country : {}", country.toString());
	}
}
