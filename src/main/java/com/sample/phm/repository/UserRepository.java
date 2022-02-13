package com.sample.phm.repository;

//import com.sample.phm.entity.Company;
import com.sample.phm.entity.User;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM user u where u.email = ?1")
    User findByEmail(String email);
}
