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
public class Pelicula {
    private int idPelicula;
    private int DuracionHora;
    private int DuracionMinutos;
    private String Idioma;
    private Director Director;
    private String Resumen;


    public Pelicula(int idPelicula, int duracionHora, int duracionMinutos, String idioma, Modelo.Director director, String resumen) {
        this.idPelicula = idPelicula;
        DuracionHora = duracionHora;
        DuracionMinutos = duracionMinutos;
        Idioma = idioma;
        Director = director;
        Resumen = resumen;
    }

    public Pelicula() {
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getDuracionHora() {
        return DuracionHora;
    }

    public void setDuracionHora(int duracionHora) {
        DuracionHora = duracionHora;
    }

    public int getDuracionMinutos() {
        return DuracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        DuracionMinutos = duracionMinutos;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String idioma) {
        Idioma = idioma;
    }

    public Modelo.Director getDirector() {
        return Director;
    }

    public void setDirector(Modelo.Director director) {
        Director = director;
    }

    public String getResumen() {
        return Resumen;
    }

    public void setResumen(String resumen) {
        Resumen = resumen;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", DuracionHora=" + DuracionHora +
                ", DuracionMinutos=" + DuracionMinutos +
                ", Idioma='" + Idioma + '\'' +
                ", Director=" + Director +
                ", Resumen='" + Resumen + '\'' +
                '}';
    }
}

