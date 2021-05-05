package net.focik.taskcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TaskCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskCalendarApplication.class, args);
	}

}
