# Pessoa JWT - Spring Boot 3 + Java 21

API REST com CRUD de Pessoas, autenticação JWT e documentação Swagger.

---

## Estrutura MVC do Projeto

```
src/main/java/com/accenture/pessoa/
│
├── PessoaApplication.java                   ← Classe principal
│
├── config/
│   └── security/
│       ├── OpenApiConfig.java               ← Configuração Swagger + JWT bearer
│       ├── SecurityConfigurations.java      ← Regras de segurança e rotas
│       ├── SecurityFilter.java              ← Filtro JWT por requisição
│       └── TokenService.java               ← Geração e validação de tokens JWT
│
├── controller/                              ← (C) Camada de apresentação / entrada HTTP
│   ├── AuthenticationController.java        ← POST /auth/login, POST /auth/register
│   └── PessoaController.java               ← GET/POST/PUT/DELETE /pessoas
│
├── entity/                                  ← (M) Entidades JPA
│   ├── Pessoa.java
│   ├── User.java
│   ├── enums/
│   │   └── UserRoles.java
│   └── user/
│       └── dtos/
│           ├── AuthenticationDTO.java
│           ├── LoginResponseDTO.java
│           └── RegisterDTO.java
│
├── repository/                              ← (M) Acesso ao banco de dados
│   ├── PessoaRepository.java
│   └── UserRepository.java
│
└── service/                                 ← (M) Regras de negócio
    ├── AuthorizationService.java
    └── PessoaService.java
```

---

## Tecnologias

| Tecnologia           | Versão  |
|----------------------|---------|
| Java                 | 21      |
| Spring Boot          | 3.3.2   |
| Spring Security      | 6.x     |
| Spring Data JPA      | 3.x     |
| Auth0 Java JWT       | 4.4.0   |
| Springdoc OpenAPI    | 2.3.0   |
| Lombok               | latest  |
| H2 Database          | runtime |
| Maven                | 3.x     |

---

## Banco de Dados H2

O projeto usa H2 **em memória** — nenhuma instalação necessária. O banco é criado automaticamente ao subir a aplicação e apagado ao encerrar.

Acesse o console visual em:
```
http://localhost:8080/h2-console
```

Configurações de conexão:
```
JDBC URL:  jdbc:h2:mem:pessoadb
User:      sa
Password:  (deixar em branco)
```

---

## Como Executar

```bash
# Entre na pasta do projeto (onde está o pom.xml)
cd pessoa-jwt

# Execute com Maven
mvn spring-boot:run

# Ou com variável de ambiente JWT customizada
JWT_SECRET=minha-chave-secreta mvn spring-boot:run
```

---

## Swagger UI

Após iniciar a aplicação, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Fluxo de Autenticação

### 1. Registrar usuário

```http
POST /auth/register
Content-Type: application/json

{
  "login": "admin@email.com",
  "password": "senha123",
  "role": "ADMIN"
}
```

### 2. Fazer login

```http
POST /auth/login
Content-Type: application/json

{
  "login": "admin@email.com",
  "password": "senha123"
}
```

Resposta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### 3. Usar o token nas requisições

```http
GET /pessoas
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

---

## Endpoints

| Método | Rota              | Acesso          | Descrição              |
|--------|-------------------|-----------------|------------------------|
| POST   | /auth/register    | Público         | Registrar usuário      |
| POST   | /auth/login       | Público         | Login e retorna JWT    |
| GET    | /pessoas          | Autenticado     | Listar todas           |
| GET    | /pessoas/{id}     | Autenticado     | Buscar por ID          |
| POST   | /pessoas          | Somente ADMIN   | Criar pessoa           |
| PUT    | /pessoas/{id}     | Autenticado     | Atualizar pessoa       |
| DELETE | /pessoas/{id}     | Autenticado     | Remover pessoa         |

---

## Roles

| Role  | Permissões                                   |
|-------|----------------------------------------------|
| ADMIN | ROLE_ADMIN + ROLE_USER (acesso total)        |
| USER  | ROLE_USER (leitura, atualização, remoção)    |



## 📸 Imagens do Projeto

### 📌 Tela 1
<p align="center">
  <img src="./img/Captura%20de%20tela%20de%202026-05-06%2021-08-40.png" width="800"/>
</p>

### 📌 Tela 2
<p align="center">
  <img src="./img/Captura%20de%20tela%20de%202026-05-06%2021-09-53.png" width="800"/>
</p>

### 📌 Tela 3
<p align="center">
  <img src="./img/Captura%20de%20tela%20de%202026-05-06%2021-10-51.png" width="800"/>
</p>

### 📌 Tela 4
<p align="center">
  <img src="./img/Captura%20de%20tela%20de%202026-05-06%2021-17-53.png" width="800"/>
</p>

### 📌 Tela 5
<p align="center">
  <img src="./img/Captura%20de%20tela%20de%202026-05-06%2021-18-28.png" width="800"/>
</p>

### 📌 Tela 6
<p align="center">
  <img src="./img/Captura%20de%20tela%20de%202026-05-06%2021-18-46.png" width="800"/>
</p>

### 📌 Tela 7
<p align="center">
  <img src="./img/Captura%20de%20tela%20de%202026-05-06%2021-26-09.png" width="800"/>
</p>
