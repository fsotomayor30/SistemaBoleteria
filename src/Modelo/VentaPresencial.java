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
public class VentaPresencial extends Venta {

    public VentaPresencial(Modelo.Cliente Cliente, Modelo.Proyeccion Proyeccion, ArrayList<Asiento> ListaAsientos, int Monto) {
        super("Presencial", Cliente, Proyeccion, ListaAsientos, (int)(Monto*0.99));
    }
   
}
