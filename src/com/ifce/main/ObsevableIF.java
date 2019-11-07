package com.ifce.main;

import java.net.URL;
import java.net.URLConnection;
import java.util.Observable;
import java.util.Scanner;

public class ObsevableIF extends Observable{
    private String html = "";

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html= html;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void requestHtml() throws InterruptedException{
        while(true){
            String content = null;
            URLConnection connection = null;
            try {
              connection =  new URL("URL do site").openConnection();
                try (Scanner scanner = new Scanner(connection.getInputStream())) {
                    scanner.useDelimiter("\\Z");
                    content = scanner.next();
                }
              
              if(!this.html.equals(content)){
                  setHtml(content);
              }
              
            }catch ( Exception ex ) {
                ex.printStackTrace();
            }
            Thread.sleep(5000);
        }
    }

    @Override
    public String toString() {
        return "ObsevableIF{" + "htmt=" + html + '}';
    }
    
}
