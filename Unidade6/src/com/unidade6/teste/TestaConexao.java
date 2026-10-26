package com.unidade6.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.unidade6.modelo.Estudante;

public class TestaConexao {

    public static void main(String[] args) {
        // Configura e cria a SessionFactory a partir do hibernate.cfg.xml
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Estudante.class)
                                    .buildSessionFactory();

        // Abre uma sessão diretamente
        Session session = factory.openSession();

        try {
            System.out.println("A criar um novo estudante...");
            Estudante estudante = new Estudante("António Pereira", "antonio.pereira@email.com");

            // Inicia a transação
            session.beginTransaction();

            // Guarda o objeto na base de dados
            session.save(estudante);

            // Comita a transação
            session.getTransaction().commit();

            System.out.println("Estudante guardado com sucesso! ID gerado: " + estudante.getId());

        } finally {
            // Fecha a sessão e a factory para libertar recursos
            session.close();
            factory.close();
        }
    }
}