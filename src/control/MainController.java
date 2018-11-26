/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Juciano Victor
 */
public class MainController implements Initializable {
    
    //Declaração dos elementos manipuláveis da tela
    @FXML
    private JFXPasswordField passField;

    @FXML
    private JFXTextField loginField;

    @FXML
    private JFXButton lognBtn;

    @FXML
    private JFXButton signUpBtn;
    
    @FXML
    private JFXButton sairBTN;
   
    @FXML
    private void handleLogin(ActionEvent event) {
     //Recebendo dados dos campos login e senha
       String usuario = loginField.getText();
       String senha = passField.getText();     
    }
    
    @FXML
    private void handleSair(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
