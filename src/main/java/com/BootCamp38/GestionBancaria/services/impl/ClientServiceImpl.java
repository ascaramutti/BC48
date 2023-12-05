package com.BootCamp38.GestionBancaria.services.impl;

import com.BootCamp38.GestionBancaria.models.dao.ClientDao;
import com.BootCamp38.GestionBancaria.models.documents.ClientDocument;
import com.BootCamp38.GestionBancaria.models.documents.ClientProductDocument;
import com.BootCamp38.GestionBancaria.models.documents.HolderAndSignerDocument;
import com.BootCamp38.GestionBancaria.services.ClientService;
import com.BootCamp38.model.Client;
import com.BootCamp38.model.ClientProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public Mono<Client> addClient(Client client) {
        System.out.println("Services addClient");
        return clientDao.existsByDocumentNumber(client.getDocumentNumber())
                .flatMap(exists-> !exists.booleanValue() ?
                        clientDao.save(ClientDocument.builder()
                                        .clientId(client.getClientId())
                                        .name(client.getName())
                                        .documentNumber(client.getDocumentNumber())
                                        .clientType(client.getClientType().getValue())
                                        .clientProduct(Optional.ofNullable(client.getClientProduct())
                                                .orElse(Collections.emptyList())
                                                .stream().map(clientProduct->
                                                        ClientProductDocument.builder()
                                                                .clientProductId(clientProduct.getClientProductId())
                                                                .typeProduct(clientProduct.getTypeProduct().getValue())
                                                                .accountNumber(clientProduct.getAccountNumber())
                                                                .accountBalance(clientProduct.getAccountBalance())
                                                                .accountHolders(Optional.ofNullable(clientProduct.getAccountHolders())
                                                                        .orElse(Collections.emptyList())
                                                                        .stream().map(accountHolder ->
                                                                                HolderAndSignerDocument.builder()
                                                                                        .holderAndSignerId(accountHolder.getHolderAndSignerId())
                                                                                        .name(accountHolder.getName())
                                                                                        .documentNumber(accountHolder.getDocumentNumber())
                                                                                        .build())
                                                                        .collect(Collectors.toList()))
                                                                .authorizedSignatories(Optional.ofNullable(clientProduct.getAuthorizedSignatories())
                                                                        .orElse(Collections.emptyList())
                                                                        .stream().map(authorizedSignatory->
                                                                                HolderAndSignerDocument.builder()
                                                                                        .holderAndSignerId(authorizedSignatory.getHolderAndSignerId())
                                                                                        .name(authorizedSignatory.getName())
                                                                                        .documentNumber(authorizedSignatory.getDocumentNumber())
                                                                                        .build())
                                                                        .collect(Collectors.toList()))
                                                                .build())
                                                .collect(Collectors.toList()))
                                        .build())
                                .map(entry -> Client.builder()
                                        .clientId(entry.getClientId())
                                        .name(entry.getName())
                                        .documentNumber(entry.getDocumentNumber())
                                        .clientType(Client.ClientTypeEnum.fromValue(entry.getClientType()))
                                        .build()):Mono.error(new RuntimeException("Error en grabado"))
                );
    }

    @Override
    public Flux<Client> getClients() {
        System.out.println("Services getClients");
        return clientDao.findAll()
                .map(entry -> Client.builder()
                        .clientId(entry.getClientId())
                        .name(entry.getName())
                        .documentNumber(entry.getDocumentNumber())
                        .clientType(Client.ClientTypeEnum.fromValue(entry.getClientType()))
                        .build());
    }

    @Override
    public Mono<Client> updateClient(Client client) {
        System.out.println("Services updateClient");
        return clientDao.existsByDocumentNumber(client.getDocumentNumber())
                .flatMap(exists -> {
                    if(exists.booleanValue()){
                        return clientDao.findByDocumentNumber(client.getDocumentNumber())
                                .flatMap(objectRecovered -> {
                                    objectRecovered.setClientId(client.getClientId());
                                    objectRecovered.setName(client.getName());
                                    objectRecovered.setDocumentNumber(client.getDocumentNumber());
                                    objectRecovered.setClientId(client.getClientType().getValue());
                                    return clientDao.save(objectRecovered)
                                            .map(entry -> Client.builder()
                                                    .clientId(entry.getClientId())
                                                    .name(entry.getName())
                                                    .documentNumber(entry.getDocumentNumber())
                                                    .clientType(Client.ClientTypeEnum.fromValue(entry.getClientType()))
                                                    .build());
                                });
                    }
                    else {
                        return Mono.error(new RuntimeException("Error en grabado, numero de documento ya registrado"));
                    }
                });
    }

    @Override
    public Mono<Client> getClientByDocumentNumber(String documentNumber) {
        System.out.println("services getClientByDocumentNumber");
        return clientDao.findByDocumentNumber(documentNumber)
                .map(entry -> Client.builder()
                        .clientId(entry.getClientId())
                        .name(entry.getName())
                        .documentNumber(entry.getDocumentNumber())
                        .clientType(Client.ClientTypeEnum.fromValue(entry.getClientType()))
                        .build());
    }

    @Override
    public Mono<Void> deleteClientByDocumentNumber(String documentNumber) {
        System.out.println("services deleteClientByDocumentNumber");
        return clientDao.findByDocumentNumber(documentNumber)
                .flatMap(objectRecovered -> clientDao.delete(objectRecovered));
    }


}
