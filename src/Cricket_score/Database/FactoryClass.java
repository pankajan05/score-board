/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score.Database;

import Cricket_score.database_connector.Connector;
import javax.swing.table.TableColumn;

/**
 *
 * @author Pankajan
 */
public class FactoryClass {
     DataFetcher datafetcher;
     Connector connector;
     
     public FactoryClass(Connector connector){
         this.connector = connector;
     }
     
     public DataFetcher getObject(String category){
       switch (category) {
             case "Overview":
                 datafetcher = new Overview(connector);
                 break;
             case "First Inning":
                 datafetcher = new FirstInnings(connector);
                 break;
             case "Second Inning":
                 datafetcher = new SecondInnings(connector);
                 break;
             default:
                 break;
         }
        return datafetcher;
    }
}
