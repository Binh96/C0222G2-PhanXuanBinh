package com.repository;

import com.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartPhoneRepository extends CrudRepository<SmartPhone, Integer> {
}
