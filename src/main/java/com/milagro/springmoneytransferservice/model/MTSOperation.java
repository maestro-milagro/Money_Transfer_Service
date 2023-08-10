package com.milagro.springmoneytransferservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MTSOperation {
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private int transferAmount;
    private String currency;

    public MTSOperation(String cardFromNumber, String cardFromValidTill, String cardFromCVV, String cardToNumber,int transferAmount, String currency){
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.transferAmount = transferAmount;
        this.currency = currency;
    }

}
