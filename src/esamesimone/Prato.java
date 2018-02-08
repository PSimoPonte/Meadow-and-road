/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esamesimone;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


/**
 *
 * @author 
 */
public class Prato extends Terreno {

    @Override
    boolean disegnaQuadrato(final GridPane gridpane, final int riga,final int colonna,final Terreno[][] terreno) {
    try
    {
        
            color = "green";
            sp = new StackPane();

           //background-->metto il colore di sfondo grazie alla variabile color    //border--> metto il colore al bordo
            sp.setStyle("-fx-background-color: "+color+";-fx-border-color: black;");
            gridpane.add(sp, riga, colonna);
            terreno[riga][colonna] = this;
            sp.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    Strada  strada = new Strada();
                    strada.disegnaQuadrato(gridpane, riga, colonna, terreno);
                    System.out.println("Hai creato una strada! "+strada + " nella posizione "+ riga +"-"+colonna);
                }
            });
    } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
   }

    
   

   
    
}
