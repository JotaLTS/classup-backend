# 🏗️ ClassUp - Back End (Em Construção)

> Plataforma educacional inspirada no Google Classroom com foco em **Gamificação da Educação**.

---

## 👨‍💻 Autor

**Jonatas (JotaLTS)**

---

## 📜 Sobre o Projeto

O **ClassUp** é um projeto acadêmico desenvolvido como Trabalho de Conclusão de Curso (TCC), inspirado no Google Classroom.

Seu principal diferencial é a aplicação de conceitos de **gamificação**, tornando o processo de aprendizagem mais interativo, motivador e envolvente para os alunos.

A plataforma utiliza elementos comuns em jogos, como:

* 🎯 Missões
* 🏆 Conquistas
* 📈 Rankings
* ⭐ Pontuação
* 🎖️ Progressão do aluno

O objetivo é aumentar o engajamento dos estudantes e incentivar a participação nas atividades acadêmicas.

---

## 🎯 Objetivos da Gamificação

* Aumentar o engajamento dos alunos
* Incentivar a entrega de atividades
* Recompensar o desempenho acadêmico
* Promover competição saudável entre estudantes
* Tornar o ambiente de aprendizagem mais atrativo

---

## ⚙️ Funcionalidades

### 👨‍🎓 Gestão de Alunos

* Cadastro de alunos
* Associação com turmas
* Controle de conquistas
* Histórico de entregas

### 👨‍🏫 Gestão de Professores

* Cadastro de professores
* Gerenciamento de disciplinas
* Correção de atividades

### 📚 Gestão de Disciplinas

* Cadastro de disciplinas
* Associação por módulo/turma
* Vinculação de materiais de apoio

### 📝 Gestão de Atividades

* Exercícios
* Projetos
* Missões

### 🚀 Sistema de Missões

* Missões valendo pontos
* Progressão do aluno
* Impacto no ranking

### 🏆 Sistema de Conquistas

* Desbloqueio automático
* Pontuação mínima configurável
* Registro da data de desbloqueio

### 📊 Sistema de Ranking

* Classificação dos alunos
* Acúmulo de pontos através das missões
* Visualização de desempenho

### 📂 Materiais de Apoio

* Upload de arquivos
* Compartilhamento de conteúdos
* Apoio ao estudo das disciplinas

---

## 🏛️ Modelo de Domínio

O projeto é composto pelas principais entidades:

* Usuário
* Aluno
* Professor
* Administrador
* Turma
* Disciplina
* Atividade
* EntregaAtividade
* Conquista
* AlunoConquista
* MaterialApoio

---

## 🛠️ Tecnologias Utilizadas

### Back-End

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

### Banco de Dados

* PostgreSQL

### Ferramentas

* IntelliJ IDEA
* Git
* GitHub
* Lucidchart

---

## 📋 Pré-requisitos

Antes de executar o projeto, é necessário possuir:

* Java JDK 21 ou superior
* PostgreSQL
* Maven
* IDE de sua preferência (recomendado IntelliJ IDEA)

---

## 🔥 Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/classup.git
```

### 2. Acessar a pasta do projeto

```bash
cd classup
```

### 3. Configurar o banco de dados

Crie um banco PostgreSQL e configure as credenciais no arquivo:

```properties
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/classup
spring.datasource.username=postgres
spring.datasource.password=senha
```

### 4. Executar a aplicação

Pela IDE:

```text
Executar ClassupApplication.java
```

Ou pelo terminal:

```bash
mvn spring-boot:run
```

---

## 📌 Status do Projeto

🚧 Em desenvolvimento

Funcionalidades em andamento:

* Autenticação JWT
* Controle de permissões
* Sistema de ranking
* Dashboard de desempenho
* Upload de arquivos
* API REST completa

---

## 📖 Licença

Projeto desenvolvido para fins acadêmicos como Trabalho de Conclusão de Curso (TCC).

---

## 💡 Motivação

A gamificação tem se mostrado uma estratégia eficiente para aumentar o engajamento em ambientes educacionais.

O ClassUp busca unir tecnologia e educação para proporcionar uma experiência mais dinâmica, motivadora e eficiente para alunos e professores.
