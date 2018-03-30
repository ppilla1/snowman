package org.brainfreeze.snowman;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.ibatis.type.MappedTypes;
import org.brainfreeze.snowman.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@MappedTypes({User.class})
@MapperScan({"org.brainfreeze.snowman.mapper"})
@SpringBootApplication
public class SnowmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnowmanApplication.class, args);
	}

	@Bean
	@Profile({"master"})
	public SpringLiquibase liquibase(@Autowired  DataSource dataSource,
									 @Value("${spring.liquibase.change-log}") String changeLogFile)  {
		SpringLiquibase liquibase = new SpringLiquibase();

		liquibase.setDataSource(dataSource);
		liquibase.setChangeLog(changeLogFile);

		return liquibase;
	}

	@Bean
	@Profile({"integration"})
	public SpringLiquibase liquibaseIntegration(@Autowired  DataSource dataSource,
												@Value("${spring.liquibase.change-log}") String changeLogFile)  {
		SpringLiquibase liquibase = new SpringLiquibase();

		liquibase.setDataSource(dataSource);
		liquibase.setChangeLog(changeLogFile);

		return liquibase;
	}

}
