package br.com.exercicioapi.productms.service;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exercicioapi.productms.dto.ProductDTO;
import br.com.exercicioapi.productms.model.Product;
import br.com.exercicioapi.productms.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private static ModelMapper mapper = new ModelMapper(); // Instanciando um objeto mapper para ser usando nos métodos.

    @Autowired
    private ProductRepository repository;
  
    @Override
    public Optional<ProductDTO> create(ProductDTO request) {

        /**
         * O trecho de código abaico instancia uma variável product, a qual será do tipo Product.
         * Essa variável terá os valores do objeto preenchido através do request.
         * Abaixo estou "setando" cada campo individualmente.
         * Existe uma maneira mais "limpa de se fazer isso que virá logo depois".
         **/
        Product product = new Product(); // Instanciando product sem o mapper.
        
        /* "Setando" cada campo individualmente */
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setAvailable(request.isAvailable());
       
        // repository.saveAndFlush(product); // Trecho comentando para que não seja salvo duas vezes no banco.
        
        /**
         * Agora, a mesma coisa usando-se um mapper.
         * Usarei outra variável chamada: productMapeado.
         * Isso é para demonstrar as duas meneiras de atribuir os campos ao objeto.
        **/
        //ModelMapper mapper = new ModelMapper(); //esse trecho foi comentado depois que crei um atributo mapper na classe.
        Product productMapped = mapper.map(request, Product.class); // Aqui as atribuições de cada campo já são feitas.

        repository.saveAndFlush(productMapped); // Salvando o objeto no banco de dados

        /* Fazendo a mesma coisa para mapear o objeto da response */
        ProductDTO response = mapper.map(productMapped, ProductDTO.class);

        return Optional.of(response);

    }

    @Override
    public List<ProductDTO> getAll() {

        List<Product> produtcs = repository.findAll(); // Retorno do banco de dados com todos os itens.
        
        List<ProductDTO> responses = new ArrayList<>(); // ArrayList do tipo ProductDTO que será retornado.

        /* Estilo java8 -> aqui está sendo utilizado uma função lambda dentro do método de adicionar um item no array.
         * Para cada item (ForEach) de products será adicionado no array responses (responses.add) um mapeadmento do
         * objeto produtct para o ProductDTO. Deste modo, a solução fica mais limpa e faz uso do java funcional.
         */
        produtcs.forEach(product -> responses.add(mapper.map(product, ProductDTO.class)));

        return responses;
    }

    @Override
    public Optional<ProductDTO> getById(Long id) {
        
        Optional<Product> product = repository.findById(id);

        /* Mais uma vez fazendo o uso do java funcional.
         * No caso de o optional não retornar nenhum valor (ofNullable), o map não é executado e 
         * assim é retornado um optional empty.
         */
        
         //Modo 1 de se fazer 
         //return Optional.ofNullable(mapper.map(product.get(), ProductDTO.class)); // 
        
        //Modo 2 de se fazer
        return product.map(p -> mapper.map(p, ProductDTO.class));
    }

    @Override
    public boolean inactive(Long id) {
        Optional<Product> product = repository.findById(id);
        
        if(product.isPresent()){
            
            product.get().setAvailable(false);
        }

        return false;
    }
}
