package com.soa.remboursement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Demande{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String objetMission;
    private Date dateDepart;
    private Date dateRetour;
    private String VehiculeUsed;
    private Status statut = Status.EN_COURS;

    //il faut appeler le service d'authentification pour extraire the current user_id
    private  Long RefDemandeur;

    //il faut appeler le service de mission pour extraire the current mission_id
    private  Long RefMission;

    @OneToMany(targetEntity = Hebergement.class, cascade = CascadeType.ALL)
    @JoinColumn(name="Fk_Ref_Dmn", referencedColumnName = "id")
    private List<Hebergement> RefHebergement;

    @OneToMany(targetEntity = Repas.class, cascade = CascadeType.ALL)
    @JoinColumn(name="Fk_Ref_Dmn", referencedColumnName = "id")
    private List<Repas> RefRepas;

    @OneToMany(targetEntity = Deplacement.class, cascade = CascadeType.ALL)
    @JoinColumn(name="Fk_Ref_Dmn", referencedColumnName = "id")
    private List<Deplacement> RefDeplacement;

}
