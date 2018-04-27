package br.com.alura.loja;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@SpringBootApplication
public class LojaApplication {

	private static ConfigurableApplicationContext run;

	public static void main(final String[] args) {
		inicia();
	}

	static void inicia() {
		run = SpringApplication.run(LojaApplication.class, "");
	}

	static void termina() {
		run.stop();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource,
			final Properties aditionalProperties) {
		final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setPackagesToScan("br.com.alura.loja.modelo");
		factoryBean.setDataSource(dataSource);

		final JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setJpaProperties(aditionalProperties);

		return factoryBean;

	}

	@Bean
	public Properties aditionalProperties() {
		final Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		return props;
	}

	@Bean
	public JpaTransactionManager transactionManager(final EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
