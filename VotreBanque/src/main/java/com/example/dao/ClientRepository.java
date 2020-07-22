package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Client;
import com.example.entities.Compte;
import com.example.entities.CompteCourant;
import com.example.entities.CompteEpargne;


public interface ClientRepository 
extends JpaRepository<Client, Long> {





}
