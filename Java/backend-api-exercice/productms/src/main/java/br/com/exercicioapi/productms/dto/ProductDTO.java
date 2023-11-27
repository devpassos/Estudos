package br.com.exercicioapi.productms.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {
    
    @Size(min = 50)
    private String name;

    private String description;
    
    @Positive
    private double price;
    
    private boolean available;
    
}
