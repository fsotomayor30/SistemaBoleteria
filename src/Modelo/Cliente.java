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
public class Cliente {
    private String Nombre;
    private String Rut;
    private String Mail;
    private int Telefono;
    
    public Cliente () {
       this.Nombre=("");
       this.Rut=("");
       this.Mail=("");
       this.Telefono=0;
}
    public Cliente(String n, String r, String m,int t){
       this.Nombre=n;
       this.Rut=r;
       this.Mail=m;
       this.Telefono=t;
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
    public String getMail(){
        return(this.Mail);
    }
    public void setMail(String m){
        this.Mail=m;
    }
    public int getTelefono(){
        return(this.Telefono);
    }
    public void setTelefono (int t){
        this.Telefono=t;
    }

    @Override
    public String toString() {
        return "{" + "Nombre=" + Nombre + ", Rut=" + Rut + ", Mail=" + Mail + ", Telefono=" + Telefono + '}';
    }
    
    
}
