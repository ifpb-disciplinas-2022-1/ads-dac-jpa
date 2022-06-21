package br.edu.ifpb.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(initialValue = 1,
        allocationSize = 23,
        name = "editora_seq",
        sequenceName = "editora_seq")
//@TableGenerator(name = "minha_tabela2",
//        initialValue = 1,
//        allocationSize = 25,
//        table = "tabela_geradora",
//        pkColumnName = "key",
//        pkColumnValue = "editoras",
//        valueColumnName = "value")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editora_seq")
    private int codigo; //identidade
    private String localDeOrigem;
    private String nomeFantasia;
    @ElementCollection
    @CollectionTable(name = "contatos")
    private List<String> contatos = new ArrayList<>();
    public Editora(){}
    public Editora(String localDeOrigem,String nomeFantasia) {
//        this(0, localDeOrigem, nomeFantasia);
        this.localDeOrigem = localDeOrigem;
        this.nomeFantasia = nomeFantasia;
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
    public void a(String c){
        this.contatos.add(c);
    }
}

