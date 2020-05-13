package com.training.project102.repository;

import com.training.project102.model.Names;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NameRepository extends CrudRepository<Names, String> {

}