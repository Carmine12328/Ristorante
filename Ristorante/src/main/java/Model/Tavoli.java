/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Carmine Annunziata
 */
public class Tavoli implements Serializable{

    private int Npersone;
    private String SitAttuale;
    private String nome;
    private float PrezzoTotale;
    
    public int getNpersone() {
        return Npersone;
    }

    public String getSitAttuale() {
        return SitAttuale;
    }

    public void setNpersone(int Npersone) {
        this.Npersone = Npersone;
    }

    public void setSitAttuale(String SitAttuale) {
        this.SitAttuale = SitAttuale;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public float getPrezzoTotale() {
        return PrezzoTotale;
    }

    public void setPrezzoTotale(float PrezzoTotale) {
        this.PrezzoTotale = PrezzoTotale;
    }

    public Tavoli(int Npersone, String SitAttuale, String nome, Float PrezzoTotale) {
        this.Npersone = Npersone;
        this.SitAttuale = SitAttuale;
        this.nome = nome;
        this.PrezzoTotale = PrezzoTotale;
    }

}
