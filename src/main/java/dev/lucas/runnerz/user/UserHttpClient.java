package dev.lucas.runnerz.user;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

// With this we will set and build a baseUrl on the ApplicationClass
// After that we just need to declare an interface and Spring will transform into a a implementation at runtime
public interface UserHttpClient {

    @GetExchange("/users")
    List<User> findAll();

    @GetExchange("/users/{id}")
    User findById(@PathVariable Integer id);
}
