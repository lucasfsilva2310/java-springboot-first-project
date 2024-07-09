package dev.lucas.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		final Logger LOG = LoggerFactory.getLogger(Application.class);

		SpringApplication.run(Application.class, args);
		LOG.info("Application started successfully.");
	}

}
