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
public class VentaInternet extends Venta {
    
    public VentaInternet(Cliente Cliente, Proyeccion Proyeccion, ArrayList<Asiento> ListaAsientos, int Monto) {
        
        super("Internet", Cliente, Proyeccion, ListaAsientos, (int)(Monto*0.95));
    }

    public VentaInternet() {
        super();
    }
    
    

    
    
    
}
