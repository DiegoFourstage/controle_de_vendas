# controle_de_vendas
Controle de Vendas

Commit 04
Novo pacote model e sql, no pacote model nova classe Clientes e encapsulando atributos com seus geeter e setters, no pacote sql 
adicionando novo banco de dados com nome de "projeto" e adicionando nova tabela de Clientes com seus elementos

Commit 05 
Criando um novo pacote br.com.projeto.jdbc, a dentro método Connection getConnection classe responsável para a conexão com o banco de dados

Commit 06 Testando a conexão com o banco de dados
Nova classe TesteConexao, classe responsável para testar a nossa conexão
Caso não conecte erro exception mostrado em um MessageDialog

Commit 07 Método Cadastrar Cliente
Novo pacote br.com.projeto.dao, nova classe ClientesDAO, criar construtor
Para conexão com o banco de dados assim toda vez que chamar a conexão com o banco de dados será executada, apenas fecharar a conexão após ser inserido dados e atualizado os dados dos Clientes

