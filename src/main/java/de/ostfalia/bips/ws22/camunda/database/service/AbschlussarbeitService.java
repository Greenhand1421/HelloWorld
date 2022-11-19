package de.ostfalia.bips.ws22.camunda.database.service;

import de.ostfalia.bips.ws22.camunda.database.domain.Antrag;
import de.ostfalia.bips.ws22.camunda.database.domain.Abschlussarbeit;
import de.ostfalia.bips.ws22.camunda.database.repository.AbschlussarbeitRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AbschlussarbeitService {
    private final AbschlussarbeitRepository repository;

    public AbschlussarbeitService(AbschlussarbeitRepository repository) {
        this.repository = repository;
    }

    public AbschlussarbeitRepository getRepository() {
        return repository;
    }

    public List<Abschlussarbeit> findAllByAntrag(Antrag antrag) {
        if (antrag == null) {
            return Collections.emptyList();
        }

        return repository.findAllByAntrag(antrag);
    }
}