package BaseDeDatos;


import java.sql.*;

public class DataBase {


    public DataBase(){

    }



    public void connectDataBase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mydb","root", "petclinic");
            Statement stat=connect.createStatement();
            ResultSet rs=stat.executeQuery("select  Pk_Cliente from Cliente");
            while(rs.next()){
                System.out.print(rs.getInt(1));

            }
            stat.close();
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
