# 🏋️‍♂️ Academia API - Artes Marciais

Uma API REST completa e robusta para gerenciamento de academias e centros de artes marciais, desenvolvida para abstrair e automatizar o controle de alunos, matrículas, planos e assiduidade. O projeto foi construído aplicando conceitos avançados de arquitetura de software, boas práticas e padrões de projeto consolidados no mercado.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework Principal:** Spring Boot 3
* **Banco de Dados:** PostgreSQL
* **Migrações de Banco:** Flyway (Versionamento e inserção de dados)
* **Documentação:** Swagger / OpenAPI
* **Gerenciador de Dependências:** Maven

---

## 🏗️ Arquitetura e Padrões de Projeto

O projeto foi estruturado seguindo o padrão **MVC (Model-View-Controller)**, com uma clara separação de responsabilidades em camadas:

* **Domain / Model:** Abstração das entidades de negócio do domínio de uma academia, como `Aluno`, `Matricula`, `Plano`, `Graduacao` e `Assiduidade`, utilizando **Enums** para garantir consistência de estados e tipos.
* **Padrão DTO (Data Transfer Object):** Utilizado para isolar a camada de domínio da camada de apresentação, garantindo uma comunicação segura e eficiente nas requisições e respostas da API.
* **Service Layer:** Camada onde reside toda a lógica e regras de negócio da aplicação, implementada através de **Interfaces** para definir contratos claros de serviço.
* **Spring Data JPA & Advanced Queries:** Uso de **Specifications** para consultas dinâmicas avançadas e **Projections (Interfaces)** para otimizar a busca de dados específicos direto do banco, melhorando a performance de forma limpa.
* **Custom Bean:** Implementação de um componente customizado para expor e informar dinamicamente a versão atual da API.

---

## 🛡️ Tratamento de Erros e Resiliência

A API conta com um sistema centralizado e robusto para tratamento de falhas:
* **Global Exception Handler:** Captura e padroniza os erros comuns da aplicação de forma transparente para o cliente.
* **Business Exceptions:** Classes customizadas que herdam de `RuntimeException` para tratar de forma cirúrgica os desvios e violações das regras de negócio em tempo de execução.

---

## 📄 Documentação da API

A documentação dos endpoints foi gerada de maneira 100% automatizada com o **Swagger UI**. 

Para visualizar e testar os endpoints da API (como gestão de alunos, planos e matrículas), certifique-se de que a aplicação está rodando localmente e acesse o endereço:
```text
http://localhost:8080/swagger-ui/index.html
```

---

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos
* **Java 21** instalado.
* **PostgreSQL** instalado e rodando.

### Passo a Passo

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com
   cd artesmarciais
   ```

2. **Configurar o Banco de Dados:**
   No arquivo `src/main/resources/application.properties` (ou `application.yml`), configure as credenciais do seu PostgreSQL:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/NOME_DO_SEU_BANCO
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```
   *(O Flyway executará automaticamente as migrações e a inserção de dados iniciais assim que o projeto subir).*

3. **Rodar a aplicação com Maven:**
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 🎓 Agradecimentos

Este projeto foi desenvolvido aplicando os conceitos e boas práticas ensinados pelo **Professor Matheus Leandro Ferreira**, uma referência como professor acadêmico e profissional em desenvolvimento Java de extrema relevância no YouTube.
