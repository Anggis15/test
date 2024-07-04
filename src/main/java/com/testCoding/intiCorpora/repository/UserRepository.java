package com.testCoding.intiCorpora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testCoding.intiCorpora.Entity.UserProfile;
@Repository
public interface UserRepository extends JpaRepository<UserProfile,String>{

}
