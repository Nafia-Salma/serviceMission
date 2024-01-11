package com.soa.remboursement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Hebergement {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private String descption;
    private int Quantity;
    private float prixUnitaire;


}
