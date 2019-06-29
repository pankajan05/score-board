/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score;

import Cricket_score.Database.DataFetcher;
import Cricket_score.Database.FactoryClass;
import Cricket_score.database_connector.Connector;
import Cricket_score.database_connector.Sqlconnector;
import Cricket_score.input.Input;
import Cricket_score.input.MatchId;
import Cricket_score.input.Selection;
import Cricket_score.uiDesign.Gui;
import Cricket_score.uiDesign.mainframe;

/**
 *
 * @author Pankajan
 */
public class CricketScoreBoard {
    public void show(){
        Gui gui = new mainframe();
        Input input = new Selection(gui);
        
        Connector connector = new Sqlconnector();
        FactoryClass factory = new FactoryClass(connector);
        DataFetcher data = factory.getObject(input.getInput());
        String[][] str = data.getDetails();
    }
    
}
