/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author udith
 */
public class SecondInnings implements DataFetcher{
    @Override
    public String[][] getDetails(){
        List<String[]> list = new ArrayList();
         
            try{  
            Class.forName("com.mysql.jdbc.Driver"); 
               System.out.println("about to connect");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","");  
            //here sonoo is database name, root is username and password  
            Statement stmt= con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from bowling where matchId = '1'");  
            while(rs.next()){
               String array[] = {rs.getString("wicket"),rs.getString("runs"),rs.getString("overs"),rs.getString("average")}; 
               list.add(array);
            }
            con.close();  
            }catch(ClassNotFoundException | SQLException e){ 
                System.out.println(e);
            } 
            
            String[][] output = new String[list.size()][4];
            for(int i=0;i<list.size();i++){
                output[i] =list.get(i);
            }
            
            return output;
    }
}
