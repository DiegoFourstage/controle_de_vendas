# controle_de_vendas
Controle de Vendas

Commit 04
Novo pacote model e sql, no pacote model nova classe Clientes e encapsulando atributos com seus geeter e setters, no pacote sql 
adicionando novo banco de dados com nome de "projeto" e adicionando nova tabela de Clientes com seus elementos

Commit 05 
Criando um novo pacote br.com.projeto.jdbc, a dentro m�todo Connection getConnection classe respons�vel para a conex�o com o banco de dados

Commit 06 Testando a conex�o com o banco de dados
Nova classe TesteConexao, classe respons�vel para testar a nossa conex�o
Caso n�o conecte erro exception mostrado em um MessageDialog

Commit 07 M�todo Cadastrar Cliente
Novo pacote br.com.projeto.dao, nova classe ClientesDAO, criar construtor
Para conex�o com o banco de dados assim toda vez que chamar a conex�o com o banco de dados ser� executada, apenas fecharar a conex�o ap�s ser inserido dados e atualizado os dados dos Clientes

Commit 08 Formatando RG, CPF, Cel, Tel e CEP
Modificando o Campo de texto para Campo formatado dos itens acima, em propriedade item selecionado em formatterFactory selecione m�scara e segue abaixo formata��es:
Cpf: ###.###.###-##
Rg: ##.###.###-##
Cel: (##) # ####-####
Tel: (##) ####-####
Cep: ## ###-###

Commit 09 Implementando M�todo Cadastrar Cliente
Iremos para a classe FrmClientes, em btnSalvar vamos adicionar novo envento ActionPerformed, assim que clicado ele executarar, nesse evento
Instanciaremos a classe Clientes ela ser� nosso obj, exemplo: obj.setNome(txtNome.getText(); isso para uma String, para Int
Obj.setNumero(Integer.parseInt(txtNumero.getText)); agora para um Cbox
Obj.setUf(cboUf.getSelectedItem().toString());

Ap�s todos os dados inseridos instanciaremos nosso ClienteDAO, para acessar nosso m�todo cadastrar e em par�metros ele receberar o obj
cliente


