## Product-ms

## Endpoints
- BaseURL: /products
- POST: create()
- GET: getAll()
- GET /{id}: getById()
- PUT /{id}: update()
- DELETE /{id}: delete()

## Model
```json
{
    "id": 1,
    "name": "Exemplo de nome de produto",
    "description": "Descrição de exemplo",
    "price": 7000.99,
    "isAvailable": true
}
```

## Business Rules
- Não é permitido o cadastro de itens com preço negativo.
- Não é permitido a pesquisa de itens que não estejam disponíveis.
- A descrição dos itens deve ter pelo menos 50 caracteres.


## Warehouse-ms

## Endpoints
- BaseURL: /warehouses
- POST: create()
- GET: getAll()
- GET /{id}: getById()*
- PUT /{id}: update()*

## Model
```json
{
    "id": 1,
    "productId": 1,
    "quantity": 10    
}
```
## Business Rules
- O estoque é responsável por avisar se o item está ou não disponível.
- Não é permitido ter mais de uma linha no banco para o mesmo item.
