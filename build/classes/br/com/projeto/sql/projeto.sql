create database projeto; -- Criando uma nova dabase
use projeto; -- Para selecionar a a dabase a ser usada

-- Nossa primeira tabela a ser Criada, vai ser praticamente a nossa base
-- Tabela Clientes
create table tb_clientes(
id int auto_increment primary key,
nome varchar(100),
rg varchar(30),
cpf varchar(20),
email varchar(200),
telefone varchar(30),
celular varchar(30),
cep varchar(100),
endereco varchar(255),
numero int,
complemento varchar(200),
bairro varchar(100),
cidade varchar(100),
estado varchar(2)
);

describe tb_clientes; -- Descrevendo os campos select * from tb_clientes; -- Exibindo os clientes cadastrados
select * from tb_clientes;
-- -----------------------DADOS SQL-----------------------------------------------------------
	-- Inserir cliente sql
insert into tb_clientes (nome, rg, cpf, email, telefone, celular, cep, endereco, 
numero, complemento, bairro, cidade, estado) 
values (?,?,?,?,?,?,?,?,?,?,?,?,?);
-- aonde os ? seria os dados em sequencia nos parametros acima
	-- Excluir Cliente 
delete from tb_clientes where id=?;
	-- Alterar Cliente
update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, 
cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?;
	-- Busca por nome 
select * from tb_clientes where nome like 'y%';
	-- Consulta por nome, igualdade, usado para buscar CPF
    select * from tb_clientes where nome = ?;
-- ----------------------------------------------------------------------------------

-------------------------- Relacionado ao Usuário------------------------------------
create table tb_funcionarios(
id int auto_increment primary key,
nome varchar(100),
rg varchar(30),
cpf varchar(20),
email varchar(200),
senha varchar(100),
cargo varchar(100),
nivel_acesso varchar(50),
telefone varchar(30),
celular varchar(30),
cep varchar(100),
endereco varchar(255),
numero int,
complemento varchar(200),
bairro varchar(100),
cidade varchar(100),
estado varchar(2)
);

describe tb_funcionarios;
select * from tb_funcionarios;

create table tb_fornecedor(
id int primary key auto_increment,
nome varchar(50), 
cnpj varchar (50) ,
email varchar (200),
telefone varchar(30),
celular varchar(30),
cep varchar(100),
endereco varchar(255),
numero int,
complemento varchar(200),
bairro varchar(100),
cidade varchar(100),
estado varchar(2)
);

describe tb_fornecedor;
select * from tb_fornecedor;

-- ----------------------------------------------------------------------------------

-------------------------- Relacionado ao Produtos ----------------------------------

create table tb_produtos (
id int primary key auto_increment,
descricao varchar(100),
preco decimal (10,2),
qtd_estoque int,
for_id int, -- Chave Estrangeira

foreign key (for_id) references tb_fornecedor(id)
);

describe tb_produtos;
select * from tb_produtos;

-- Para poder fazer interação de dados de fornecedor em produtos 
-- precisamos fazer o inner join
-- Caminho para atualizar dados do estoque 
-- String sql = "update tb_produtos set qtd_estoque = ?  where id=?";

select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p
inner join tb_fornecedor as f on (p.for_id = f.id);

-- -------------------------------Relacionado a Venda ------------------------------
create table tb_vendas(
id int primary key,
cliente_id int,
data_venda datetime,
total_venda decimal (10,2),
observacao varchar(100)
);

-- Retorna o valor maximo das vendas
select max(id) id from tb_vendas;

describe tb_vendas;
select * from tb_vendas;

-- Formatando a data pelo sql
-- date_format(data_venda, %d/%m/%Y) as data_formatada
-- no caso a String completa ficaria assim
-- "select v.id, date_format(v.data_venda, '%d/%m/%Y') as data_formatada, c.nome, v.total_venda, 
-- v.observacao from tb_vendas as v inner join tb_clientes as c on(v.cliente_id = c.id) where v.data_venda BETWEEN ? AND ?"

-- Total da venda caminho sql, obs: sum entre parentes não pode ter espaço entre eles
select sum(total_venda) as total from tb_vendas where data_venda = '2020-06-26';
-- -------------------------------Relacionado a Item das Vendas --------------------
CREATE TABLE tb_itensvendas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    venda_id INT,
    produto_id INT,
    qtd INT,
    subtotal DECIMAL(10 , 2 )
);

-- Setando dados da tabela Itens de vendas
-- Ao clicar dados será preenchido em outra tabela usando o inner join
select i.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id = 1;


describe tb_itensvendas;
select * from tb_itensvendas;

use projeto;	
