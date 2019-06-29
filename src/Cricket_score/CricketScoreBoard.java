/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score;

import Cricket_score.Database.DataFetcher;
import Cricket_score.Database.FactoryClass;
import Cricket_score.Notifier.Notifier;
import Cricket_score.database_connector.Connector;
import Cricket_score.database_connector.Sqlconnector;
import Cricket_score.input.Input;
import Cricket_score.input.MatchId;
import Cricket_score.input.Selection;
import Cricket_score.output.JTableOutput;
import Cricket_score.output.Output;
import Cricket_score.uiDesign.Gui;
import Cricket_score.uiDesign.mainframe;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Pankajan
 */
public class CricketScoreBoard implements Observer{
    Gui gui;
    
    public CricketScoreBoard(){
        Notifier notifier = new Notifier();
        notifier.addObserver(this);
        this.gui = new mainframe(notifier);
    }
    public void show(){
        
        Input input = new Selection(gui);
        
        Connector connector = new Sqlconnector();
        FactoryClass factory = new FactoryClass(connector);
        DataFetcher data = factory.getObject(input.getInput());
        input = new MatchId(gui);
        String[][] str = data.getDetails(input.getInput());
        
        Output output = new JTableOutput(gui);
        output.Output(str);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.show();
    }
 
    
}
