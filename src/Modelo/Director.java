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
public class Director {
    private String Nombre;
    private String Rut;
    private String Nacionalidad;
    
    public Director () {
       this.Nombre=("");
       this.Rut=("");
       this.Nacionalidad=("");
       
}
    public Director(String n, String r, String m){
       this.Nombre=n;
       this.Rut=r;
       this.Nacionalidad=m;
      
    }
    public String getNombre()
    {
        return(this.Nombre);
    }
    public void setNombre(String n)
    {
        this.Nombre=n;
    }
    public String getRut(){
        return(this.Rut);
    }
    public void setRut(String r){
        this.Rut=r;
    }
    public String getNacionalidad(){
        return(this.Nacionalidad);
    }
    public void setNacionalidad(String m){
        this.Nacionalidad=m;
    }

    @Override
    public String toString() {
        return "Director{" + "Nombre=" + Nombre + ", Rut=" + Rut + ", Nacionalidad=" + Nacionalidad + '}';
    }

    private Director buscarPorNombre(String nombre){
        if (this.Nombre.equalsIgnoreCase(nombre)){
            return this;
        }else{
            return null;
        }

    }
}
