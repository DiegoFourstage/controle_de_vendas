package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.ItemVendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author D1350
 */
public class ItensVendasDAO {

    Connection conexao;
    PreparedStatement pst;

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

}
