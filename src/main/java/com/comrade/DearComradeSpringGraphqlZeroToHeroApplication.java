package com.comrade;

import com.comrade.service.GraphQlService;
import com.comrade.service.ShowService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DearComradeSpringGraphqlZeroToHeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(DearComradeSpringGraphqlZeroToHeroApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(GraphQlService graphQlService, ShowService showService){
		return args->{
			//graphQlService.comradeById(408);
			showService.getShows();
		};

	}

}
