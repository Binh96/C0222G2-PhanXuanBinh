package com.pxb.repository;

import com.pxb.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
}
