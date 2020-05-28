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
    
    public List<Produtos> listarProduto(){
        try {
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p\n" +
"inner join tb_fornecedor as f on (p.for_id = f.id);";
            
            List<Produtos> lista = new ArrayList<>();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao("p.descricao");
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

}
