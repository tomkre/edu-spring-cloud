package cz.tomkre.edu.spring;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface DeveloperRepository extends ListCrudRepository<Developer, String> {
    @Transactional
    @Modifying
    @Query("update Developer d set d.level = d.level + 1")
    void increment(String name);
}
