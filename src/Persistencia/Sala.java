package Persistencia;

import Modelo.Asiento;

import java.sql.*;
import java.util.ArrayList;

public class Sala {
    public Sala() {
    }

    public boolean addSala(Modelo.Sala sala){

        try {
            // the mysql insert statement
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");

            String query = " insert into Sala (TipoSala, cantidad_asientos)"
                    + " values (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString (1, sala.getTipoSala());
            preparedStmt.setInt (2, sala.getListaAsientos().size());




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

    public Modelo.Sala buscarSala(int nroSala){

        Modelo.Sala sala=new Modelo.Sala();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();

            PreparedStatement stmt1 =connect.prepareStatement("SELECT * from Sala WHERE NumeroSala = ?");
            stmt1.setInt(1,nroSala);

            ResultSet rs1=stmt1.executeQuery();


            while(rs1.next()){

                sala=new Modelo.Sala(rs1.getInt("NumeroSala"), rs1.getString("TipoSala"), new ArrayList<Asiento>(rs1.getInt("cantidad_asientos")));

            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sala;
    }

    public ArrayList<Modelo.Sala> listarSalas(){
        ArrayList<Modelo.Sala> listaSalas=new ArrayList<Modelo.Sala>();
        Modelo.Sala sala;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();
            PreparedStatement stmt =connect.prepareStatement("SELECT * from Sala");

            ResultSet rs1=stmt.executeQuery();
            while(rs1.next()){
                sala=new Modelo.Sala(rs1.getInt("NumeroSala"), rs1.getString("TipoSala"), new ArrayList<Asiento>(rs1.getInt("cantidad_asientos")));

                listaSalas.add(sala);
            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaSalas;
    }
}
