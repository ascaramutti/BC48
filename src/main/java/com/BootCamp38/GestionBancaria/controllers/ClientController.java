package com.BootCamp38.GestionBancaria.controllers;

import com.BootCamp38.GestionBancaria.services.ClientService;
import com.BootCamp38.model.Client;
import com.BootCamp38.rest.contract.ClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ClientController implements ClientApi {

    @Autowired
    private ClientService clientService;

    @Override
    public Mono<ResponseEntity<Client>> addClient(Mono<Client> client, ServerWebExchange exchange) {
        System.out.println("control addClient");
        return client
                .flatMap(entry -> clientService.addClient(entry))
                .map(clientRSP -> ResponseEntity.ok(clientRSP));
    }

    @Override
    public Mono<ResponseEntity<Flux<Client>>> getClients(ServerWebExchange exchange) {
        System.out.println("control getClients");
        return Mono.just(ResponseEntity.ok(clientService.getClients()));
    }

    @Override
    public Mono<ResponseEntity<Client>> updateClient(Mono<Client> client, ServerWebExchange exchange) {
        System.out.println("control updateClient");
        return client
                .flatMap(entry -> clientService.updateClient(entry))
                .map(clientRSP -> ResponseEntity.ok(clientRSP));
    }

    @Override
    public Mono<ResponseEntity<Client>> getClientByDocumentNumber(String documentNumber, ServerWebExchange exchange) {
        System.out.println("control getClientByDocumentNumber");
        return clientService.getClientByDocumentNumber(documentNumber)
                .map(clientRSP -> ResponseEntity.ok(clientRSP));
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteClientByDocumentNumber(String documentNumber, ServerWebExchange exchange) {
        System.out.println("Control deleteClientByDocumentNumber");
        return clientService.deleteClientByDocumentNumber(documentNumber)
                .map(clientRSP-> new ResponseEntity<Void>(HttpStatus.NO_CONTENT));
    }
}
