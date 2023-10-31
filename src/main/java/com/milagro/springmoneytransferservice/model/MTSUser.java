package com.milagro.springmoneytransferservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table
public class MTSUser {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long userId;
    private String firstName;
    private String lastName;
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String accessCode;
}
