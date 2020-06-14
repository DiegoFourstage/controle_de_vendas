package br.com.projeto.model;

/**
 *
 * @author D1350
 */
public class Vendas {
    
    //Atributos
    private int id;
    private Clientes cliente;
    private String data_venda; // Corrigindo nome
    private double total_venda;
    private String obs;    
    
    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getData_venda() {
        return data_venda;
    }
    
    // Corrigindo os getters e setters de Data
    public void setData_venda(String data_time) {
        this.data_venda = data_time;
    }

    public double getTotal_venda() {
        return total_venda;
    }

    public void setTotal_venda(double total_venda) {
        this.total_venda = total_venda;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
}
