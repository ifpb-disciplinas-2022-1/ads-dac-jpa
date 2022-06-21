package br.edu.ifpb.main;

import br.edu.ifpb.domain.Editora;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 06/06/2022, 19:55:37
 */
public class Principal {

    public static void main(String[] args) {
        EntityManager manager = Persistence
                .createEntityManagerFactory("ExemploPostgres")
                .createEntityManager();
//        Editora editora = new Editora(
//                2, "Sousa", "Guru do Dino"
//        );
//        manager.getTransaction().begin();
//        manager.persist(editora);
//        manager.getTransaction().commit();
        Editora editora = manager.find(Editora.class, -1);
        System.out.println("nome = " + editora.getNomeFantasia());
        System.out.println("local = " + editora.getLocalDeOrigem());
//        manager.getTransaction().begin();
//        editora.setLocalDeOrigem("CZ");
//        manager.merge(editora);
//        manager.getTransaction().commit();

//        TypedQuery<Editora> editoras = manager.createQuery("SELECT e FROM Editora e", Editora.class);
//        editoras.getResultList()
//                .forEach(
//                        editora -> System.out.println("nome = " + editora.getNomeFantasia())
//                );
    }
}
