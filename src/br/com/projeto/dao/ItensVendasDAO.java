package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.ItemVendas;
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
public class ItensVendasDAO {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    // Conexão com o banco de dados
    public ItensVendasDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    // Método cadastrar os itens
    public void cadastrarItensVendas(ItemVendas obj) {
        try {
            // Caminho sql para inserção de dados       
            String sql = "insert into tb_itensvendas (venda_id, produto_id, qtd, subtotal) values (?,?,?,?)";
            // Preparando as conexões
            pst = conexao.prepareStatement(sql);
            // Passando dados para o objetos
            pst.setInt(1, obj.getVenda().getId());
            pst.setInt(2, obj.getProduto().getId());
            pst.setInt(3, obj.getQtd());
            pst.setDouble(4, obj.getSubtotal());

            //Atulizando os dados que vai ser inserido 
            pst.execute();

            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Método para listar itens da vendas, usando para Detalhar a venda
    public List<ItemVendas> listarItensVendas(int venda_id) {
        try {

            String sql = "select i.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id = ?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, venda_id);
            rs = pst.executeQuery();

            List<ItemVendas> lista = new ArrayList<>();

            while (rs.next()) {
                ItemVendas objItens = new ItemVendas(); // Obj para itens das vendas
                Produtos objPro = new Produtos(); // Obj dos produtos

                objItens.setId(rs.getInt("i.id")); // Id dos itens vendas

                objPro.setDescricao(rs.getString("p.descricao")); // Nome do produto                

                objItens.setQtd(rs.getInt("i.qtd")); // Qtd dos itens;
                
                objPro.setPreco(rs.getDouble("p.preco")); // Pre             

                objItens.setSubtotal(rs.getDouble("i.subtotal"));
                
                objItens.setProduto(objPro); // Vinculando dados do produtos para Itens vendas

                lista.add(objItens);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}
