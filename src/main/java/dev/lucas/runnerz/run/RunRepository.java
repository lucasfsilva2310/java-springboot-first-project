package dev.lucas.runnerz.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    // Find By Id
    Run findById(Integer id) {
        return runs.stream().filter(run -> run.id().equals(id)).findFirst().orElse(null);
    }

    // Find All
    List<Run> findAll() {
        return runs;
    }

    // Run after depency injection. Type of initialization. Good for DB in memory
    // for testing
    @PostConstruct
    public void init() {
        runs.add(new Run(1, "Run 1", LocalDateTime.now(), LocalDateTime.now(), 10, Location.INDOOR));
        runs.add(new Run(2, "Run 2", LocalDateTime.now(), LocalDateTime.now(), 20, Location.OUTDOOR));
    }
}
