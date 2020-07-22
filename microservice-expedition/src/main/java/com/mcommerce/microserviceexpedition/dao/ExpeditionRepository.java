package com.mcommerce.microserviceexpedition.dao;

import com.mcommerce.microserviceexpedition.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpeditionRepository extends JpaRepository<Expedition,Integer> {

}
