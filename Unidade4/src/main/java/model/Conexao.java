package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection conectar() {
        Connection conexao = null;
        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Estabelece a ligação com a base de dados dbstudent
            // Substitua "sua_senha" pela senha do seu MySQL, se aplicável
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudent?useTimezone=true&serverTimezone=UTC", "root", "root");
            
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do MySQL não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar à base de dados: " + e.getMessage());
        }
        return conexao;
    }
}