# 🛡️ Projeto Spring Boot - Autenticação com JWT

Este projeto foi desenvolvido como parte do **curso de Spring Boot** oferecido no canal do [Matheus Leandro Ferreira no YouTube](https://www.youtube.com/@matheuslf). Ele demonstra conceitos fundamentais de autenticação e segurança com **JWT (JSON Web Token)** em uma API REST com **Spring Boot**.

📺 Curso usado como base: [Spring Boot + JWT | Curso no YouTube](https://www.youtube.com/watch?v=SqU9v_V32RA)

## 📚 Objetivos do Projeto

- Criar uma API com endpoints de registro e login.
- Utilizar `PasswordEncoder` para criptografar senhas com BCrypt.
- Gerar e validar tokens JWT para autenticação.
- Organizar o projeto em camadas: `controller`, `service`, `repository` e `security`.

## 🔐 Funcionalidades

- `POST /auth/register`: cadastra um novo usuário com senha criptografada.
- `POST /auth/login`: autentica o usuário e retorna um token JWT se as credenciais forem válidas.

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security
- JWT (via `jjwt`)
- Lombok

## 🚀 Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/andregnicoletti/spring-boot-course-matheuslf.git
   ```
2. Abra no IntelliJ, Eclipse ou qualquer IDE com suporte a Spring Boot.
3. Execute a classe principal do projeto.
4. Use ferramentas como Postman ou Insomnia para testar os endpoints de autenticação.

## 🤝 Agradecimento

Projeto baseado no conteúdo do canal [Matheus Leandro Ferreira no YouTube](https://www.youtube.com/@matheuslf). Vale a pena acompanhar o canal para mais vídeos sobre Java e desenvolvimento backend!

---