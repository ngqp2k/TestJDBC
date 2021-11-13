
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Quang Phu
 */
public class Main {
    public static void main(String[] abc) throws ClassNotFoundException, SQLException {
        System.out.println("Hello world");
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sales", "root", "1111");
        
        Statement sta = conn.createStatement();
//        sta.executeUpdate("INSERT INTO category (name, description) VALUES ('Keyboard', 'Bàn phím');");
//        sta.executeUpdate("INSERT INTO category (name, description) VALUES ('Mouse', 'Chuột'); ");
//        sta.executeUpdate("DELETE FROM `sales`.`category` WHERE (`id` = '7');");
//        sta.executeUpdate("DELETE FROM `sales`.`category` WHERE (`id` = '9');");
//        sta.executeUpdate("DELETE FROM `sales`.`category` WHERE (`id` = '10');");
//        sta.executeUpdate("DELETE FROM `sales`.`category` WHERE (`id` = '11');");

        ResultSet res = sta.executeQuery("SELECT * FROM category");
        while (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            String description = res.getString("description");
            System.out.printf("%d -- %s -- %s\n", id, name, description);
        }
        
        sta.close();
        conn.close();
    }
}
