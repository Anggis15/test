package com.testCoding.intiCorpora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testCoding.intiCorpora.Entity.Contact;
import com.testCoding.intiCorpora.model.dto.DtoAddressByUser;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String>{
    @Query(value = "select c.id, c.address from contacts as c where user_id = ?1", nativeQuery = true)
    List<DtoAddressByUser> findAllByUserId(String userId);
    

}
