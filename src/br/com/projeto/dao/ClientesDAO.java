package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public void cadastraCliente(Clientes obj) {
        try {
            // Caminho sql para inserção de dados a tb_clientes
            String sql = "insert into tb_clientes (nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // Prepatando a ser inserido os dados
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
            pst.setInt(2, obj.getNumero());
            pst.setString(9, obj.getComplemento());
            pst.setString(10, obj.getBairro());
            pst.setString(11, obj.getCidade());
            pst.setString(12, obj.getUf());

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

}
