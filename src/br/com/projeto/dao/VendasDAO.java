package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Produtos;
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
public class VendasDAO {

    private Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    public VendasDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // Buscar Nome por Cpf
    public Clientes buscaPorCpf(String cpf) {
        try {
            String sql = "select * from tb_clientes where cpf = ? ";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cpf);
            rs = pst.executeQuery();

            Clientes obj = new Clientes();

            if (rs.next()) {

                obj.setNome(rs.getString("nome"));

            } else {
                JOptionPane.showMessageDialog(null, "Cpf não econtrado !");
            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    //Busca nome por uma lista
    public List<Clientes> buscarNome(String nome) {
        try {
            String sql = "select * from tb_clientes where nome like ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();

            List<Clientes> lista = new ArrayList<>();

            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setCpf(rs.getString("cpf"));

                lista.add(obj);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    //Buscar produto por Cod e exibir seus dados nos campos de textos
    public Produtos buscaProduto(int cod) {
        try {
            String sql = "select * from tb_produtos where id = ?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, cod);
            rs = pst.executeQuery();

            Produtos obj = new Produtos();
            if (rs.next()) {
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado !");
            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
