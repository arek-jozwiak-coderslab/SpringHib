package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {

}
