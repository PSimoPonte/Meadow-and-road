
package esamesimone;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author 
 */
public class EsameSimone extends Application {
    BorderPane borderP;
    static Button avvia;//,aggiungiAuto;
    static ToggleGroup group;
    static ToggleButton aggiungiAuto1;
    static Button aggiungiAuto;
    static boolean controllo = false;
    int contatore = 3;
    Label autoDisponibili = new Label();
    static ArrayList cordinata = new ArrayList (6);
   // boolean isPressed;
    @Override
    public void start(Stage primaryStage) {
        
        double base,altezza;
        final int size = 8 ;
       
        aggiungiAuto = new Button("Aggiungi Auto");
        avvia = new Button("Avvia");
        //group = new ToggleGroup();
        //aggiungiAuto = new ToggleButton("Aggiungi Auto");
        //aggiungiAuto.setToggleGroup(group);
        //aggiungiAuto.setSelected(true);
        //isPressed = false;
        final GridPane gp = new GridPane();

        //===========Creare una nuova finestra e poi chiudere la finestra corrente
        
        avvia.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                 Stage stage = new Stage();
                 stage.initModality(Modality.APPLICATION_MODAL);
                 stage.initStyle(StageStyle.DECORATED);
                 stage.setTitle("Finestra dei bottoni");
                 
                 HBox root1 = new HBox(15);
                 Button destra = new Button("Destra");
                 Button sinistra = new Button("Sinistra");
                 Button su = new Button("Su");
                 Button giu = new Button("Giù");
                 Button random = new Button("random");
                 Button start = new Button("Start");
                 Button stop = new Button("Stop");
                 
                 destra.setOnAction(new EventHandler<ActionEvent>() {
            
                            @Override
                            public void handle(ActionEvent e) {
                                Strada.controllo = true;
                               
                                aggiungiAuto.setDisable(false);

                                for(int i=0; i<6; i++){
                                     
                                    int colonna=(int)cordinata.get(i);
                                    i++;
                                    int riga=(int)cordinata.get(i);
                                    
                                    System.out.print(cordinata.get(i));
                                  //  Auto car = new Auto();
                                   
                                    Strada.removeAutomobile(gp, riga, colonna);
                                }

                            }
                        });
                 
                 root1.setPadding(new Insets(10,10,10,10));
                 root1.getChildren().addAll(destra,sinistra, su,giu,random,start,stop);
                
                 stage.setScene(new Scene(root1));  
                 stage.setX(650);
                 stage.setY(110);
                 stage.show();
                  
        //================ codice per chiudere la finestra principale
        /*
                 Stage stage1 = (Stage) avvia.getScene().getWindow();
                 stage1.close();
        */    
            }
        });
        autoDisponibili.setText("Auto Disponibili: "+contatore);
        HBox hb = new HBox(50);
        hb.setPadding(new Insets(10,10,10,10));
        hb.getChildren().addAll(autoDisponibili,aggiungiAuto,avvia);
        gp.setGridLinesVisible(true);
        
        base = 400;
        altezza = 420;
        
        final Terreno[][] terreno = new Terreno[size][size];
        for(int i=0;i<size;i++) 
        {
            for(int k = 0;k<size;k++)
            {
            Strada strada = new Strada();
            strada.disegnaQuadrato(gp, i, k,terreno);
            }
        }
        for(int i = 1; i< size -1 ; i++)
        {
            for(int k = 1;k<size-1;k++)
            {
                Prato prato = new Prato();
                prato.disegnaQuadrato(gp, i, k, terreno);
                System.out.println("===========");
            }
        }
        aggiungiAuto.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                Strada.controllo = true;
                contatore--;
                autoDisponibili.setText("Auto Disponibili: "+contatore);
                System.out.println("============="+ contatore);
                if (contatore==0){
                    aggiungiAuto.setDisable(true);
                }
            }
        });
        
        //=====================================================================
        //=====================================================================
        //=====================================================================
        /*
        if(aggiungiAuto.isSelected()){
                
                    aggiungiAuto.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                         Auto  car = new Auto();
                         car.automobile(gp, riga, colonna);
                         
                        //strada.disegnaQuadrato(gridpane, riga, colonna, terreno);
                        System.out.println("Hai creato una Macchina!  "+car);
                        
                    }
                    });
                    
                }
        */
        //=====================================================================
        //================STAMPO RIGA E COLONNA DEL GRIDPANE==========================
        //=====================================================================
        /*
          gp.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                for( Node node: gp.getChildren()) {

                    if( node instanceof StackPane) {
                        if( node.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())) {
                            if(terreno[GridPane.getRowIndex( node)][GridPane.getRowIndex( node)].getClass().getSimpleName().equals("Strada"))
                            {
                            Auto  car = new Auto();
                            car.automobile(gp, GridPane.getRowIndex( node), GridPane.getRowIndex( node));
                            }//System.out.println( "Node: " + node + " at " + GridPane.getRowIndex( node) + "/" + GridPane.getColumnIndex( node));
                        }
                    }
              
                }
            }
        });
         */
        //=====================================================================
         //=====================================================================
         //=====================================================================
        /*
         
         Auto  car = new Auto();
        car.automobile(gp, GridPane.getRowIndex( node), GridPane.getColumnIndex( node));
              

         aggiungiAuto.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Auto  car = new Auto();
                //strada.disegnaQuadrato(gridpane, riga, colonna, terreno);
                System.out.println("Hai creato una Macchina!  "+car);
            }
        });
         
        */
        //=====================================================================
        //=====================================================================
        //=====================================================================
        
        for (int i = 0; i < size; i++) {
            gp.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            gp.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
        StackPane root = new StackPane();
        borderP = new BorderPane();
        borderP.setCenter(gp);
        borderP.setBottom(hb);
        root.getChildren().add(borderP);
        
        Scene scene = new Scene(root, base, altezza);
        
        primaryStage.setTitle("Finestra principale");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


