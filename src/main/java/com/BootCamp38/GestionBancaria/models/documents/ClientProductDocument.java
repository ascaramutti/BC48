package com.BootCamp38.GestionBancaria.models.documents;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@ToString
@Data
public class ClientProductDocument {
    private String clientProductId;
    private String typeProduct;
    private String accountNumber;
    private List<HolderAndSignerDocument> accountHolders;
    private List<HolderAndSignerDocument> authorizedSignatories;
    private Double accountBalance;
}
