package com.BootCamp38.GestionBancaria.services;

import com.BootCamp38.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Mono<Client> addClient (Client client);
    Flux<Client> getClients ();
    Mono<Client> updateClient (Client client);
    Mono<Client> getClientByDocumentNumber (String documentNumber);
    Mono<Void> deleteClientByDocumentNumber (String documentNumber);

}
