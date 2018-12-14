/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author socra
 */
public class Asiento {
    private int Fila;
    private int Numero;
    private boolean Disponibilidad;

    public Asiento(int Fila, int Numero, boolean Disponibilidad) {
        this.Fila = Fila;
        this.Numero = Numero;
        this.Disponibilidad = Disponibilidad;
    }

    public int getFila() {
        return Fila;
    }

    public void setFila(int Fila) {
        this.Fila = Fila;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public boolean isDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(boolean Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    @Override
    public String toString() {
        return "Asiento{" + "Fila=" + Fila + ", Numero=" + Numero + ", Disponibilidad=" + Disponibilidad + '}';
    }
    
    
    
}
