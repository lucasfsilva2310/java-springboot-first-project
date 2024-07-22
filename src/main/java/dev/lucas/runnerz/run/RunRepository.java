package dev.lucas.runnerz.run;

import java.util.List;
import java.util.Optional;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import jakarta.annotation.PostConstruct;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class RunRepository {

    // private static final Logger LOG =
    // LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;

    // Jdbc CLient to talk to database
    // If we import this instance it will automatically create a connection
    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM Run").query(Run.class).list();
    }

    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT id, title, started_on, completed_on, miles, location FROM Run WHERE id = :id")
                .param("id", id)
                .query(Run.class) // Map result into a Run class after running query
                .optional();
    }

    public void create(Run run) {
        var updated = jdbcClient // Returns number of rows updated
                .sql("INSERT INTO Run(title, started_on, completed_on, miles, location) values(?, ?, ?, ?, ?)")
                .params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(),
                        run.location().toString()))
                .update();

        Assert.state(updated == 1, "Failed to create run" + run.title()); // If its not true, return Ilegal argument
                                                                          // expression and string
    }

    public void update(Run run, Integer id) {
        var updated = jdbcClient
                .sql("UPDATE Run SET title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? WHERE id = ?")
                .params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(),
                        id))
                .update();

        Assert.state(updated == 1, "Failed to update run" + run.title());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM Run WHERE id = ?").param("id", id).update();

        Assert.state(updated == 1, "Failed to delete run: " + id);
    }

    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("SELECT * FROM Run WHERE location = ?").param("location", location).query(Run.class)
                .list();
    }

    public long count() {
        return jdbcClient.sql("SELECT COUNT(*) FROM Run")
                .query((runs, rowNum) -> runs.getLong(1))
                .single();
    }

    public void saveAll(List<Run> runs) {
        for (Run run : runs) {
            this.create(run);
        }
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
