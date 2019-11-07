package com.ifce.main;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Paulo Cesar
 */
public class ObserverPrint implements Observer{
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Houve Alteração");
    }
    
}
