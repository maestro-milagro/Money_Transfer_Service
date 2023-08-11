package com.milagro.springmoneytransferservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MTSOperation {
    @Id
    private long id;
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private int transferAmount;
    private String currency;

}
