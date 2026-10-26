package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Método para Inserir um Estudante (Create)
    public void cadastrar(Student student) {
        // Ajustado para os nomes reais das colunas da tabela no MySQL (nome, email, curso)
        String sql = "INSERT INTO student (nome, email, curso) VALUES (?, ?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getCourse());
            
            stmt.executeUpdate();
            System.out.println("Estudante cadastrado com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar estudante: " + e.getMessage());
        }
    }

    // Método para Listar todos os Estudantes (Read)
    public List<Student> listar() {
        String sql = "SELECT * FROM student";
        List<Student> students = new ArrayList<>();
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));   // Ajustado para corresponder à coluna 'nome'
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course")); // Ajustado para corresponder à coluna 'curso'
                students.add(s);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar estudantes: " + e.getMessage());
        }
        
        return students;
    }
}