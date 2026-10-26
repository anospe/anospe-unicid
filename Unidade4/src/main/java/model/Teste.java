package model;

import java.util.List;

public class Teste {

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // 1. Testar a Inserção de um Estudante (Create)
        Student novoEstudante = new Student();
        novoEstudante.setName("António Pereira");
        novoEstudante.setEmail("antonio.pereira@email.com");
        novoEstudante.setCourse("Ciência da Computação");
        
        dao.cadastrar(novoEstudante);

        // 2. Testar a Listagem de Estudantes (Read)
        System.out.println("\n--- Lista de Estudantes Registados ---");
        List<Student> estudantes = dao.listar();
        
        for (Student s : estudantes) {
            System.out.println("ID: " + s.getId() + 
                               " | Nome: " + s.getName() + 
                               " | Email: " + s.getEmail() + 
                               " | Curso: " + s.getCourse());
        }
    }
}