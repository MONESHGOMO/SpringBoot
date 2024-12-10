package com.gomocodes.APIwithSpringBoot.repositoryLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gomocodes.APIwithSpringBoot.model.Electronics;

@Repository
public interface ProductRepository  extends JpaRepository<Electronics,Long> {

}
