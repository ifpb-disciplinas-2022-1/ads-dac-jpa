package br.edu.ifpb.main;

import br.edu.ifpb.domain.Editora;
import br.edu.ifpb.domain.Emprestimo;
import br.edu.ifpb.domain.ISBN;
import br.edu.ifpb.domain.Livro;
import br.edu.ifpb.domain.chaves.Telefone;
import br.edu.ifpb.domain.chaves.TelefoneChaveComposta;
import br.edu.ifpb.domain.chaves.TelefoneChaveCompostaEmbedded;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.IOException;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 06/06/2022, 19:55:37
 */
public class Principal {

    public static void main(String[] args) throws IOException {
        EntityManager manager = Persistence
                .createEntityManagerFactory("ExemploPostgres")
                .createEntityManager();
        Editora editora = new Editora(
                "Sousa", "Guru do Dino"
        );
        Editora jobs = new Editora(
                "Cz", "Guru do Job"
        );
        Livro livro = new Livro("como passar em DAC? :)");
        livro.setResumo("Mesmo um código ruim pode funcionar. Mas se ele não for limpo, pode acabar com uma empresa de desenvolvimento. Perdem-se a cada ano horas incontáveis e recursos importantes devido a um código mal escrito. Mas não precisa ser assim.O renomado especialista em software, Robert C. Martin, apresenta um paradigma revolucionário com Código limpo: Habilidades Práticas do Agile Software. Martin se reuniu com seus colegas do Mentor Object para destilar suas melhores e mais ágeis práticas de limpar códigos “dinamicamente” em um livro que introduzirá gradualmente dentro de você os valores da habilidade de um profissional de softwares e lhe tornar um programador melhor –mas só se você praticar.Que tipo de trabalho você fará? Você lerá códigos aqui, muitos códigos. E você deverá descobrir o que está correto e errado nos códigos. E, o mais importante, você terá de reavaliar seus valores profissionais e seu comprometimento com o seu ofício");
        livro.carregarImagem("src/main/resources/imagens/code-limpo.jpg");
//        Livro livro2 = new Livro("como passar em DAC? :)");
        livro.setIsbn(ISBN.of("1231231231"));
        jobs.adicionarContato("job@gmail.com");
        jobs.adicionarContato("83-35324192");

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.finalizar();

        Telefone telefone1 = new Telefone("55", "83", "35324192");
        Telefone telefone2 = new Telefone("55", "83", "35324160");
        Telefone telefone3 = new Telefone("55", "85", "35324192");

//        emprestimo.
        manager.getTransaction().begin();
        manager.persist(editora);
        manager.persist(jobs);
        manager.persist(livro);
        manager.persist(emprestimo);
        manager.persist(telefone1);
        manager.persist(telefone2);
        manager.persist(telefone3);
        manager.getTransaction().commit();
//        Editora editora = manager.find(Editora.class, -1);
//        System.out.println("nome = " + editora.getNomeFantasia());
//        System.out.println("local = " + editora.getLocalDeOrigem());
//        manager.getTransaction().begin();
//        editora.setLocalDeOrigem("CZ");
//        manager.merge(editora);
//        manager.getTransaction().commit();

//        TypedQuery<Livro> editoras = manager.createQuery("SELECT e FROM Livro e", Livro.class);
//        editoras.getResultList()
//                .forEach(
//                        l -> System.out.println("nome = " + l.getTitulo())
//                );

        Telefone telefone = manager.find(Telefone.class,
                new TelefoneChaveCompostaEmbedded("83", "35324192")
        );
        System.out.println("telefone = " + telefone.formatado());
    }
}
