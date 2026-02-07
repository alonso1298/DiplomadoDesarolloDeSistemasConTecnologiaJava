package mx.unam.dgtic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
public class M600Application {

	public static void main(String[] args) {
		SpringApplication.run(M600Application.class, args);
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//org.mariadb.jdbc.Driver
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//jdbc:mariadb://localhost:3306/modulo6
		dataSource.setUrl("jdbc:mysql://localhost:3306/modulo06");
		dataSource.setUsername("root");
		dataSource.setPassword("56457977Ac");
		return  dataSource;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
		LocalContainerEntityManagerFactoryBean emfb =
				new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emfb.setPackagesToScan("mx.unam.dgtic");

		Properties jpaProperties = new Properties();
		//org.hibernate.dialect.MariaDB103Dialect
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		emfb.setJpaProperties(jpaProperties);

		return emfb;
	}

	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				entityManagerFactory(dataSource()).getObject());
		return transactionManager;
	}

}
