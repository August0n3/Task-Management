
# Gerenciador de Tarefas

Este é um projeto de Gerenciador de Tarefas desenvolvido em Java utilizando tecnologias como JPA, Hibernate, PrimeFaces e Maven.

## Estrutura do Projeto

A estrutura do projeto é a seguinte:

```
gerenciadordetarefas/
├── .gitignore
├── .idea/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       └── GerenciadorDeTarefas.xhtml
│   └── test/
└── target/
```

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **JPA (Java Persistence API)**: Para mapeamento objeto-relacional.
- **Hibernate**: Implementação do JPA.
- **PrimeFaces**: Biblioteca de componentes para a interface do usuário.
- **Maven**: Gerenciamento de dependências e build do projeto.

## Configuração do Projeto

### Pré-requisitos

- JDK 8 ou superior
- Maven 3.6 ou superior
- Servidor de aplicação (Tomcat, WildFly, etc.)

### Passos para Configuração

1. **Clone o repositório**:

   ```bash
   git clone <git clone https://github.com/August0n3/Task-Management.git>

   cd gerenciadordetarefas
   ```

2. **Compile o projeto**:

   ```bash
   mvn clean install
   ```

3. **Configure o servidor de aplicação**:

   - Adicione o arquivo WAR gerado (`gerenciadordetarefas-1.0.war`) ao seu servidor de aplicação.

4. **Inicie o servidor de aplicação**.

5. **Acesse a aplicação**:

   - Abra o navegador e acesse `http://localhost:8080/gerenciadordetarefas/`.

## Funcionalidades

- **Gerenciamento de Tarefas**:
  - Criar, editar e excluir tarefas.
  - Pesquisar tarefas por título, ID e prioridade.

## Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Faça o push para a branch (`git push origin feature/nova-feature`).
5. Crie um novo Pull Request.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## Contato

Para mais informações, entre em contato com [Augustocamneto@gmail.com](mailto:seu-email@dominio.com).
