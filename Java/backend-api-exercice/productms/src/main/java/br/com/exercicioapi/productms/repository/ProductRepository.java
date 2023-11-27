package br.com.exercicioapi.productms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.exercicioapi.productms.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    
} 
