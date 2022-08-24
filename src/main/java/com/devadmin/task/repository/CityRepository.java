package com.devadmin.task.repository;

import com.devadmin.task.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CityRepository extends CrudRepository<City,Long> {
    //public String query(String queryString);
    
}
