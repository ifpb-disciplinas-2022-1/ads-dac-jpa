package br.edu.ifpb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Editora {
    @Id
    private int codigo; //identidade
    private String localDeOrigem;
    private String nomeFantasia;
    public Editora(){}
    public Editora(String localDeOrigem,String nomeFantasia) {
        this(0, localDeOrigem, nomeFantasia);
    }
    public Editora(int codigo,String localDeOrigem,String nomeFantasia) {
        this.codigo = codigo;
        this.localDeOrigem = localDeOrigem;
        this.nomeFantasia = nomeFantasia;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getLocalDeOrigem() {
        return localDeOrigem;
    }
    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}

