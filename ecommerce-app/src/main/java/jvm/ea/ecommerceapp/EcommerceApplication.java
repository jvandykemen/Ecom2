package jvm.ea.ecommerceapp;//package jvm.ea.ecommerceapp;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//import javax.sql.DataSource;
//
//@SpringBootApplication
//@EnableJpaRepositories(basePackages = "jvm.ea.ecommerceapp.repository")
//@EntityScan(basePackages = "jvm.ea.ecommerceapp.model")
//@ComponentScan(basePackages = "jvm.ea.ecommerceapp.model")
//public class EcommerceApplication {
//
//	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(EcommerceApplication.class, args);
//
//		// Access the DataSource bean
//		DataSourceConfig dataSource = context.getBean(DataSourceConfig.class);
//	}
//
//}
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;


@SpringBootApplication(scanBasePackages = "jvm.ea.ecommerceapp")
public class EcommerceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EcommerceApplication.class, args);

		// Access the DataSource bean without assigning it to a variable
	}
}