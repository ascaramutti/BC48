package com.BootCamp38.GestionBancaria.services.impl;

import com.BootCamp38.GestionBancaria.models.dao.ClientDao;
import com.BootCamp38.GestionBancaria.models.documents.ClientDocument;
import com.BootCamp38.GestionBancaria.models.documents.ClientProductDocument;
import com.BootCamp38.GestionBancaria.models.documents.HolderAndSignerDocument;
import com.BootCamp38.GestionBancaria.services.ClientService;
import com.BootCamp38.GestionBancaria.services.business.ClientBusiness;
import com.BootCamp38.GestionBancaria.services.mapper.ClientMapper;
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

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    ClientBusiness clientBusiness;

    @Override
    public Mono<Client> addClient(Client client) {
        System.out.println("Services addClient");
        return clientDao.existsByDocumentNumber(client.getDocumentNumber())
                .flatMap(exist-> clientBusiness.clientNotExist(exist, client));
    }

    @Override
    public Flux<Client> getClients() {
        System.out.println("Services getClients");
        return clientDao.findAll().map(clientMapper::toClient);
    }

    @Override
    public Mono<Client> updateClient(Client client) {
        System.out.println("Services updateClient");
        return clientDao.existsByDocumentNumber(client.getDocumentNumber())
                .flatMap(exist-> clientBusiness.clientExist(exist, client));
    }

    @Override
    public Mono<Client> getClientByDocumentNumber(String documentNumber) {
        System.out.println("services getClientByDocumentNumber");
        return null;
    }

    @Override
    public Mono<Void> deleteClientByDocumentNumber(String documentNumber) {
        System.out.println("services deleteClientByDocumentNumber");
        return null;
    }


}
