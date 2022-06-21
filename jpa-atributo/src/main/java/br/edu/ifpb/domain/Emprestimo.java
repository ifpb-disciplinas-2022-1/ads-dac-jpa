package br.edu.ifpb.domain;

import br.edu.ifpb.infra.jpa.convert.ConverterLocalDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Emprestimo {
    @Id
    private String codigo;
//    private List<Livro> livros;
    @Convert(converter = ConverterLocalDate.class)
    private LocalDate criadoEm;
    @Enumerated(EnumType.STRING)
    private Status status;//    @Enumerated
    // atualizar
    @Temporal(TemporalType.DATE)
    private Date finalizadoEm;
    private String cpf;

    public Emprestimo() {
        this(UUID.randomUUID().toString());
//        this.livros = new ArrayList<>();
    }
    private Emprestimo(String codigo){
        this.codigo = codigo;
        this.criadoEm = LocalDate.now();
        this.status = Status.CRIADO;
    }
    public static Emprestimo vazio() {
        return new Emprestimo("vazio");
    }

    public void incluirCliente(String cpf){
        this.cpf = cpf;
    }
//    public void adicionarLivro(Livro livro){
//        this.livros.add(livro);
//    }
    public void cancelar(){
        this.status = Status.CANCELADO;
    }
    public void finalizar(){
        this.status = Status.FINALIZADO;
        this.finalizadoEm = new Date();
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public LocalDate getCriadoEm() {
        return criadoEm;
    }
    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Date getFinalizadoEm() {
        return finalizadoEm;
    }
    public void setFinalizadoEm(Date finalizadoEm) {
        this.finalizadoEm = finalizadoEm;
    }
    public String getCpf() {
        return cpf;
    }
    public void setKey(String cpf) {
        this.cpf = cpf;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equals(codigo, that.codigo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
