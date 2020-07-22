package com.mcommerce.microserviceexpedition.controller;

import com.mcommerce.microserviceexpedition.dao.ExpeditionRepository;
import com.mcommerce.microserviceexpedition.exceptions.ExpeditionIntrouvableException;
import com.mcommerce.microserviceexpedition.model.Expedition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Api( description="API pour es opérations CRUD sur les expeditions.")
@RestController
public class ExpeditionController {


    @Autowired
    ExpeditionRepository expeditionRepository;

    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/expedition")
    public List<Expedition> listeDesExpeditions()  {

        List<Expedition> expedition = expeditionRepository.findAll();

        if (expedition.isEmpty()) throw new ExpeditionIntrouvableException("Aucun expeditions n'est disponible ");


        return expedition;

    }

    //Récuperer un produit par son id
    @ApiOperation(value = "Récupère un id d'expedition et leurs attributs")
    @GetMapping( value = "/expedition/{id}")
    public Optional<Expedition> recupererUnProduit(@PathVariable int id){

        Optional<Expedition> expedition = expeditionRepository.findById(id);

        if(!expedition.isPresent()) throw new ExpeditionIntrouvableException("Le expedition avec l'id " + id + " est INTROUVABLE");
        return expedition;
    }

    @PostMapping("/expedition/save")
    public Expedition save (@RequestBody Expedition expedition){

        return expeditionRepository.save(expedition);
    }

    @PutMapping("/expedition/update/{id}")
    public Expedition update (@RequestBody Expedition expedition, @PathVariable int id){

        expedition.setId(id);
        return expeditionRepository.saveAndFlush(expedition);
    }


}