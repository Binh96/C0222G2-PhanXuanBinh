package com.pxb.springsecurity.repository;

import com.pxb.springsecurity.model.AppRole;
import com.pxb.springsecurity.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AppRoleRepository{

}
