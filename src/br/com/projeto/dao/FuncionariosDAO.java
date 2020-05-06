/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author D1350
 */
public class FuncionariosDAO {

    Connection conexao = null;

    public FuncionariosDAO() {
       this.conexao = new ConnectionFactory().getConnection();
    }

    // Cadastrar Funcionários
    public void cadastrar(Funcionarios obj) {
        try {
            String sql = "insert into tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getRg());
            pst.setString(3, obj.getCpf());
            pst.setString(4, obj.getEmail());
            pst.setString(5, obj.getSenha());
            pst.setString(6, obj.getCargo());
            pst.setString(7, obj.getNivel_Acesso());
            pst.setString(8, obj.getTelefone());
            pst.setString(9, obj.getCelular());
            pst.setString(10, obj.getCep());
            pst.setString(11, obj.getEndereco());
            pst.setInt(12, obj.getNumero());
            pst.setString(13, obj.getComplemento());
            pst.setString(14, obj.getBairro());
            pst.setString(15, obj.getCidade());
            pst.setString(16, obj.getUf());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Funcionário Cadastrado com Sucesso !");
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
