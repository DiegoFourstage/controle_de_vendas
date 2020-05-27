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



use projeto;
