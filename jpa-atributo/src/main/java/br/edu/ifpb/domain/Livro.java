package br.edu.ifpb.domain;

import br.edu.ifpb.io.ImageFromFile;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Entity//(name = "livrodedac")
@Table(name = "livrodedac")
@TableGenerator(name = "minha_tabela",
    initialValue = 1,
    allocationSize = 25,
    table = "tabela_geradora",
    pkColumnName = "key",
    pkColumnValue = "livros",
    valueColumnName = "value")
public class Livro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "minha_tabela")
    private int id;
    @Column(name = "descricao", length = 80, unique = true)
    private String titulo;
    @Lob
    @Basic(fetch = FetchType.LAZY) //Defines that data can be lazily fetched
    private String resumo; // C-LOB
    @Lob
    @Basic(fetch = FetchType.LAZY) //Defines that data can be lazily fetched
    private byte[] capa;
    @Transient
    private ImageFromFile image;
    @Embedded
    @AttributeOverride(name = "numero", column = @Column(name = "isbn2"))
    private ISBN isbn; //@Embedded

    public Livro() {
    }
    public Livro(String titulo) {
        this.titulo = titulo;
    }
    public void carregarImagem(String path) {
        image = new ImageFromFile(path);
        setCapa(image.toBytes());
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getResumo() {
        return resumo;
    }
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    public byte[] getCapa() {
        return capa;
    }
    public void setCapa(byte[] capa) {
        this.capa = capa;
    }
    public ISBN getIsbn() {
        return isbn;
    }
    public void setIsbn(ISBN isbn) {
        this.isbn = isbn;
    }
}








