package com.soa.remboursement.repository;

import com.soa.remboursement.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeDao extends JpaRepository<Demande, Long> {

    //crud methodes
    List<Demande> findByNom(String nom);

}
