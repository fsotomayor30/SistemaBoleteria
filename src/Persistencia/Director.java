package Persistencia;

import java.sql.*;
import java.util.ArrayList;

public class Director {
    public Director() {
    }
    public boolean addDirector(Modelo.Director director){

        try {
            // the mysql insert statement
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");

            String query = " insert into Director (Nombre, Rut, Nacionalidad)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString (1, director.getNombre());
            preparedStmt.setString (2, director.getRut());
            preparedStmt.setString(3, director.getNacionalidad());



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
    public Modelo.Director buscarDirectorPorNombre(String nombre){
        Modelo.Director director=new Modelo.Director();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();
            PreparedStatement stmt =connect.prepareStatement("SELECT * from Director WHERE Nombre = ?");
            stmt.setString(1,nombre);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                director=new Modelo.Director(rs.getString("Nombre"), rs.getString("Rut"), rs.getString("Nacionalidad"));
            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return director;
    }

    public ArrayList<Modelo.Director> listarDirectores(){
        ArrayList<Modelo.Director> listaDirectores=new ArrayList<Modelo.Director>();
        Modelo.Director director;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();
            PreparedStatement stmt =connect.prepareStatement("SELECT * from Director");

            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                director=new Modelo.Director(rs.getString("Nombre"), rs.getString("Rut"), rs.getString("Nacionalidad"));
                listaDirectores.add(director);
            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDirectores;
    }

    public Modelo.Director buscarDirector(String Rut){

        Modelo.Director director=new Modelo.Director();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();

            PreparedStatement stmt1 =connect.prepareStatement("SELECT * from Director WHERE Rut= ?");
            stmt1.setString(1,Rut);

            ResultSet rs1=stmt1.executeQuery();


            while(rs1.next()){
                director.setNombre(rs1.getString("Nombre"));
                director.setRut(rs1.getString("Rut"));
                director.setNacionalidad(rs1.getString("Nacionalidad"));

            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return director;
    }

}
