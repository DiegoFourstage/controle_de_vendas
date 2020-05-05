package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author D1350
 */
public class ClientesDAO {

    private Connection conexao;

    //Método ClienteDAO, para nossa conexao
    public ClientesDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // Cadastrar Clientes
    public void cadastraCliente(Clientes obj) {
        try {
            // Caminho sql para inserção de dados a tb_clientes
            String sql = "insert into tb_clientes (nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // Preparando a ser inserido os dados
            PreparedStatement pst = conexao.prepareStatement(sql);

            // Ao inserir os dados
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRg());
            pst.setString(3, obj.getCpf());
            pst.setString(4, obj.getEmail());
            pst.setString(5, obj.getTelefone());
            pst.setString(6, obj.getCelular());
            pst.setString(7, obj.getCep());
            pst.setString(8, obj.getEndereco());
            pst.setInt(9, obj.getNumero());
            pst.setString(10, obj.getComplemento());
            pst.setString(11, obj.getBairro());
            pst.setString(12, obj.getCidade());
            pst.setString(13, obj.getUf());

            // Atualizando os dados que ja foram inseridos
            pst.execute();
            // Fechando a conexao
            pst.close();
            // Mensagem 
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso !");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Listar Clientes
    public List<Clientes> listarClientes() {

        try {
            // Criando a lista 1º Passo
            List<Clientes> lista = new ArrayList<>();

            // Criando o comando sql de exibição 2º Passo
            String sql = "select * from tb_clientes";

            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Filtrar a tb_clientes            
            while (rs.next()) {
                // Caso encontre no meu banco de dados me atribui ao obj os dados da tabela que será exibida
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                // Adicionando obj a lista
                lista.add(obj);
            }
            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
            return null;
        }

    }

    public void alterarCliente(Clientes obj) {
        try {
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRg());
            pst.setString(3, obj.getCpf());
            pst.setString(4, obj.getEmail());
            pst.setString(5, obj.getTelefone());
            pst.setString(6, obj.getCelular());
            pst.setString(7, obj.getCep());
            pst.setString(8, obj.getEndereco());
            pst.setInt(9, obj.getNumero());
            pst.setString(10, obj.getComplemento());
            pst.setString(11, obj.getBairro());
            pst.setString(12, obj.getCidade());
            pst.setString(13, obj.getUf());
            pst.setInt(14, obj.getId());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente Alterado com suceeso !");
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void excluirCliente(Clientes obj) {
        try {
            String sql = "delete from tb_clientes where id=?";
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso !");
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public List<Clientes> buscarPorNome(String nome) {
        try {
            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            
            List <Clientes> lista = new ArrayList<>();

            while (rs.next()) {
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
               
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}
