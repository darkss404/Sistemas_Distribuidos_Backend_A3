# Sistema de Estoque baseado em Java RMI

## Universidade do Sul de Santa Catarina – UNISUL
Projeto desenvolvido para a disciplina **Sistemas Distribuídos** da **UNISUL**, com foco na implementação de um sistema de controle de estoque distribuído utilizando Java RMI para comunicação entre cliente e servidor.

## Descrição do Sistema
Este projeto corresponde ao **back-end** do **Sistema de Controle de Estoque Distribuído**, desenvolvido em **Java** e utilizando **RMI (Remote Method Invocation)** para disponibilizar serviços remotos ao **cliente**.  
O servidor é responsável por **executar as regras de negócio**, **processar os dados** e **fornecer métodos remotos** que permitem o **gerenciamento do estoque** de forma **distribuída**.

## Arquitetura do Sistema
O sistema adota uma **arquitetura em duas camadas**, separando responsabilidades entre **servidor** e **cliente**:  
**Servidor (Back-end)**: responsável por **gerenciar os dados**, **processamento** e **disponibilizar os serviços remotos** via **Java RMI**.  
**Cliente (Front-end)**: conecta-se ao **servidor** utilizando **RMI**, **consome os serviços disponíveis** e **exibe as informações** para o **usuário**.  

**Repositório do Front-end**: https://github.com/darkss404/Sistemas_Distribuidos_Frontend_A3

## Tecnologias Utilizadas

| Tecnologia      | Versão            | Observações                                       |
|-----------------|-------------------|---------------------------------------------------|
| Java            | 23                | Linguagem principal para o sistema                |
| Apache NetBeans | 25.0              | IDE utilizada para o desenvolvimento              |
| Git             | 2.40+             | Controle de versão e colaboração                  |
| GitHub          | -                 | Hospedagem do repositório e controle remoto       |
| Swing (Java)    | Integrado ao Java | Interface gráfica do sistema (GUI)                |
| MySQL           | 9.3.0             | Banco de dados para armazenamento das informações |
| Java RMI        | Integrado ao Java | Comunicação remota entre cliente e servidor       |

## Estrutura do Projeto

- `db/` – **Contém o script SQL** utilizado para **criação e configuração do banco de dados MySQL**.
- `src/main/java/modelo` – **Contém as classes de entidade**, como **Produto**, **Categoria** e **Movimentacao**.
- `src/main/java/dao` – **Responsável pelo acesso e manipulação dos dados no banco**, realizando **operações CRUD** (Create, Read, Update, Delete) por meio do **MySQL**.
- `src/main/java/service` – **Classe que faz a integração do back-end com o front-end**, realizando **consultas** e **comunicação entre as camadas** através do **RMI**.

## Requisitos Funcionais e Não Funcionais

### RF001 - Gerenciamento de Produtos
- **RF001.1:** Permitir o **cadastro de produtos** com **nome**, **preço unitário**, **unidade**, **quantidade mínima/máxima** e **categoria**.
- **RF001.2:** Permitir o **reajuste de preço** de todos os produtos por **percentual**.

### RF002 - Gerenciamento de Categorias
- **RF002.1:** Permitir o **cadastro de categorias** com os seguintes atributos: **nome**, **tamanho** e **tipo de embalagem**.

### RF003 - Movimentação de Estoque
- **RF003.1:** Permitir a **entrada de produtos** no estoque.
- **RF003.2:** Permitir a **saída de produtos** do estoque.
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

### **RF006 - Comunicação via RMI**
- **RF006.1:** O sistema deve utilizar **Java RMI (Remote Method Invocation)** para permitir a comunicação entre o **cliente** e o **servidor**.
- **RF006.2:** O **servidor** deve disponibilizar **métodos remotos** para **cadastro**, **listagem** e **movimentação** de produtos e categorias.
- **RF006.3:** O **cliente** deve **consumir esses serviços remotamente**, garantindo a interação com o estoque de forma **distribuída**.

## Requisitos Não Funcionais

### RNF001 - Arquitetura e Comunicação via RMI
- **RNF001.1:** Utilizar **Java RMI (Remote Method Invocation)** para permitir a **comunicação remota** entre o **cliente** e o **servidor**.
- **RNF001.2:** Garantir que a **conexão remota** seja estável e mantenha a **integridade dos dados** durante as operações distribuídas.
- **RNF001.3:** Estruturar o sistema em **camadas separadas** (front-end e back-end), com comunicação exclusivamente via **serviços RMI**.

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
- **RNF004.2:** A **interface gráfica** deve ser **clara, intuitiva** e adequada ao **fluxo de trabalho**.

## Equipe

| Nome do Aluno                    | Usuário Github  | RA do Aluno |
|----------------------------------|-----------------|-------------|
| Iago Bastos de Oliveira          | @ioliveira01    | 1073513349  |
| Pedro henrique antunes gonçalves | @darkss404      | 10725111381 |
| Hector Dartagnan Viana de Brum   | @Eudarta        | 10725116554 |
| Gabriel González Mattos          | @gabinhogmtts   | 1072517870  |

## Requisitos para Rodar o Projeto

- **Java 11** ou superior instalado e configurado no sistema
- **IDE Java** (recomendado: **Apache NetBeans** ou **IntelliJ IDEA**)
- **Clonar** este repositório e o do **front-end** (link disponível na seção anterior)
- **Executar primeiro o servidor RMI**, disponível no projeto do back-end
- **Verificar** se a porta utilizada pelo **Registry RMI** está livre
- **Em seguida**, executar o **cliente (front-end)** para consumir os serviços remotos
- **Banco de dados** deve estar configurado e em execução
- **Credenciais do banco de dados:**
  - **Usuário:** `root`
  - **Senha:** `TrabalhoA3`
