package de.ostfalia.bips.ws22.camunda.database.service;

import de.ostfalia.bips.ws22.camunda.database.domain.Antrag;
import de.ostfalia.bips.ws22.camunda.database.domain.Studierender;
import de.ostfalia.bips.ws22.camunda.database.domain.Professor;
import de.ostfalia.bips.ws22.camunda.database.repository.AntragRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AntragService {
    private final AntragRepository repository;

    public AntragService(AntragRepository repository) {
        this.repository = repository;
    }

    public AntragRepository getRepository() {
        return repository;
    }

    public List<Antrag> findAllByProfessorStudierender(Professor professor, Studierender studierender) {
        if (professor == null&&studierender==null) {
            return Collections.emptyList();
        }

        return repository.findAllByProfessorStudierender(professor,studierender);
    }
}