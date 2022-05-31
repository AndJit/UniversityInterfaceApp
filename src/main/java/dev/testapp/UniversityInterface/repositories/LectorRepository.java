package dev.testapp.UniversityInterface.repositories;

import dev.testapp.UniversityInterface.entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Integer> {

    Lector save(Lector lector);
    List<Lector> findAll();
}
