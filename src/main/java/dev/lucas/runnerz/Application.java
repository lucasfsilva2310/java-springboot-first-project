package dev.lucas.runnerz;

// import dev.lucas.runnerz.run.*;
// import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import dev.lucas.runnerz.run.Run;

@SpringBootApplication
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		LOG.info("Application started successfully.");
	}

	// Create a CommandLineRunner to execute before starting server
	// @Bean
	// CommandLineRunner runner() {
	// return args -> {
	// Run run = new Run(1, "Run 1", LocalDateTime.now(), LocalDateTime.now(), 10,
	// Location.INDOOR);

	// LOG.info("Run: " + run);
	// };
	// }
}
