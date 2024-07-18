# Desafio DIO - BootCamp Desenvolvimento Java com IA
## Visão Geral da Aplicação
A aplicação é um gerenciador de tarefas simples construído com Spring Boot, permitindo aos usuários criar, visualizar, editar e excluir tarefas. Utiliza Thymeleaf para renderização de templates HTML e H2 como banco de dados.

### Funcionalidades
Listagem de Tarefas: Visualização de todas as tarefas.
Criação de Tarefa: Adição de novas tarefas.
Edição de Tarefa: Modificação de tarefas existentes.
Exclusão de Tarefa: Remoção de tarefas.

### Estrutura do Projeto
Controller: Gerencia as requisições HTTP (ex: TaskController).
Service: Contém a lógica de negócios (ex: TaskService).
Repository: Interface para acesso ao banco de dados (ex: TaskRepository).
Model: Representa os dados da aplicação (ex: Task).

### Padrões de Projeto Utilizados
MVC (Model-View-Controller): Organização em camadas.
Injeção de Dependência: Gerenciamento de beans pelo Spring.
Repository Pattern: Abstração da camada de acesso a dados.
Template Method Pattern: Estrutura de algoritmos no Thymeleaf.
Tratamento de Exceções: Gerenciamento centralizado de erros.

### Principais Componentes
TaskController: Controla o fluxo de requisições.
TaskService: Implementa a lógica de negócios.
TaskRepository: Interface para operações de banco de dados.
Task: Modelo de dados da tarefa.

### Configuração
O projeto é gerenciado pelo Maven e inclui dependências como Spring Boot Starter Web, Data JPA, Thymeleaf e H2 Database.
