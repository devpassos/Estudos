package br.com.exercicioapi.productms.dto;

import lombok.Data;

@Data
public class ProdutcDTO {
    
    private String name;
    private String description;
    private double price;
    private boolean available;
    
}
