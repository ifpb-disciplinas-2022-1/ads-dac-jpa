package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Editora;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class Editoras {
    @PersistenceContext(unitName = "ExemploPostgres")
    private EntityManager manager;
    public void criar(Editora editora){
        manager.persist(editora);
    }
    public void remover(Editora editora){
        manager.remove(
            manager.merge(editora) //tonar o objeto gerenciado
        );
    }
    public List<Editora> todas(){
        return manager.createQuery(
                "SELECT e FROM Editora e", Editora.class
        ).getResultList();
    }
}
