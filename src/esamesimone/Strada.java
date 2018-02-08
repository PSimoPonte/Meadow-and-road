/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esamesimone;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


/**
 *
 * @author 
 */
public class Strada extends Terreno{
    
    //arrray per memorizzare dove le macchine sono state create. riga e colonna
   static Auto  car=null;
    @Override
    boolean disegnaQuadrato(final GridPane gridpane, final int riga,final int colonna,final Terreno[][] terreno) {
    try
    {
        color= "grey";
        sp = new StackPane();
        sp.setStyle("-fx-background-color: "+color+";-fx-border-color: black;");
        gridpane.add(sp, riga, colonna);
        terreno[riga][colonna] = this;
        sp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                
                if(controllo)   // -----> se il controllo è uguale a true
                {
                    car = new Auto();
                    car.automobile(gridpane, riga, colonna);
                    EsameSimone.cordinata.add(riga);
                    EsameSimone.cordinata.add(colonna);
                    Strada.controllo = false;
                } /*
                else {
                Prato prato = new Prato();
                prato.disegnaQuadrato(gridpane, riga, colonna, terreno);
                System.out.println("Hai creato un prato!"+prato);
                }
                */
            }
        });
    } catch (Exception ex)
    {
        System.out.println(ex.getMessage());
        return false;
    }
    return true;
    }
    
      static void removeAutomobile(final GridPane gridpane,final int riga,final int colonna){
      
          car.removeAutomobile(gridpane, riga, colonna);
          System.out.println("Ho rimosso la macchina dal punto di partenza "+colonna+" "+riga);
      }

}
