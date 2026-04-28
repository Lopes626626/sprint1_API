# Metaindústria - API de Ocorrências 🏭

## Descrição da API
Esta API REST foi desenvolvida com Spring Boot para compor a base do sistema backend do nosso projeto de Metaindústria. O sistema atua no recebimento, registro e gestão de dados de inspeção em uma esteira de produção. Quando um sistema de visão computacional ou sensor identifica uma anomalia (como uma embalagem com defeito ou contagem incorreta de itens), a API registra essa ocorrência no banco de dados para futura análise e controle de qualidade.

## Entidade Escolhida
A entidade principal do domínio é a **Ocorrencia**. Ela representa o registro físico e temporal de uma anomalia detectada na linha de produção.

Atributos da entidade:
* `id`: Identificador único da ocorrência.
* `tipoDefeito`: Categoria do problema detectado (ex: "Embalagem rasgada", "Item faltante").
* `linhaProducao`: O local de origem do alerta (ex: "Esteira Principal", "Linha 2").
* `dataHora`: O momento exato em que a anomalia foi registrada.
* `status`: A situação atual do alerta (ex: "Pendente", "Analisado").

## Endpoints Disponíveis
A arquitetura contempla um CRUD completo acessível através do path base `/api/ocorrencias`.

* **POST** `/api/ocorrencias` - Cria e registra uma nova ocorrência no sistema.
* **GET** `/api/ocorrencias` - Lista todas as ocorrências industriais registradas.
* **GET** `/api/ocorrencias/{id}` - Busca os detalhes de uma ocorrência específica pelo seu ID.
* **PUT** `/api/ocorrencias/{id}` - Atualiza as informações ou o status de uma ocorrência existente.
* **DELETE** `/api/ocorrencias/{id}` - Remove o registro de uma ocorrência do banco de dados.

## Como Rodar o Projeto
1. Faça o clone deste repositório em sua máquina local.
2. Abra a pasta do projeto em sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code).
3. Aguarde o Maven realizar o download das dependências listadas no `pom.xml`.
4. Execute a aplicação através da classe principal `BackendConsultasApplication.java`.
5. A API estará disponível e rodando em `http://localhost:8080`.
6. Para visualizar os dados persistidos, acesse o painel do banco H2 no navegador: `http://localhost:8080/h2-console`
   * **JDBC URL:** `jdbc:h2:file:./data/metaindustria_db`
   * **User Name:** `sa`
   * **Password:** *(deixar em branco)*
