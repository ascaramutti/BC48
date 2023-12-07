package com.BootCamp38.GestionBancaria.services.mapper;

import com.BootCamp38.GestionBancaria.models.documents.ClientDocument;
import com.BootCamp38.GestionBancaria.models.documents.ClientProductDocument;
import com.BootCamp38.model.Client;
import com.BootCamp38.model.ClientProduct;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDocument toClientDocument(Client client);

    Client toClient (ClientDocument client);

    List<ClientProductDocument> toClientProductDocument (List<ClientProduct> clientProduct);

    List<ClientProduct> toClientProduct (List<ClientProductDocument> clientProductDocument);

}
