package dev.lucas.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import dev.lucas.runnerz.user.UserHttpClient;

import dev.lucas.runnerz.user.User;

@SpringBootApplication
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		LOG.info("Application started successfully.");
	}

	// Declaring a userHttpClient build to be used as a bean
	// Will be user for UserHttpClient class
	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
				.build();
		return factory.createClient(UserHttpClient.class);
	}

	// Create a CommandLineRunner to execute before starting server
	// Testing Users http client
	@Bean
	CommandLineRunner runner(UserHttpClient client) {
		return args -> {
			User user = client.findById(1);
			LOG.info("User1: " + user.toString());
		};
	}
}
