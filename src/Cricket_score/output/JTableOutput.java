/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score.output;

import Cricket_score.uiDesign.Gui;

/**
 *
 * @author Pankajan
 */
public class JTableOutput implements Output{
    Gui gui;
    
    public JTableOutput(Gui gui){
        this.gui = gui;
    }
    @Override
    public void Output(String str[][] ){
        gui.getTable().setModel(new javax.swing.table.DefaultTableModel(
               str,
                new String [] {
                    "Title 13", "Title 23", "Title 33", "Title 43"
                }
            ));
    }
}
