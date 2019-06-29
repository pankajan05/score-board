/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score.Database;

import Cricket_score.database_connector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author udith
 */
public class FirstInnings implements DataFetcher{
    private final Connector connector;
    
    public FirstInnings(Connector connector){
        this.connector = connector;
    }
    @Override
    public String[][] getDetails(){
        
            List<String[]> list = new ArrayList();
            
            this.connector.connect();
            
            ResultSet rs=this.connector.fetch("select * from batting where matchId = '1'");  
        try {
            while(rs.next()){
                
                    String array[] = {rs.getString("fours"),rs.getString("sixes"),rs.getString("wicketStatus"),rs.getString("average")};
                    list.add(array);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(FirstInnings.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.connector.close();  
            
            
            String[][] output = new String[list.size()][4];
            for(int i=0;i<list.size();i++){
                output[i] =list.get(i);
            }
            return output;
            
        
        
    }
}
