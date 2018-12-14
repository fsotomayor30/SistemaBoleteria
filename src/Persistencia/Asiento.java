package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Asiento {
    public Asiento() {
    }

    public boolean addAsiento(Modelo.Asiento asiento){

        try {
            // the mysql insert statement
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");

            String query = " insert into Asiento (Fila, Numero, Disponibilidad)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setInt (1, asiento.getFila());
            preparedStmt.setInt (2, asiento.getNumero());
            preparedStmt.setBoolean(3, asiento.isDisponibilidad());



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

}
