package br.edu.ifpb.web;

import br.edu.ifpb.domain.Editora;
import br.edu.ifpb.infra.Editoras;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ControladorDeEditoras {
    @Inject
    private Editoras editoras;
    private Editora editora = new Editora();
    public String salvar(){
        editoras.criar(editora);
        editora = new Editora();
        return null;
    }
    public String remover(Editora editora){
        editoras.remover(editora);
        return null;
    }
    public List<Editora> todasAsEditoras(){
        return this.editoras.todas();
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}
