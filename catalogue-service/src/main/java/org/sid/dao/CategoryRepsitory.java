package org.sid.dao;

import org.sid.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepsitory extends JpaRepository<Category,Long> {

}
