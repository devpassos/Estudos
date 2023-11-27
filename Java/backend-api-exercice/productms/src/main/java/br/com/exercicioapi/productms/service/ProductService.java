package br.com.exercicioapi.productms.service;

import java.util.List;
import java.util.Optional;

import br.com.exercicioapi.productms.dto.ProductDTO;


public interface ProductService {

    Optional<ProductDTO> create(ProductDTO request);

    List<ProductDTO> getAll();

    Optional<ProductDTO> getById(Long id);

    boolean inactive(Long id);    
}

