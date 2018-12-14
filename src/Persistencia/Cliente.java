package Persistencia;

import BaseDeDatos.DataBase;
import Modelo.Director;
import Servicio.BoleteriaSistema;

import java.sql.*;
import java.util.ArrayList;

public class Cliente {


    public Cliente() {

    }

    public boolean addCliente(Modelo.Cliente cliente){

        try {
            // the mysql insert statement
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");

        String query = " insert into Cliente (Nombre, Rut, Mail, Telefono)"
                + " values (?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString (1, cliente.getNombre());
        preparedStmt.setString (2, cliente.getRut());
        preparedStmt.setString   (3, cliente.getMail());
        preparedStmt.setInt(4, cliente.getTelefono());


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

    public Modelo.Cliente buscarCliente(String Rut){

        Modelo.Cliente cliente =new Modelo.Cliente();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();

            PreparedStatement stmt1 =connect.prepareStatement("SELECT * from Cliente WHERE Rut= ?");
            stmt1.setString(1,Rut);

            ResultSet rs1=stmt1.executeQuery();


            while(rs1.next()){

                cliente=new Modelo.Cliente(rs1.getString("Nombre"), rs1.getString("Rut"), rs1.getString("Mail"), rs1.getInt("Telefono"));


            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public ArrayList<Modelo.Cliente> listarClientes(){
        ArrayList<Modelo.Cliente> listaClientes=new ArrayList<Modelo.Cliente>();
        Modelo.Cliente cliente;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();
            PreparedStatement stmt =connect.prepareStatement("SELECT * from Cliente");

            ResultSet rs1=stmt.executeQuery();
            while(rs1.next()){
                cliente=new Modelo.Cliente(rs1.getString("Nombre"), rs1.getString("Rut"), rs1.getString("Mail"), rs1.getInt("Telefono"));

                listaClientes.add(cliente);
            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }




}
