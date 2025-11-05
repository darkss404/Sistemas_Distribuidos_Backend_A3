# Controle de Estoque A3

Projeto desenvolvido para a disciplina **Programação de Soluções Computacionais** da **UNISUL**, com o objetivo de aplicar conceitos de programação, modelagem de software e controle de versionamento colaborativo no **GitHub**.

## 📦 Descrição

O sistema de Controle de Estoque permite gerenciar produtos de uma empresa comercial, oferecendo funcionalidades para:

- **Cadastro de Produtos** (CRUD)
- **Cadastro de Categorias** (CRUD)
- **Controle de Entradas e Saídas** de produtos
- **Relatórios Gerenciais** como:
    - Lista de Preços
    - Balanço Físico/Financeiro
    - Produtos abaixo da quantidade mínima
    - Produtos acima da quantidade máxima
    - Quantidade de produtos por categoria

## 🛠️ Tecnologias Utilizadas

| Tecnologia      | Versão            | Observações                                 |
|-----------------|-------------------|---------------------------------------------|
| Java            | 23                | Linguagem principal para o sistema          |
| MySQL           | 9.3.0             | Banco de dados para persistência de dados   |
| JDBC Driver     | 4.2               | Conexão Java <-> MySQL                      |
| Apache NetBeans | 25.0              | IDE utilizada para o desenvolvimento        |
| Git             | 2.40+             | Controle de versão e colaboração            |
| GitHub          | -                 | Hospedagem do repositório e controle remoto |
| Oracle Academy  | -                 | Cursos complementares para o projeto        |
| Swing (Java)    | Integrado ao Java | Interface gráfica do sistema (GUI)          |

## 📁 Estrutura do Projeto

- `src/main/java/modelo` – Contém as classes de entidade como Produto, Categoria e Movimentacao.
- `src/main/java/visao` – Responsável pelas telas e interface gráfica (Swing).
- `src/main/java/dao` – Implementa a persistência e consultas ao banco de dados.
- `src/main/java/principal` – Classe principal para inicialização do sistema.
- `db/estoque.sql` – Script SQL para criação do banco de dados.

## ✅ Requisitos Funcionais

### RF001 - Gerenciamento de Produtos
- **RF001.1:** Permitir o cadastro de produtos com nome, preço unitário, unidade, quantidade mínima/máxima e categoria.
- **RF001.2:** Permitir o reajuste de preço de todos os produtos por percentual.

### RF002 - Gerenciamento de Categorias
- **RF002.1:** Permitir o cadastro de categorias com os seguintes atributos: nome, tamanho e tipo de embalagem.

### RF003 - Movimentação de Estoque
- **RF003.1:** Permitir a entrada de produtos no estoque.
- **RF003.2:** Permitir a saída de produtos do estoque.
- **RF003.3:** Alertar o usuário quando a quantidade de um produto estiver **abaixo da mínima** após uma movimentação.
- **RF003.4:** Alertar o usuário quando a quantidade de um produto estiver **acima da máxima** após uma movimentação.

### RF004 - Geração de Relatórios
- **RF004.1:** Gerar relatório de **Lista de Preços**, contendo os produtos e seus respectivos preços.
- **RF004.2:** Gerar relatório de **Balanço Físico/Financeiro**, com a quantidade em estoque, valor unitário e valor total por produto.
- **RF004.3:** Gerar relatório de **produtos abaixo da quantidade mínima**.
- **RF004.4:** Gerar relatório de **produtos acima da quantidade máxima**.
- **RF004.5:** Gerar relatório com a **quantidade de produtos por categoria**.

### RF005 - Interface do Sistema
- **RF005.1:** Disponibilizar uma **interface gráfica** para interação com todas as funcionalidades do sistema.

## ❌ Requisitos Não Funcionais

### RNF001 - Arquitetura e Persistência
- **RNF001.1:** Utilizar o padrão de projeto **DAO (Data Access Object)** para separar a lógica de acesso aos dados da lógica de negócios.
- **RNF001.2:** Utilizar um banco de dados **MySQL** para garantir a persistência dos dados.

### RNF002 - Qualidade e Organização do Código
- **RNF002.1:** Seguir **boas práticas de codificação**, como nomes significativos, coesão e reutilização de código.
- **RNF002.2:** Manter a **organização lógica de pacotes e classes** conforme padrões de desenvolvimento.
- **RNF002.3:** Manter o código **limpo, organizado e documentado**, facilitando a manutenção.

### RNF003 - Controle de Versão e Colaboração
- **RNF003.1:** Utilizar **Git** como sistema de controle de versão.
- **RNF003.2:** Manter o projeto organizado em um repositório **GitHub**.
- **RNF003.3:** Aplicar práticas colaborativas como **commits frequentes** e **mensagens descritivas**.

### RNF004 - Usabilidade e Simplicidade
- **RNF004.1:** O sistema deve ser **simples, funcional e de fácil uso** para qualquer usuário.
- **RNF004.2:** A interface gráfica deve ser **clara, intuitiva** e adequada ao fluxo de trabalho.


## 🎓 Objetivos Acadêmicos

Este projeto visa:

- Aplicar conceitos de modelagem de sistemas
- Trabalhar com padrões de projeto (DAO)
- Usar controle de versão em equipe (Git/GitHub)
- Praticar o desenvolvimento colaborativo
- Desenvolver um sistema funcional com interface gráfica

## 👥 Equipe

| Nome do Aluno                    | Usuário Github  | RA do Aluno |
|----------------------------------|-----------------|-------------|
| Gustavo Abrahão de Melo Carvalho | @gustavoabrahao | 1072511496  |
| Carlos Eduardo Weiss             | @CarlosEduWeiss | 1072519046  |
| Bernardo Mendonça Santiago       | @bnsant         | 10725116225 |
| Roger Porton Kuntze              | @rogerpk        | 10725118527 |
| Gabriel González Mattos          | @gabinhogmtts   | 1072517870  |

## 📌 Requisitos para Rodar o Projeto

- Java 11 ou superior
- MySQL
- IDE Java (Apache NetBeans)
- Clonar o repositório e configurar o banco de dados a partir do script disponível
- Login Banco De Dados MySQL:
  - Usuário: root
  - Senha: TrabalhoA3


## 🎥 Apresentação

Link para o vídeo da apresentação: ...
