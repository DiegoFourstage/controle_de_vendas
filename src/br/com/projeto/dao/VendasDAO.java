package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
