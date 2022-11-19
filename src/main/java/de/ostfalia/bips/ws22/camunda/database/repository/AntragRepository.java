package de.ostfalia.bips.ws22.camunda.database.repository;

import de.ostfalia.bips.ws22.camunda.database.domain.Antrag;
import de.ostfalia.bips.ws22.camunda.database.domain.Professor;
import de.ostfalia.bips.ws22.camunda.database.domain.Studierender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AntragRepository extends JpaRepository<Antrag, Integer> {
    @Query("SELECT  DISTINCT a FROM" +
            "(Antrag a LEFT JOIN Professor p ON a.professor.id = p.id ) LEFT JOIN Studierender s ON a.studierender.id = s.id "+
            "WHERE s.keyword = :keyword " +
            "OR shk.id.keyword = :keyword " +
            "ORDER BY s.name")
    List<Antrag> findAllByProfessorStudirender(@Param("professor")Professor professor, @Param("studierender")Studierender studierender);
}
