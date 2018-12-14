package Persistencia;

import Modelo.Asiento;

import java.sql.*;
import java.util.ArrayList;

public class Pelicula {
    private Persistencia.Director directorPersistencia=new Director();
    public Pelicula() {

    }

    public boolean addPelicula(Modelo.Pelicula pelicula){

        try {
            // the mysql insert statement
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");

            String query = " insert into Pelicula (DuracionHora, DuracionMinutos, Idioma, Rut_Director, Resumen)"
                    + " values (?, ?, ?, ?, ?)";

            System.out.println(pelicula.toString());
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setInt(1,pelicula.getDuracionHora());
            preparedStmt.setInt(2,pelicula.getDuracionMinutos());
            preparedStmt.setString (3, pelicula.getIdioma());
            preparedStmt.setString(4, pelicula.getDirector().getRut());
            preparedStmt.setString(5, pelicula.getResumen());



            // execute the preparedstatement
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    public Modelo.Pelicula buscarPelicula(int idPelicula){

        Modelo.Pelicula pelicula=new Modelo.Pelicula();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();

            PreparedStatement stmt1 =connect.prepareStatement("SELECT * from Pelicula WHERE idPelicula = ?");
            stmt1.setInt(1,idPelicula);

            ResultSet rs1=stmt1.executeQuery();


                    while(rs1.next()){

                        pelicula=new Modelo.Pelicula(rs1.getInt("idPelicula"), rs1.getInt("DuracionHora"),rs1.getInt("DuracionMinutos"), rs1.getString("Idioma"),directorPersistencia.buscarDirector(rs1.getString("Rut_Director")),rs1.getString("Resumen") );


            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pelicula;
    }

    public ArrayList<Modelo.Pelicula> listarPeliculas(){
        ArrayList<Modelo.Pelicula> listaPeliculas=new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();
            PreparedStatement stmt =connect.prepareStatement("SELECT * from Pelicula");
            ResultSet rs1=stmt.executeQuery();
            while(rs1.next()){
                Modelo.Pelicula pelicula=new Modelo.Pelicula();
                pelicula.setIdPelicula(rs1.getInt("idPelicula"));
                pelicula.setDuracionHora(rs1.getInt("DuracionHora"));
                pelicula.setDuracionMinutos(rs1.getInt("DuracionMinutos"));
                pelicula.setIdioma(rs1.getString("Idioma"));
                //System.out.println(directorPersistencia.buscarDirector(rs1.getString("Rut_Director")).toString());
                pelicula.setDirector(directorPersistencia.buscarDirector(rs1.getString("Rut_Director")));
                pelicula.setResumen(rs1.getString("Resumen"));
                System.out.println(pelicula.toString());
                listaPeliculas.add(pelicula);

            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPeliculas;
    }


}
