package br.edu.ifpb.domain.chaves;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class TelefoneChaveCompostaEmbedded {
    private String ddd; // 083
    private String numero; // 35324100

    public TelefoneChaveCompostaEmbedded() {}
    public TelefoneChaveCompostaEmbedded(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.ddd);
        hash = 73 * hash + Objects.hashCode(this.numero);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TelefoneChaveCompostaEmbedded other = (TelefoneChaveCompostaEmbedded) obj;
        if (!Objects.equals(this.ddd, other.ddd)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }
}
