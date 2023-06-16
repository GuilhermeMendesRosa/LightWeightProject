# Light Weight Project

> Plataforma para treinos e tracking de progessão na academia.
> 

---

## Arquitetura

### Aplicação Backend

- Spring Boot 3
- Spring Security
- Autenticação Stateless com utilização de token JWT
- Senhas criptografadas com Bcrypt
- Utilização de Lombok
- Utilização de Migrations

### Aplicação Frontend


- Angular 14
- Bootstrap

### Aplicativo

- Android nativo em Java (não definido ainda)

---

## Funcionalidades

- Criar usuários
- Criar, editar e excluir `Workouts`
- Criar, editar e excluir `WorkoutSessions`
- Criar e excluir `Goals`

## Modelagem

### Exercise

- Ideia de um exercício Ex: supino com halteres
- Terá um agrupamento muscular (Será uma ENUM)
- Terá um campo de PR (Personal Record)

### Workout

- Ideia de uma rotina de treino para um dia em específico. Ex: treino de peito e triceps
- Todo `Workout` vai ser composto por um número X de exercícios e uma quantidade Y de series
- Teremos a ideia de progressão de carga, para isso teremos que consultar a `WorkoutSession`, buscando os melhores desempenhos nos exercícios registrados pelo usuário por `Exercise`
- Será relacionado um `User`

### Workout Session

- Ideia da execução de uma `Workout`, toda `Workout` pode ser executada diversas vezes
- Terá um tempo de execução da sessão. Ex: treino de hoje = 55 minutos
- Terá uma quantidade X de repetições por `Exercise`
- Terá uma quantidade de carga por `Exercise`
- Terá uma `Workout` associada
- Será relacionado um `User`

### Goals

- Ideia de objetivos para um determinado exercício. Ex: 100kg no supino
- Será associado a um `Exercise`
- Será relacionado um `User`

<div align="center">
  <img src="https://user-images.githubusercontent.com/83733948/226145055-297592db-1651-443a-a697-a1b85bae6c2f.png">
</div>

## Frontend
<div style="display: flex; flex-direction: row;" >
    <img height="500px" style="margin: 4px;" src="https://user-images.githubusercontent.com/83733948/240895293-bc5fb9d1-92d4-4272-9281-be4020beef66.png" alt="">
    <img height="500px" style="margin: 4px;" src="https://user-images.githubusercontent.com/83733948/240895352-54894f44-7033-46dd-a77f-45242b3cb787.png" alt="">
    <img height="500px" style="margin: 4px;" src="https://user-images.githubusercontent.com/83733948/240895627-7737c326-71e1-42a3-a5bf-a3825a2d3a6e.png" alt="">
</div>
