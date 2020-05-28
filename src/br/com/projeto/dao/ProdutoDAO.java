package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author D1350
 */
public class ProdutoDAO {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    public ProdutoDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // Cadastrando Produto, Obs: Existe uma chave Estrangeira de Fornecedores    
    public void cadastrarProduto(Produtos obj) {
        try {
            String sql = "insert into tb_produtos (descricao, preco, qtd_estoque, for_id) values (?,?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, obj.getDescricao());
            pst.setDouble(2, obj.getPreco());
            pst.setInt(3, obj.getQtdEstoque());
            pst.setInt(4, obj.getFornecedor().getId()); // Cadastrando o obj Fornecedor pegando seu Id

            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com Sucesso");
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
