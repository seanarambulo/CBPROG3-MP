
package demoapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoApplication {

    
    public static void main(String[] args) {
       DemoApplication sample = new DemoApplication();
        sample.createConnection();
        
    }
    void createConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "12345678");
            System.out.println("Connection sucess!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
                    e.printStackTrace();
        }
    }
}
