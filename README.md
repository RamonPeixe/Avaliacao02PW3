## Avaliação 03
**Dupla:**  
- **Filippa Bittencourt** – SC3029832
- **Ramon César Peixe** – SC3034992
### Endpoint de login

```makefile
POST http://localhost:8080/login
```

### Corpo da requisição:

```json
{
  "login": "carlao",
  "senha": "meda10"
}
```

### Resposta esperada:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

## Endpoints de Repairs (todas protegidas por JWT)

### Criar um consertos
```http
POST http://localhost:8080/repairs
Authorization: Bearer <token>
Content-Type: application/json

{
  "entryDate": "07/06/2025",
  "exitDate":  "12/06/2025",
  "mechanic": {
    "mechName":  "Ana",
    "mechYears": 2
  },
  "vehicle": {
    "vehMake":  "Chevrolet",
    "vehModel": "Onix",
    "vehYear":  "2020",
    "vehColor": "prata"
  }
}
```

### Listar todos os consertos
```http
GET http://localhost:8080/repairs
Authorization: Bearer <token>
```

### Obter um conserto específico
```http
GET http://localhost:8080/repairs/{id}
Authorization: Bearer <token>
```

### Listar resumo dos consertos
```http
GET http://localhost:8080/repairs/summary
Authorization: Bearer <token>
```

### Atualizar um conserto
```http
PUT http://localhost:8080/repairs/{id}
Authorization: Bearer <token>
Content-Type: application/json

{
  "exitDate":  "14/06/2025",
  "mechName":  "Ana Clara",
  "mechYears": 3
}
```

### Excluir um conserto
```http
DELETE http://localhost:8080/repairs/{id}
Authorization: Bearer <token>
```

> **PS:** Caso queira criar um usuário diferente do pré-criado, basta olhar no console ao iniciar o projeto. Você verá algo assim:
> 
> ```
> Sua senha 'senha123' em hash bcrypt é:
> $2a$10$DI7CxJoBhboIWsdDz3asg.EhOHYziIdZregGmmPhcEjK93pCK3p1G
> ```
> 
> Esse valor (`$2a$10$DI7CxJoBhboIWsdDz3asg.EhOHYziIdZregGmmPhcEjK93pCK3p1G`) é o hash para **senha123**.  
> Se quiser gerar um hash para outra senha, altere a variável `minhaSenha` em `Avaliacao02Application` e reinicie o projeto.  

