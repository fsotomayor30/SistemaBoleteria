/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author socra
 */
public class Sala {
    private int NumeroSala;
    private String TipoSala;
    private ArrayList<Asiento> ListaAsientos;

    public Sala(int NumeroSala, String TipoSala, ArrayList<Asiento> ListaAsientos) {
        this.NumeroSala = NumeroSala;
        this.TipoSala = TipoSala;
        this.ListaAsientos = ListaAsientos;
    }

    public Sala() {
    }

    public int getNumeroSala() {
        return NumeroSala;
    }

    public void setNumeroSala(int NumeroSala) {
        this.NumeroSala = NumeroSala;
    }

    public String getTipoSala() {
        return TipoSala;
    }

    public void setTipoSala(String TipoSala) {
        this.TipoSala = TipoSala;
    }

    public ArrayList<Asiento> getListaAsientos() {
        return ListaAsientos;
    }

    public void setListaAsientos(ArrayList<Asiento> ListaAsientos) {
        this.ListaAsientos = ListaAsientos;
    }

    @Override
    public String toString() {
        return "Sala{" + "NumeroSala=" + NumeroSala + ", TipoSala=" + TipoSala + ", ListaAsientos=" + ListaAsientos + '}';
    }
    
    
}
