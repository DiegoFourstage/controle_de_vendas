/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author D1350
 */
public class FornecedorDAO {

    Connection conexao;

    public FornecedorDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    /*
    Cadastrar Fornecedor
     */
    public void cadastrar(Fornecedor obj) {
        try {
            String sql = "insert into tb_fornecedor(nome, cnpj, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCnpj());
            pst.setString(3, obj.getEmail());
            pst.setString(4, obj.getTelefone());
            pst.setString(5, obj.getCelular());
            pst.setString(6, obj.getCep());
            pst.setString(7, obj.getEndereco());
            pst.setInt(8, obj.getNumero());
            pst.setString(9, obj.getComplemento());
            pst.setString(10, obj.getBairro());
            pst.setString(11, obj.getCidade());
            pst.setString(12, obj.getUf());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Forncedor cadastrado com sucesso !");
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /*
    Listar Fornecedor em TabelaDefault
     */
    public List<Fornecedor> listar() {
        try {
            String sql = "select * from tb_fornecedor";
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            List<Fornecedor> lista = new ArrayList();

            while (rs.next()) {
                Fornecedor obj = new Fornecedor();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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
        }
        return null;
    }

    /*
    Editar Cliente
    Antes ou depois criar método setar em FrmFornecedor
    em tabela evento, Mouse, mouseClicked
     */
    public void atualizar(Fornecedor obj) {
        try {
            String sql = "update tb_fornecedor set nome=?, cnpj=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCnpj());
            pst.setString(3, obj.getEmail());
            pst.setString(4, obj.getTelefone());
            pst.setString(5, obj.getCelular());
            pst.setString(6, obj.getCep());
            pst.setString(7, obj.getEndereco());
            pst.setInt(8, obj.getNumero());
            pst.setString(9, obj.getComplemento());
            pst.setString(10, obj.getBairro());
            pst.setString(11, obj.getCidade());
            pst.setString(12, obj.getUf());
            pst.setInt(13, obj.getId());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com Sucesso !");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void excluir(Fornecedor obj) {
        int excluir = JOptionPane.showConfirmDialog(null, "Deseja mesmo EXCLUIR !", "Atenção ", JOptionPane.YES_NO_OPTION);

        if (excluir == JOptionPane.YES_NO_OPTION) {
            try {
                String sql = "delete from tb_fornecedor where id=? ";
                PreparedStatement pst = conexao.prepareStatement(sql);
                pst.setInt(1, obj.getId());

                pst.execute();
                JOptionPane.showMessageDialog(null, "Forncedor excluido com suceeso");
                pst.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Fornecedor ainda mantido !");
        }

    }

    /*
    Pesquisar pelo Fornecedor por caracteres em Painel 2    
     */
    public List<Fornecedor> pesquisaNome(String nome) {
        try {
            String sql = "select * from tb_fornecedor where nome like ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();

            List<Fornecedor> lista = new ArrayList<>();

            while (rs.next()) {
                Fornecedor obj = new Fornecedor();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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
        }
        return null;
    }

    /*
    Método usado para busca de CPF, mais vamos usar para busca em nome
     */
    public Fornecedor consultaNome(String nome) {
        try {
            String sql = "select * from tb_fornecedor where nome=?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();

            Fornecedor obj = new Fornecedor();

            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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
            }
            return obj;
        } catch (Exception e) {
        }
        return null;
    }

}
