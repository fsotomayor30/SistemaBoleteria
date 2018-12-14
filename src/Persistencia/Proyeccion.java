package Persistencia;

import Modelo.Director;
import Modelo.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class Proyeccion {
    Persistencia.Sala salaPersistencia;
    Persistencia.Pelicula peliculaPersistencia;
    public Proyeccion() {
        salaPersistencia=new Sala();
        peliculaPersistencia=new Persistencia.Pelicula();
    }

    public boolean addProyeccion(Modelo.Proyeccion proyeccion){

        try {
            // the mysql insert statement
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");

            String query = " insert into Proyeccion (id_Pelicula,Horario, Fecha, nro_Sala, Localidad, precio)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setInt(1,proyeccion.getPelicula().getIdPelicula());
            preparedStmt.setInt(2,proyeccion.getHorario());
            preparedStmt.setDate (3, proyeccion.getFecha());
            preparedStmt.setInt(4, proyeccion.getSala().getNumeroSala());
            preparedStmt.setString(5, proyeccion.getLocalidad());
            preparedStmt.setInt(6, proyeccion.getPrecio());



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

    public ArrayList<Modelo.Proyeccion> listarProyecciones(){
        ArrayList<Modelo.Proyeccion> listaProyecciones=new ArrayList<Modelo.Proyeccion>();
        Modelo.Proyeccion proyeccion;
        Modelo.Pelicula pelicula;
        Modelo.Director director;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();
            PreparedStatement stmt =connect.prepareStatement("SELECT * from Proyeccion");
            PreparedStatement stmt1 =connect.prepareStatement("SELECT * from Pelicula WHERE idPelicula = ?");
            PreparedStatement stmt2 =connect.prepareStatement("SELECT * from Director WHERE Rut = ?");

            ResultSet rs=stmt.executeQuery();

            while(rs.next()){

                stmt1.setInt(1,rs.getInt("id_Pelicula"));
                ResultSet rs1=stmt1.executeQuery();
                while(rs1.next()){

                    stmt2.setString(1,rs1.getString("Rut_Director"));
                    ResultSet rs2=stmt2.executeQuery();
                    while(rs2.next()){
                        director=new Director(rs2.getString("Nombre"), rs2.getString("Rut"), rs2.getString("Nacionalidad"));
                        pelicula=new Pelicula(rs1.getInt("idPelicula"), rs1.getInt("DuracionHora"),rs1.getInt("DuracionMinutos"), rs1.getString("Idioma"),director,rs1.getString("Resumen") );
                        proyeccion=new Modelo.Proyeccion(rs.getInt("idProyeccion"), pelicula, rs.getInt("Horario"), rs.getDate("Fecha"),salaPersistencia.buscarSala(rs.getInt("nro_Sala")),rs.getString("Localidad"), rs.getInt("precio") );
                        listaProyecciones.add(proyeccion);

                    }
                }

            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProyecciones;
    }

    public Modelo.Proyeccion buscarProyeccion(int idProyeccion){

        Modelo.Proyeccion proyeccion=new Modelo.Proyeccion();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();

            PreparedStatement stmt1 =connect.prepareStatement("SELECT * from Proyeccion WHERE idProyeccion= ?");
            stmt1.setInt(1,idProyeccion);

            ResultSet rs1=stmt1.executeQuery();


            while(rs1.next()){

                proyeccion=new Modelo.Proyeccion(rs1.getInt("idProyeccion"),peliculaPersistencia.buscarPelicula(rs1.getInt("id_Pelicula")), rs1.getInt("Horario"), rs1.getDate("Fecha"), salaPersistencia.buscarSala(rs1.getInt("nro_Sala")),rs1.getString("Localidad"), rs1.getInt("Precio"));


            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proyeccion;
    }
}
