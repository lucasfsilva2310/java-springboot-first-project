package dev.lucas.runnerz.run;

import java.util.List;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class RunRepository {

    private static final Logger LOG = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;

    // Jdbc CLient to talk to database
    // If we import this instance it will automatically create a connection
    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM Run").query(Run.class).list();
    }

    // ALL CODE RELATED TO RUNNING IN-MEMORY DATABASE WITHOUT NEEDING A DATABASE
    // CONNECTION

    // private List<Run> runs = new ArrayList<>();
    // // Find By Id
    // Optional<Run> findById(Integer id) {
    // return runs.stream().filter(run -> run.id().equals(id)).findFirst();
    // }

    // // Find All
    // List<Run> findAll() {
    // return runs;
    // }

    // // Create
    // void create(Run run) {
    // runs.add(run);
    // }

    // // Update
    // void update(Run run, Integer id) {
    // Optional<Run> runOptional = this.findById(id);

    // if (runOptional.isPresent()) {
    // runs.set(runs.indexOf(runOptional.get()), run);
    // }
    // }

    // // Delete
    // void delete(Integer id) {
    // runs.removeIf(run -> run.id().equals(id));
    // }

    // // Run after depency injection. Type of initialization. Good for DB in memory
    // // for testing
    // @PostConstruct
    // public void init() {
    // runs.add(new Run(1, "Run 1", LocalDateTime.now(), LocalDateTime.now(), 10,
    // Location.INDOOR));
    // runs.add(new Run(2, "Run 2", LocalDateTime.now(), LocalDateTime.now(), 20,
    // Location.OUTDOOR));
    // }
}
