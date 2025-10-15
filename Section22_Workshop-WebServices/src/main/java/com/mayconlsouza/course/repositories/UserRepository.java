package com.mayconlsouza.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayconlsouza.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

    
    
}
