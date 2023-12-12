package com.BootCamp38.GestionBancaria.services.business;

import com.BootCamp38.GestionBancaria.models.dao.ClientDao;
import com.BootCamp38.GestionBancaria.models.documents.ClientDocument;
import com.BootCamp38.GestionBancaria.services.mapper.ClientMapper;
import com.BootCamp38.model.Client;
import com.BootCamp38.model.ClientProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class ClientBusiness {

    @Autowired
    ClientDao clientDao;
    @Autowired
    ClientMapper clientMapper;

    public Mono<Client> clientExist (Boolean response, Client client){
        return response
                ? (validateNewProductClient(client.getClientProducts(), client.getClientType())
                    ? getClientToUpdate(client)
                .flatMap(clientDocument -> clientDao.save(clientDocument))
                    .map(clientMapper::toClient)
                    : Mono.error(new RuntimeException("Producto ya existente")))
                :Mono.error(new RuntimeException("Cliente no existe"));
    }

    public Mono<Client> clientNotExist (Boolean response, Client client){
        return !response
                ? (validateNewProductClient(client.getClientProducts(), client.getClientType())
                    ? clientDao.save(clientMapper.toClientDocument(client))
                        .map(clientMapper::toClient)
                    : Mono.error(new RuntimeException("Producto no permitido")))
                : Mono.error(new RuntimeException("Cliente ya existe"));
    }

    private Boolean validateNaturalPerson (List<ClientProduct> clientProductList){
        return clientProductList.stream()
                .collect(Collectors.groupingBy(ClientProduct::getTypeProduct,
                        Collectors.counting()))
                .values()
                .stream().allMatch(a -> a < 2)
                && clientProductList.stream()
                .anyMatch(clientProduct -> clientProduct.getAccountHolders().isEmpty());
    }

    private Boolean validateCompany (List<ClientProduct> clientProductList) {
        System.out.println("validateCompany");
        return clientProductList.stream().noneMatch(filteringClient())
                && clientProductList.stream()
                .anyMatch(clientProduct -> (long) clientProduct.getAccountHolders().size() > 0);
    }

    private Predicate<ClientProduct> filteringClient (){
        System.out.println("filteringClient");
        return clientProduct -> clientProduct.getTypeProduct().equalsIgnoreCase("fixedTerm")
                || clientProduct.getTypeProduct().equalsIgnoreCase("savings");
    }

    private Boolean validateNewProductClient (List<ClientProduct> clientProductList, String clientType) {
                return clientType.equalsIgnoreCase("naturalPerson")
                        ? validateNaturalPerson(clientProductList) : validateCompany(clientProductList);

    }

    private Mono<ClientDocument> getClientToUpdate (Client client){
        return clientDao.findByDocumentNumber(client.getDocumentNumber())
                .map(clientDocument ->{
                            clientDocument.setClientProducts(clientMapper
                                    .toClientProductDocument(client.getClientProducts()));
                            return clientDocument;
                        }
                        );
    }


}
