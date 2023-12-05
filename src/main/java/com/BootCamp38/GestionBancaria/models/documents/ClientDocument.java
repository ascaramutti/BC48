package com.BootCamp38.GestionBancaria.models.documents;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@ToString
@Data
@Document(collection = "client")
public class ClientDocument {
    private ObjectId _id;
    private String clientId;
    private String name;
    private String documentNumber;
    private String clientType;
    private List<ClientProductDocument> clientProduct;
}
