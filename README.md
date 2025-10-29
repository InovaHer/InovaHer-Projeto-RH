# 💼 Projeto Inova RH - Backend

<p align="center">
  <img src="https://ik.imagekit.io/u0isfvxls/InovaHer/Copilot_20251028_085719.png?updatedAt=1761683022317" alt="logo" />
</p>

## 1. Descrição

O **Inova RH** é uma plataforma desenvolvida para **modernizar a gestão de pessoas** e, ao mesmo tempo, **atrair novos talentos** para o ecossistema corporativo.  
Mais do que um simples sistema de Recursos Humanos, o Inova RH funciona como uma **vitrine tecnológica** — um ambiente inovador que demonstra os valores, processos e ferramentas da empresa, despertando o interesse de profissionais em **fazer parte do time**.

Com uma interface moderna e intuitiva, o sistema centraliza informações de colaboradores, departamentos e usuários, otimizando os processos de RH e promovendo **agilidade, transparência e eficiência**.  
Entre as principais funções, estão o **cálculo automático de salários**, o **cadastro de colaboradores**, e a **geração de holerites** com base em regras de negócio automatizadas.

Nesta sprint, o backend passou a incluir **autenticação e autorização via Spring Security e JWT**, além do **deploy da aplicação em ambiente cloud**, garantindo segurança e escalabilidade.

------

## 2. Sobre esta API

A API do **Inova RH** foi construída em **Spring Boot**, utilizando a arquitetura **RESTful**.  
Ela gerencia as operações de **cadastro, consulta, atualização e exclusão (CRUD)** das entidades principais — `Colaborador`, `Departamento` e `Usuario` — e implementa lógicas de negócio para o cálculo automático de remunerações e geração de holerites.<br/>
Obs: Por segurança a classe `Usuario` não implementa a operação Delete 

Além disso, o projeto foi estruturado para **demonstrar boas práticas de desenvolvimento corporativo**, servindo como **exemplo técnico e cultural** para candidatos interessados em ingressar na empresa.

### 2.1. Principais Funcionalidades

1. CRUD completo das entidades:
   - `Colaborador`
   - `Departamento`
   - `Usuario`
2. Cálculo automático de salário:  
   `valorHora * horasTrabalhadas + bonus – descontos`
3. Geração de **holerite** com resumo de valores
4. Busca personalizada por atributos (ex: nome, departamento)
5. Relacionamento entre tabelas (`@OneToMany`, `@ManyToOne`)
6. Autenticação e autorização com **Spring Security + JWT**
7. **Deploy do backend em ambiente cloud**
8. Arquitetura em camadas: `controller`, `service`, `repository`, `model`

------

## 3. Diagrama de Classes

<div align="center">
    <img src="https://ik.imagekit.io/u0isfvxls/InovaHer/Untitled%20diagram-2025-10-28-043036.png?updatedAt=1761753917622" title="Diagrama de Classes Inova RH" width="70%"/>
</div>

> **Observação:**  
> O método principal da classe `Colaborador` realiza o cálculo automático do salário com base nas horas trabalhadas, bônus e descontos.  
> O cálculo é implementado no pacote `.service`, dentro da classe `ColaboradorService`.

------

## 4. Diagrama Entidade-Relacionamento (DER)

<div align="center">
    <img src="https://ik.imagekit.io/u0isfvxls/InovaHer/Captura%20de%20tela%202025-10-29%20102243.png?updatedAt=1761753917560" title="DER Inova RH" width="70%"/>
</div>

> **Relacionamentos:**  
> - `Departamento (1) → (N) Colaborador`  
> - `Colaborador (N) → (1) Departamento`

------

## 5. Tecnologias Utilizadas

| Item                          | Descrição          |
| ----------------------------- | ------------------ |
| **Servidor**                  | Apache Tomcat      |
| **Linguagem de Programação**  | Java               |
| **Framework**                 | Spring Boot        |
| **Segurança**                 | Spring Security + JWT |
| **ORM**                       | Spring Data JPA / Hibernate |
| **Banco de Dados Relacional** | MySQL              |
| **Ferramenta de Build**       | Maven              |
| **IDE Sugerida**              | IntelliJ IDEA / VS Code / Eclipse |
| **Deploy**                    | Render / Railway / AWS (ambiente cloud) |

------

## 6. Configuração e Execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/SeuUsuario/inova-rh-backend.git
   ```
2. **Acesse o diretório**
   ```bash
   cd inova-rh-backend
   ```
3. **Configure o banco de dados**  
   No arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/db_inovarh
   spring.datasource.username=root
   spring.datasource.password=suasenha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   jwt.secret=seuSegredoJWT
   jwt.expiration=86400000
   ```
4. **Execute o projeto**
   ```bash
   mvn spring-boot:run
   ```
5. **Acesse a API localmente**
   ```
   http://localhost:8080
   ```

6. **Acesse o deploy (ambiente cloud)**
   ```
   https://inovarh.onrender.com
   ```

------

## 👥 Equipe – Grupo D

<table align="center">
  <tr>
    <td align="center">
      <a href="https://github.com/jmcardoso18">
        <img src="https://github.com/jmcardoso18.png" width="100" style="border-radius:50%"><br>
        <b>Jamila</b><br>
        <sub>Scrum Master</sub>
      </a>
    </td>
    <td align="center">
        <a href="https://github.com/patriciaEliseu">
        <img src="https://github.com/patriciaEliseu.png" width="100" style="border-radius:50%"><br>
        <b>Patricia</b><br>
        <sub>Tester</sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/lauhgabrielle14">
        <img src="https://github.com/lauhgabrielle14.png" width="100" style="border-radius:50%"><br>
        <b>Lauren</b><br>
        <sub>Desenvolvedora</sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/MarciaCondarco">
        <img src="https://github.com/MarciaCondarco.png" width="100" style="border-radius:50%"><br>
        <b>Marcia</b><br>
        <sub>Desenvolvedora</sub>
      </a>
    </td>
    <td align="center">
          <a href="https://github.com/nayarakiyota">
        <img src="https://github.com/nayarakiyota.png" width="100" style="border-radius:50%"><br>
        <b>Nayara</b><br>
        <sub>Desenvolvedora</sub>
      </a>
    </td>
    <td align="center">
         <a href="https://github.com/stellabrumatti">
        <img src="https://github.com/stellabrumatti.png" width="100" style="border-radius:50%"><br>
        <b>Stella</b><br
        <sub>Desenvolvedora</sub>
      </a>
    </td>
  </tr>
</table>

------

## 📅 Data
**São Paulo, outubro de 2025**

------

## 💡 Próximos Passos (próxima sprint)

- Integração completa com o **frontend web**
- Implementação de testes automatizados (JUnit)
- Criação de pipeline CI/CD para deploy contínuo
