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
public class VentaTelefonica extends Venta {

    public VentaTelefonica( Modelo.Cliente Cliente, Modelo.Proyeccion Proyeccion, ArrayList<Asiento> ListaAsientos, int Monto) {
        super("Telefonica", Cliente, Proyeccion, ListaAsientos, (int)(Monto*0.97));
    }
   

 
}
