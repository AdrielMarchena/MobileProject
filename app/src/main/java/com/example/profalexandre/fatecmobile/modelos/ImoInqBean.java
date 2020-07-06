package com.example.profalexandre.fatecmobile.modelos;

import java.io.Serializable;

/**
 *
 * @author ProfAlexandre
 */
public class ImoInqBean implements Serializable {

    String id;
    String idImovel;
    String idInquilino;
    String obs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(String idImovel) {
        this.idImovel = idImovel;
    }

    public String getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(String idInquilino) {
        this.idInquilino = idInquilino;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "ImoInqBean{" +
                "id='" + id + '\'' +
                ", idImovel='" + idImovel + '\'' +
                ", idInquilino='" + idInquilino + '\'' +
                ", obs='" + obs + '\'' +
                '}';
    }
}
