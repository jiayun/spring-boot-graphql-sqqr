package com.igu.developer.demo;

import com.igu.developer.demo.model.Custom;
import com.igu.developer.demo.service.CustomService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarService carService, CustomService customService) {
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
				Car car = new Car();
				car.setName(name);
				carService.saveCar(car);
			});
			carService.getCars().forEach(System.out::println);

			Stream.of("公司1", "公司2").forEach(name -> {
				Custom custom = new Custom();
				custom.setName(name);
				customService.save(custom);
			});
			customService.getCustoms().forEach(System.out::println);
		};
	}
}

