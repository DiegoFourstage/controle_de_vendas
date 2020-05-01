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

describe projeto; -- Descrevendo os campos 
select * from tb_clientes; -- Exibindo os clientes cadastrados

-- Inserir cliente sql
insert into tb_clientes (nome, rg, cpf, email, telefone, celular, cep, endereco, 
numero, complemento, bairro, cidade, estado) 
values (?,?,?,?,?,?,?,?,?,?,?,?,?);
-- aonde os ? seria os dados em sequencia nos parametros acima
