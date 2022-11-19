package de.ostfalia.bips.ws22.camunda.database.repository;

import de.ostfalia.bips.ws22.camunda.database.domain.Antrag;
import de.ostfalia.bips.ws22.camunda.database.domain.Abschlussarbeit;

import de.ostfalia.bips.ws22.camunda.database.domain.Keyword;
import de.ostfalia.bips.ws22.camunda.database.domain.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbschlussarbeitRepository extends JpaRepository<Abschlussarbeit, Integer> {
    @Query("SELECT DISTINCT ab FROM Abschlussarbeit ab" +
            "INNER JOIN Antrag a ON ab.id.antrag = a " +//id到底是谁的id?
            "WHERE ab.antrag = :antrag ")
    List<Abschlussarbeit> findAllByAntrag(@Param("antrag") Antrag antrag);
}