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
public class Overview implements DataFetcher{
    private final Connector connector;
    
    public Overview(Connector connector) {
        this.connector = connector;
    }

    Overview() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String[][] getDetails(String matchid){
        
            this.connector.connect();
            List<String[]> list = new ArrayList();
            
            
  
            ResultSet rs=this.connector.fetch("select * from matches where matchId = '"+matchid+"'");
        try {
            while(rs.next()){
                
                    String array[] = {rs.getString("inningOne"),rs.getString("inningTwo"),rs.getString("location"),rs.getString("winningTeam")};
                    list.add(array);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.connector.close();
            
            
            String[][] output = new String[list.size()][4];
            for(int i=0;i<list.size();i++){
                output[i] =list.get(i);
            }
            
            return output;
       
    }
}
