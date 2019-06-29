/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score.Notifier;

import java.util.Observable;

/**
 *
 * @author Pankajan
 */
public class Notifier extends Observable{
    public void nottify(){
        setChanged();
        notifyObservers();
    }
    
}
