
package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author D1350
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        
        // Tratamento de erros try e catch
        try {
            // Nossa String de conexão com o banco de dados
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/projeto", "root", "");
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        
    }
    
}
