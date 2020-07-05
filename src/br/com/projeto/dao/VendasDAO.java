package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Produtos;
import br.com.projeto.model.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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

    // Cadastrar a venda
    public void cadastrarVendas(Vendas obj) {
        // Corrigindo aonde não foi inserido o nome da dataBase
        try {
            String sql = "insert into tb_vendas (cliente_id, data_venda, total_venda, observacao) values (?,?,?,?)";
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, obj.getCliente().getId());
            pst.setString(2, obj.getData_venda());
            pst.setDouble(3, obj.getTotal_venda());
            pst.setString(4, obj.getObs());

            pst.execute();

            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Retorna o total das vendas
    public int retornaUltimaVenda() {
        try {
            int idVenda = 0;

            String sql = "select max(id) id from tb_vendas";
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                Vendas v = new Vendas();
                v.setId(rs.getInt("id"));

                idVenda = v.getId();
            }
            return idVenda;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //Listar histórico de vendas por um período de data
    public List <Vendas> consultaPeridoDataVendas(LocalDate dataInicial, LocalDate dataFinal){
        try {            
            String sql = "select v.id, date_format(v.data_venda, '%d/%m/%Y') as data_formatada, c.nome, v.total_venda, v.observacao from tb_vendas as v inner join tb_clientes as c on(v.cliente_id = c.id) where v.data_venda BETWEEN ? AND ?";
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, dataInicial.toString());
            pst.setString(2, dataFinal.toString());
            rs = pst.executeQuery();
            
            List <Vendas> lista = new ArrayList<>();
            while(rs.next()){
                Vendas obj = new Vendas();
                
                obj.setId(rs.getInt("v.id"));
                obj.setData_venda(rs.getString("data_formatada"));
                
                Clientes objCli = new Clientes();
                objCli.setNome(rs.getString("c.nome"));
                
                obj.setCliente(objCli);
                
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                obj.setObs(rs.getString("v.observacao"));
                
                lista.add(obj);
            }
            
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
 
    }
    
    // Método que calcula total da venda por data
    public double rotornaTotalVendaPorData(LocalDate data_venda){
        
        try {
            double totalVenda = 0;
            // Titando o espaço de sum, com espaço ele da error
            String sql = "select sum(total_venda) as total from tb_vendas where data_venda = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, data_venda.toString());
            rs = pst.executeQuery();
            
            if(rs.next()){
                totalVenda = rs.getDouble("total");
            }
            return totalVenda;
        } catch (Exception e) {
            throw new RuntimeException();            
        }
    }
}
