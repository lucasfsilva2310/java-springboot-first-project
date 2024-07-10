package dev.lucas.runnerz.run;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime endedOn,
        Integer miles,
        Location location) {
}