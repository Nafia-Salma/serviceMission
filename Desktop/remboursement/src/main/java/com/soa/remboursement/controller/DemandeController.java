package com.soa.remboursement.controller;

import com.soa.remboursement.exception.RessourceNotFoundException;
import com.soa.remboursement.model.Demande;
import com.soa.remboursement.model.Status;
import com.soa.remboursement.repository.DemandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Demandes_Remboursements")
public class DemandeController {
    //build Api

    @Autowired
    private DemandeDao demandeDao;


    //////////////////////////select *
    @GetMapping("/GetAll")
    public List<Demande> getAllDemande(){
        return demandeDao.findAll();
    }

    //////////////////////////select where id =
    @GetMapping("/GetById/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable Long id){
        Demande demande = demandeDao.findById(id).orElseThrow(() -> new RessourceNotFoundException("Employee with id " + id + "does not exist"));
        return ResponseEntity.ok(demande);
    }

    //////////////////////////select where nom=
    @GetMapping("/GetByName/{nom}")
    public ResponseEntity<List<Demande>> getDemandeByName(@PathVariable String nom){
        return new ResponseEntity<List<Demande>>(demandeDao.findByNom(nom), HttpStatus.OK);
    }


    ////////////////////////////insert into
    @PostMapping("/Create")
    public Demande createDemande(@RequestBody Demande demande){ //the requestBody convert json to java object
        return demandeDao.save(demande);
    }


    //////////////////////////////update status demande to valid
    @PutMapping("/2valid/{id}")
    public ResponseEntity<Demande> updateStatutDmd2valid(@PathVariable Long id){
        Demande updatedDemande = demandeDao.findById(id).orElseThrow(() -> new RessourceNotFoundException("Employee with id " + id + "does not exist"));
        updatedDemande.setStatut(Status.VALIDE);

        demandeDao.save(updatedDemande);

        return ResponseEntity.ok(updatedDemande);

    }

    //////////////////////////////update status demande to reject
    @PutMapping("/2reject/{id}")
    public ResponseEntity<Demande> updateStatutDmd2reject(@PathVariable Long id){
        Demande updatedDemande = demandeDao.findById(id).orElseThrow(() -> new RessourceNotFoundException("Employee with id " + id + "does not exist"));
        updatedDemande.setStatut(Status.REJETE);

        demandeDao.save(updatedDemande);

        return ResponseEntity.ok(updatedDemande);

    }



    ///////////////////////////////delet demande
    @DeleteMapping("/DeleteById/{id}")
    public ResponseEntity<HttpStatus> deleteDemande(@PathVariable Long id){

        Demande demande = demandeDao.findById(id).orElseThrow(() -> new RessourceNotFoundException("Employee with id " + id + "does not exist"));

        demandeDao.delete(demande);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
