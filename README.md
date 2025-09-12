
---

# KitchenIA - Back-end

**Aplicação back-end em Java com Spring Boot e Inteligência Artificial**

O **KitchenIA** é uma aplicação que integra um banco de dados de alimentos com a **API Gemini IA** para gerar **receitas personalizadas**.
A ideia é que, a partir dos alimentos cadastrados pelo usuário, a aplicação sugira receitas inteligentes e adaptadas às preferências de cada pessoa.

---

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Spring Security** (a ser implementado)
* **Spring AI**
* **Gemini IA API**
* **Banco de Dados**

    * **PostgreSQL**
* **Swagger / OpenAPI** (documentação da API)

---

## 📂 Estrutura do Projeto

```
src/
├── main/
│   ├── java/dev/projeto/kitchenia
│   │    ├── controller   # Endpoints da aplicação
│   │    ├── model        # Entidades e classes do domínio
│   │    ├── repository   # Interfaces JPA para o banco de dados
│   │    ├── service      # Regras de negócio
│   │    └── config       # Configurações de segurança, Swagger, etc
│   └── resources/
│        ├── application.properties  # Configurações do projeto
│        └── data.sql                # Dados iniciais (mock)
```

---

## ⚙️ Configuração do Projeto

### Pré-requisitos

* [Java 17+](https://adoptium.net/)
* [Maven](https://maven.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)
* [Docker](https://www.docker.com/) (opcional, para rodar o banco)

### Clonar o Repositório

```bash
git clone https://github.com/CaioVMSantos/KitchenIA.git
cd KitchenIA
```

### Configurar Banco de Dados

No arquivo `application.properties`, configure as credenciais do seu PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/kitchenia
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

> 💡 Caso use **Docker**, você pode subir o banco com:

```bash
docker run --name kitchenia-db -e POSTGRES_DB=kitchenia -e POSTGRES_USER=seu_usuario -e POSTGRES_PASSWORD=sua_senha -p 5432:5432 -d postgres
```

---

### Rodar a Aplicação

```bash
mvn spring-boot:run
```

O back-end estará disponível em:

```
http://localhost:8080
```

---

## 🗄️ Banco de Dados

A aplicação utiliza **PostgreSQL** como banco principal.
Scripts de dados iniciais podem ser configurados em `src/main/resources/data.sql`.

---

## 📖 Documentação da API (A fazer)

Com o **Swagger** será possível visualizar e testar os endpoints diretamente no navegador:

```
http://localhost:8080/swagger-ui.html
```
---

## 🔗 Integrações

* **Front-end Angular:** [KitchenIA Front-end](https://github.com/CaioVMSantos/Angular-Kitchen-Ia)
* **Back-end Java:** [KitchenIA Back-end](https://github.com/CaioVMSantos/KitchenIA)

---

## 📚 Recursos e Documentações Relevantes

* [Spring Boot Documentation](https://spring.io/projects/spring-boot)
* [Spring AI](https://docs.spring.io/spring-ai/reference/)
* [PostgreSQL](https://www.postgresql.org/)
* [Swagger OpenAPI](https://swagger.io/tools/open-source/openapi-generator/)
* [Gemini API](https://ai.google.dev/)

---

