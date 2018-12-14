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
public class Venta {
    private int id_Venta;
    private String TipoVenta;
    private Cliente Cliente;
    private Proyeccion Proyeccion;
    private ArrayList<Asiento> ListaAsientos;
    private int Monto;

    public Venta(String TipoVenta, Cliente Cliente, Proyeccion Proyeccion, ArrayList<Asiento> ListaAsientos, int Monto) {
        this.TipoVenta = TipoVenta;
        this.Cliente = Cliente;
        this.Proyeccion = Proyeccion;
        this.ListaAsientos = ListaAsientos;
        this.Monto = Monto;
    }

    public Venta(int id_Venta, String tipoVenta, Modelo.Cliente cliente, Modelo.Proyeccion proyeccion, ArrayList<Asiento> listaAsientos, int monto) {
        this.id_Venta = id_Venta;
        TipoVenta = tipoVenta;
        Cliente = cliente;
        Proyeccion = proyeccion;
        ListaAsientos = listaAsientos;
        Monto = monto;
    }

    public Venta() {
    }

    
    public String getTipoVenta() {
        return TipoVenta;
    }

    public void setTipoVenta(String TipoVenta) {
        this.TipoVenta = TipoVenta;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Proyeccion getProyeccion() {
        return Proyeccion;
    }

    public void setProyeccion(Proyeccion Proyeccion) {
        this.Proyeccion = Proyeccion;
    }

    public ArrayList<Asiento> getListaAsientos() {
        return ListaAsientos;
    }

    public void setListaAsientos(ArrayList<Asiento> ListaAsientos) {
        this.ListaAsientos = ListaAsientos;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }


    public int getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(int id_Venta) {
        this.id_Venta = id_Venta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id_Venta=" + id_Venta +
                ", TipoVenta='" + TipoVenta + '\'' +
                ", Cliente=" + Cliente +
                ", Proyeccion=" + Proyeccion +
                ", ListaAsientos=" + ListaAsientos +
                ", Monto=" + Monto +
                '}';
    }
}
