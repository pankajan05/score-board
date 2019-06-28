/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score.database_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pankajan
 */
public class Sqlconnector implements Connector{

    @Override
    public Statement connect() {
        
        Connection con;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("about to connect");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","");
            statement = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Sqlconnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statement;
    }
    
}
