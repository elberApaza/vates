package com.vates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vates.model.CurrentConditions;

@Repository
public interface CurrentConditionsRepository extends JpaRepository<CurrentConditions, Long>{

}
