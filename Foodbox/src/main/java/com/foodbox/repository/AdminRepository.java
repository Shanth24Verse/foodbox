package com.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
