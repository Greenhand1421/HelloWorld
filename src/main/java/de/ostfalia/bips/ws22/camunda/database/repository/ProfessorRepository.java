package de.ostfalia.bips.ws22.camunda.database.repository;

import de.ostfalia.bips.ws22.camunda.database.domain.Professor;
import de.ostfalia.bips.ws22.camunda.database.domain.Stichpunkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    @Query("SELECT DISTINCT p FROM Professor p" +
            "INNER JOIN Professor_hat_stichpunkt phs ON phs.id.professor = p " +
            "WHERE phs.id.stichpunkt = :stichpunkt " +
            "ORDER BY p.nachname")
    List<Professor> findAllByStichpunkt(@Param("stichpunkt")Stichpunkt stichpunkt);
}
