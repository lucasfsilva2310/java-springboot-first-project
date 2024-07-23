package dev.lucas.runnerz.run;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

// We are Creating an interface based on ListCrudRepository
// What this means is that we can use it with any JdbcClient
// And ListCrudRepository has all cruds methods already created for us from spring data
public interface RunRepository extends ListCrudRepository<Run, Integer> {

    // How does the ListCrudRepository understands the method name?
    List<Run> findByLocation(Location location);

}
