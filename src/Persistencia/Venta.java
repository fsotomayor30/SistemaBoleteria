package Persistencia;

import Modelo.Asiento;

import java.sql.*;
import java.util.ArrayList;

public class Venta {

    private Persistencia.Cliente clientePersistencia;
    private Persistencia.Proyeccion proyeccionPersistencia;
    public Venta() {
        this.clientePersistencia = new Cliente();
        this.proyeccionPersistencia=new Proyeccion();
    }

    public boolean addVenta(Modelo.Venta venta){

        try {
            // the mysql insert statement
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");

            String query = " insert into Venta (TipoVenta,rut_Cliente, id_Proyeccion, Monto, cantidad_Asientos)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString (1, venta.getTipoVenta());
            preparedStmt.setString (2, venta.getCliente().getRut());
            preparedStmt.setInt(3, venta.getProyeccion().getIdProyeccion());
            preparedStmt.setInt(3, venta.getMonto());
            preparedStmt.setInt(3, venta.getListaAsientos().size());



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

    public ArrayList<Modelo.Venta> listarVentas(){
        ArrayList<Modelo.Venta> listaVentas=new ArrayList<Modelo.Venta>();
        Modelo.Venta venta;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            //Statement stat=connect.createStatement();
            PreparedStatement stmt =connect.prepareStatement("SELECT * from Venta");

            ResultSet rs1=stmt.executeQuery();
            while(rs1.next()){
                venta=new Modelo.Venta(rs1.getInt("id_Venta"), rs1.getString("TipoVenta"),clientePersistencia.buscarCliente(rs1.getString("rut_Cliente")),proyeccionPersistencia.buscarProyeccion(rs1.getInt("id_Proyeccion")),new ArrayList<Asiento>(rs1.getInt("cantidad_Asientos")),rs1.getInt("Monto")  );

                listaVentas.add(venta);
            }

            //stat.close();
            connect.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaVentas;
    }
}
