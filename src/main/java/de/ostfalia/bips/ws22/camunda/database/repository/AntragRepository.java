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
            "(Antrag a INNER JOIN Professor p ON a.professor = p ) INNER JOIN Studierender s ON a.studierender = s "+
            "WHERE a.professor = :professor " +
            "AND a.studierender = :studierender ")
    List<Antrag> findAllByProfessorStudierender(@Param("professor")Professor professor, @Param("studierender")Studierender studierender);
}
