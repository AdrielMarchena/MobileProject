package com.example.profalexandre.fatecmobile.modelos;

import java.io.Serializable;

/**
 *
 * @author ProfAlexandre
 */
public class ImovelBean implements Serializable {

    String id;
    String endereco;
    String proprietario;
    double valorAluguel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    @Override
    public String toString() {
        return "ImovelBean{" +
                "id='" + id + '\'' +
                ", endereco='" + endereco + '\'' +
                ", proprietario='" + proprietario + '\'' +
                ", valorAluguel=" + valorAluguel +
                '}';
    }
}
