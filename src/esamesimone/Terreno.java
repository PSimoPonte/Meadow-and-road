/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esamesimone;

import java.util.ArrayList;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author 
 */
public abstract class Terreno { 
    StackPane sp;
    String color;
   // String colorOpposit;
    static boolean controllo;
    abstract boolean disegnaQuadrato(GridPane gridpane,int riga,int colonna,Terreno[][] terreno);
    //abstract boolean automobile(GridPane gridpane, int riga, int colonna);
    
}
