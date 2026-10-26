package com.unidade6.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.unidade6.modelo.Estudante;

public class TestaAtualizacao {

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

            // 2. Busca o estudante com ID 1 na base de dados
            System.out.println("A procurar o estudante para atualizar...");
            Estudante estudante = session.get(Estudante.class, 1L);

            if (estudante != null) {
                System.out.println("Estudante encontrado: " + estudante.getNome());
                
                // 3. Altera os dados do objeto em memória
                estudante.setEmail("antonio.novoemail@email.com");
                System.out.println("E-mail alterado para: " + estudante.getEmail());

                // No Hibernate, quando alteramos um objeto recuperado dentro de uma transação ativa,
                // ele atualiza automaticamente (dirty checking) ao fazer o commit.

                // 4. Comita a transação
                session.getTransaction().commit();
                System.out.println("Estudante atualizado com sucesso na base de dados!");
            } else {
                System.out.println("Estudante com o ID 1 não foi encontrado.");
            }

        } finally {
            // Fecha a sessão e a factory para libertar recursos
            session.close();
            factory.close();
        }
    }
}