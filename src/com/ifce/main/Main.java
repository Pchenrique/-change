package com.ifce.main;

/**
 *
 * @author Paulo Cesar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        ObsevableIF b = new ObsevableIF();
        
        b.addObserver(new ObserverPrint());
        b.addObserver(new ObserverMail());
        
        b.requestHtml();
    }
    
}
