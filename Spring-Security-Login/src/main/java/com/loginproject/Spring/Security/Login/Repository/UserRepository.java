package com.loginproject.Spring.Security.Login.Repository;

import com.loginproject.Spring.Security.Login.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
User findByUserName(String username);

}
