package com.example.profalexandre.fatecmobile.modelos;

import java.io.Serializable;

/**
 *
 * @author ProfAlexandre
 */
public class InquilinoBean implements Serializable {

    String id;
    String nome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "InquilinoBean{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
