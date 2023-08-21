package com.milagro.springmoneytransferservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MTSOperation {
    @Id
    @SequenceGenerator(
            name = "operation_sequence",
            sequenceName = "operation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "operation_sequence"
    )
    private long id;
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private int transferAmount;
    private String currency;
    @JsonProperty("amount")
    private void unpackAmount(Map amount){
        this.transferAmount = (int) amount.get("value");
        this.currency = (String) amount.get("currency");
    }


}
