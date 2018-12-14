/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author socra
 */
public class Proyeccion {
    private int idProyeccion;
    private Pelicula Pelicula;
    private int Horario;
    private Date Fecha;
    private Sala Sala;
    private String Localidad;
    private int Precio;

    public Proyeccion() {
    }

    public Proyeccion(int idProyeccion, Modelo.Pelicula pelicula, int horario, Date fecha, Modelo.Sala sala, String localidad, int precio) {
        this.idProyeccion = idProyeccion;
        Pelicula = pelicula;
        Horario = horario;
        Fecha = fecha;
        Sala = sala;
        Localidad = localidad;
        Precio = precio;
    }

    public int getIdProyeccion() {
        return idProyeccion;
    }

    public void setIdProyeccion(int idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    public Modelo.Pelicula getPelicula() {
        return Pelicula;
    }

    public void setPelicula(Modelo.Pelicula pelicula) {
        Pelicula = pelicula;
    }

    public int getHorario() {
        return Horario;
    }

    public void setHorario(int horario) {
        Horario = horario;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public Modelo.Sala getSala() {
        return Sala;
    }

    public void setSala(Modelo.Sala sala) {
        Sala = sala;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    @Override
    public String toString() {
        return "Proyeccion{" +
                "idProyeccion=" + idProyeccion +
                ", Pelicula=" + Pelicula +
                ", Horario=" + Horario +
                ", Fecha=" + Fecha +
                ", Sala=" + Sala +
                ", Localidad='" + Localidad + '\'' +
                ", Precio=" + Precio +
                '}';
    }
}
