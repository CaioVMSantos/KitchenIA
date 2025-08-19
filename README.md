# KitchenIA - Back-end

**Aplicação back-end em Java com Spring Boot e Inteligência Artificial**

O **KitchenIA** é uma aplicação que integra um banco de dados de alimentos com a **API Gemini IA** para gerar **receitas personalizadas**.  
A ideia é que, a partir dos alimentos cadastrados pelo usuário, a aplicação sugira receitas inteligentes e adaptadas às preferências de cada pessoa.

---

## Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security** (a ser implementado)
- **Spring AI** (para integração com IA)
- **Gemini IA API**
- **Banco de Dados**
  - [x] **H2** (atual)
  - [ ] **PostgreSQL** (planejado)
- **Swagger / OpenAPI** (documentação da API)

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

````

---

## Configuração do Projeto

### Pré-requisitos

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/) (planejado)

### Clonar o Repositório

```bash
git clone https://github.com/CaioVMSantos/KitchenIA.git
cd KitchenIA
````

### Rodar a Aplicação

```bash
mvn spring-boot:run
```

O back-end estará disponível em:

```
http://localhost:8080
```

---

## Banco de Dados

### H2 (padrão atual)

* Console do H2:

  ```
  http://localhost:8080/h2-console
  ```
* Credenciais padrão configuradas em `application.properties`.

  ---

## Documentação da API (A fazer)
Com o **Swagger** será possível visualizar e testar os endpoints diretamente no navegador.

Acesse em:

```
http://localhost:8080/swagger-ui.html
```

---

## Roadmap Detalhado

* [x] Implementar CRUD de alimentos com **Spring Data JPA**
* [x] Integrar com a **API Gemini IA**
* [ ] Migrar banco de dados de **H2 → PostgreSQL**
* [ ] Implementar **Spring AI** para melhorar as interações de IA
* [ ] Adicionar **Spring Security** (autenticação/autorização)
* [ ] Criar **documentação de endpoints com Swagger**
* [ ] Expor API pública para integração com o front-end
* [ ] Implementar testes unitários e de integração

---

## Integrações

* **Front-end Angular:** [KitchenIA Front-end](https://github.com/CaioVMSantos/Angular-Kitchen-Ia)
* **Back-end Java:** [KitchenIA Back-end](https://github.com/CaioVMSantos/KitchenIA)

---

## 📚 Recursos e Documentações Utilizadas e Relevantes

* [Spring Boot Documentation](https://spring.io/projects/spring-boot)
* [Spring AI](https://docs.spring.io/spring-ai/reference/)
* [PostgreSQL](https://www.postgresql.org/)
* [Swagger OpenAPI](https://swagger.io/tools/open-source/openapi-generator/)
* [Gemini API](https://ai.google.dev/)
