# Light Weitgh Project

> Ideia de plataforma para treinos e tracking de progessão na academia.
> 

> A ideia geral é que seja um App que faz requisiçẽos para uma API Rest salvando os dados de treino do usuário no servidor.
> 

---

## Arquitetura

### Backend

- Spring Boot 3
- Spring Security
- Autenticação Stateless com utilização de token JWT
- Senhas criptografadas com Bcrypt
- Utilização de Lombok
- Utilização de Migrations

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
  <img src="https://user-images.githubusercontent.com/83733948/224577799-5bb31cb8-29b0-4e8b-b893-521dfebc1f78.png">
</div>
