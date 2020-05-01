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

Commit 08 Formatando RG, CPF, Cel, Tel e CEP
Modificando o Campo de texto para Campo formatado dos itens acima, em propriedade item selecionado em formatterFactory selecione máscara e segue abaixo formatações:
Cpf: ###.###.###-##
Rg: ##.###.###-##
Cel: (##) # ####-####
Tel: (##) ####-####
Cep: ## ###-###

Commit 09 Implementando Método Cadastrar Cliente
Iremos para a classe FrmClientes, em btnSalvar vamos adicionar novo envento ActionPerformed, assim que clicado ele executarar, nesse evento
Instanciaremos a classe Clientes ela será nosso obj, exemplo: obj.setNome(txtNome.getText(); isso para uma String, para Int
Obj.setNumero(Integer.parseInt(txtNumero.getText)); agora para um Cbox
Obj.setUf(cboUf.getSelectedItem().toString());

Após todos os dados inseridos instanciaremos nosso ClienteDAO, para acessar nosso método cadastrar e em parâmetros ele receberar o obj
cliente

Commit 10 Criando método listar Clientes
Na classe ClientesDAO novo método public de uma lista de Clientes, a dentro desse método instanciaremos uma lista de Clientes isso dentro de um try e catch, comando sql para selecionar elementos, preparando a conexão,  e fazendo a filtragem com ResultSet, estrutura enquando a filtragem encontrar dados na tabela de dados obj receberar dados, esse dados será adicionado a nossa ArrayList criado no ínicio, após chaves return a uma lista e em catch return null


