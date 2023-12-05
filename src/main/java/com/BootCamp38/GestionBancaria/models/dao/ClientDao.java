package com.BootCamp38.GestionBancaria.models.dao;

import com.BootCamp38.GestionBancaria.models.documents.ClientDocument;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ClientDao extends ReactiveCrudRepository<ClientDocument, String> {
    Mono<Boolean> existsByDocumentNumber (String documentNumber);
    Mono<ClientDocument> findByDocumentNumber (String documentNumber);
}
