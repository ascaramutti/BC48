package com.BootCamp38.GestionBancaria.models.documents;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class HolderAndSignerDocument {
    private String holderAndSignerId;
    private String name;
    private String documentNumber;
}
