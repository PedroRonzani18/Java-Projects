package campominado;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import logic.LogicaCampoMinado;

public class FXMLDocumentController implements Initializable{

    private LogicaCampoMinado logica;
    
    @FXML
    private MenuItem miNovoJogo;
    
    @FXML
    private Label lTentativas;
    
    @FXML
    private MenuItem miSair;

    @FXML
    private Menu mSair;
    
    @FXML
    private GridPane gp;

    @FXML
    void novoJogo(ActionEvent event) {
        logica.reinicia();
        limpaBotoes();
    }

    @FXML
    void sair(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void click(ActionEvent event) {
        Button aux = (Button) event.getSource();
        
        aux.setDisable(true);
        
        for(Node node : gp.getChildren()){
            if(aux.equals(node)){
                Integer i = GridPane.getRowIndex(node);
                Integer j = GridPane.getColumnIndex(node);
                
                if(i == null)
                    i = 0;
                if(j == null)
                    j = 0;
                
                int resultado = logica.realizaJogada(i, j);
                
                lTentativas.setText(logica.getTentativas() + " Tentativas");
                
                if(resultado == 0){
                    aux.setStyle("-fx-background-color : red");
                    
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    
                    alert.setTitle("Derrota");
                    alert.setContentText("Você perdeu, tente novamente!!!");
                    
                    alert.showAndWait();
                    
                    if(!alert.isShowing())
                        limpaBotoes();
                    
                }else if(resultado == 2){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    
                    alert.setTitle("Vitória");
                    alert.setContentText("Parabens!!! Você venceu!!!");
                    
                    alert.show();
                    
                    limpaBotoes();
                }
            }
        }
    }
    
    
    private void limpaBotoes(){
        for(Node node : gp.getChildren()){
            if(node instanceof Button){
                ((Button) node).setDisable(false);
                ((Button) node).setStyle("-fx-background-color : grey");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logica = new LogicaCampoMinado();
        limpaBotoes();
    }
}
