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

Commit 10 Criando m�todo listar Clientes
Na classe ClientesDAO novo m�todo public de uma lista de Clientes, a dentro desse m�todo instanciaremos uma lista de Clientes isso dentro de um try e catch, ap�s comando sql para selecionar elementos, preparando a conex�o,  e fazendo a filtragem com ResultSet, estrutura enquando a filtragem encontrar dados na tabela de dados, obj receberar dados, esse dados ser� adicionado a nossa ArrayList criado no �nicio, ap�s chaves return a uma lista e em catch return null

Commit 11 Implementando m�todo listar Clientes
Usaremos o DefaultTableModel, n�o entraremos muito em detalhes, mais seria bom pesquisar sobre ele, por n�o ser indicado por muitos, mais no nosso caso por enquanto ele nos suprime.
Na classe FrmClientes, novo m�todo public void listar, instanciaremos nosso ClietesDAO dao, criaremos uma List de Clientes, nossa lista ela receberar o nosso m�todo listarClientes, abaixo chamaremos o DefaultTableModel dados ele ser� igual a nossa (DefaultTableModel)tblClientes.getModel(); assim modificando l�, limparemos a tabela dados.setNumRow que receberar zero, vamos percorrer a nossa lista com o for Clientes c : lista, a dentro dados.addRow um novo object[]{}); dentro das chaves do novo object
c.getId(), c.getNome(), etc ... Ap�s em projeto selecione JFrame e adicione novo evento WindowsActived, e chama o m�todo listar, esse evento ele executarar ao abrir o sistema

Commit 12 Commit anterior, Alterar e Excluir Cliente

Cria��o de 2 m�todos muito id�ntico ao que j� vimos, apenas mudar� o c�digo sql, em excluir apenas setaremos o id, j� em alterar teremos que setar todos e mais o id no final que ser� nossa coluna 14 dos itens.


Commit 13 Setando Tabela Cliente aos campos Vazios

Antes de editar e excluir vamos setar os dados para os campos em brancos para facilitar as altera��es, cada elemento � um n�mero, por exemplo o id
� representado pelo n�mero 0, o nome � representado pelo n�mero 1, e assim por diante, o exemplo � esse: txtId.setText(tbCliente.getValueAt(tblClientes.getSelectedRow(),0).toString());
O meu obj txtId, como fa�o que pra ele sete na tabela pelaa linha, o elemento 0 seria nosso id convertido para uma String, assim mostrando no campo em branco, dica o combobox em vez de setText, ele fica setSelectedItem, antes dos c�digos pode se colocar tamb�m o c�digo que ao clicar ele vai at� a minha  tabela de cadastro de Clientes j� preenchido com os dados para assim ficar mais pr�tico para fazer as altera��es, segue como fazer, copie o nome do Painel: jTabbedPane1.setSelectedIndex(0); isso irar para o painel 0, assim que selecionar e clicar

15 Implementando m�todos Alterar e Excluir Clientes

Na classe FrmClintes adicione novos eventos para os bot�es Alterar e Excluir, em excluir � s� setar todos os objetos, no meu caso o meu Id ele
� auto_increment n�o � necess�rio setarTexto, j� no bot�o Excluir temos que chamar o obj id por que ele � a nossa refer�ncia

Commit 16 Busca pelo nome e implementando m�todos
Neste commit algo parecido com o m�todo listaClientes, apenas em par�metros criaremos uma nova String nome, e no valor pst.setString ficarar 1, e mais o par�metro nome nos demais n�o precisa alterar e sim agora implementar no Frm, renomeie � vari�vel do campo pesquisar para txtPesquisar e o Bot�o para btnPesquisar, nos dois o m�todo ser� igual apenas eventos que ser�o diferentes, no bot�o usaremos evento ActionPerformed, a dentro do m�todo nova String nome que ser� igual ao nosso jTextfield txtPesquisar.getText(), concatene no in�cio com o caractere %, ficar� assim String nome = �%� + txtPesquisar.getText() + �%�; Toda pesquisa que se inicie com a letra escolhida filtrar e pegarar dados a sua tabela, ap�s copie o que � de dentro do m�todo listar, apenas trocaremos de m�todo de listarClientes para buscarPorClientes pegando o par�metro String nome, m�todo criado crie um novo evento KeyPressed em txtPesquisar e cole o mesmo m�todo, ao digitar exibir� nome a tabela


Commit 17 M�todo limpar campos e implementando

Nova classe Utilit�rios, m�todo novo adicionado, implementando nos bot�es, quando bot�o for acionado, limpar� todos os campos de textos

Commit 18 Consulta por Cliente(Painel Cadastro)
M�todo usado para consulta de cpf, mais usaremos a consulta por nome, para que que essa consulta seja feita, o nome do cliente tem que ser ind�ntico, se n�o ele retornarar null, com mensagem de Cliente n�o encontrado 



