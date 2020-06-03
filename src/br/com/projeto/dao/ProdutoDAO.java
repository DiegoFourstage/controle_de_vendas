package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedor;
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

    public List<Produtos> listarProduto() {
        try {
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p inner join tb_fornecedor as f on (p.for_id = f.id);";

            List<Produtos> lista = new ArrayList<>();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));

                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);

                lista.add(obj);
            }

            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    /*
    Editar Produtos
     */
    public void editarProdutos(Produtos obj) {
        try {
            String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? where id=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, obj.getDescricao());
            pst.setDouble(2, obj.getPreco());
            pst.setInt(3, obj.getQtdEstoque());
            pst.setInt(4, obj.getFornecedor().getId());
            pst.setInt(5, obj.getId());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto alterado com sucessso !");
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void excluirProduto(Produtos obj) {
        int deletar = JOptionPane.showConfirmDialog(null, "Deseja mesmo Excluir !", "Atenção", JOptionPane.YES_NO_OPTION);

        if (deletar == JOptionPane.YES_NO_OPTION) {
            try {
                String sql = "delete from tb_produtos where id=?";
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, obj.getId());

                pst.execute();
                JOptionPane.showMessageDialog(null, "Produto excluido com Sucesso !");
                pst.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                //System.out.println("Error sql : " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Produto ainda mantido !");
        }
    }
    
    public List <Produtos> pesquisaNome(String nome) {
        try {
            String sql = "select  * from tb_produtos where descricao like ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            
            List<Produtos> list = new ArrayList<>();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
                                
                
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id"));
                obj.setFornecedor(f);
                
                list.add(obj);                
            }
            
            return list;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

}