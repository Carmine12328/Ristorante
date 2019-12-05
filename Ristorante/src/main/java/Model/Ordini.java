/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Ordini implements Serializable {

    private String nome;
    private float prezzo;
    private int quantità = 1;

    public String getNome() {
        return nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public int getQuantità() {
        return quantità;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }

    public Ordini(String nome, float prezzo, int quantità) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantità = quantità;
    }

}
