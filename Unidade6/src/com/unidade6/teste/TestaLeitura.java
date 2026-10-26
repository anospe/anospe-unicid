package com.unidade6.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.unidade6.modelo.Estudante;

public class TestaLeitura {

    public static void main(String[] args) {
        // Configura e cria a SessionFactory a partir do hibernate.cfg.xml
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Estudante.class)
                                    .buildSessionFactory();

        // Abre uma sessão diretamente
        Session session = factory.openSession();

        try {
            // 1. Inicia a transação
            session.beginTransaction();

            // 2. Consulta o estudante na base de dados pelo ID (ex: ID 1)
            System.out.println("A procurar o estudante com ID 1...");
            Estudante estudante = session.get(Estudante.class, 1L);

            // 3. Exibe os dados encontrados
            if (estudante != null) {
                System.out.println("Estudante encontrado com sucesso!");
                System.out.println("Detalhes: " + estudante);
            } else {
                System.out.println("Estudante com o ID 1 não foi encontrado.");
            }

            // 4. Comita a transação
            session.getTransaction().commit();

        } finally {
            // Fecha a sessão e a factory para libertar recursos
            session.close();
            factory.close();
        }
    }
}