package net.focik.taskcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
//@ComponentScan(basePackages = {"net.focik"})
@ComponentScan(basePackages = {"net.focik.gasconnection", "net.focik.gasmain", "net.focik.taskcalendar"})
public class TaskCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskCalendarApplication.class, args);
	}

}
