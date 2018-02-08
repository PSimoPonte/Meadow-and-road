/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esamesimone;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author 
 */
public class Auto {
    
     Circle circle ;
    
    public Auto(){
        circle = new Circle(2,2,10);
        //final Circle circ = new Circle(40,40,30);
        //sp.getChildren().add(circ); 
    }
    
    boolean automobile(final GridPane gridpane,final int riga,final int colonna){
        //Circle circle = new Circle();
        //circle.setFill(Color.RED);
        //circle.setCenterX(50.0f);
        //circle.setCenterY(50.0f);
        //circle.setRadius(20.0f);
        circle.setFill(Color.RED);
        gridpane.add(circle, riga, colonna);
        
        return true;
    }
    
     void removeAutomobile(final GridPane gridpane,final int riga,final int colonna){
        //Circle circle = new Circle();
        //circle.setFill(Color.RED);
        //circle.setCenterX(50.0f);
        //circle.setCenterY(50.0f);
        //circle.setRadius(20.0f);
        gridpane.getChildren().remove(circle);
      
    }
    
    /*
    
    public Auto(final StackPane sp) 
    {
        final Circle circ = new Circle(40,40,30);
        sp.getChildren().add(circ);
    }
*/
}
