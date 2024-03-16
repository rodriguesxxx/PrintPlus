package printplus;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Conexao {
    public static Connection getConexao() throws SQLException, RuntimeException {
        try {
            final String database = "printplus";
            final String url = "jdbc:mysql://localhost/" + database + "?useSSL=false";
            final String usuario = "rodriguesxxx";
            final String senha = "";

            System.out.println("Conectado com sucesso!");
            return getConnection(url, usuario, senha);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}