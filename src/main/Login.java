/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Juciano Victor
 */

//Classe que inicia a aplicação
public class Login extends Application {
    
    //Método que inicia a aplicação
    @Override //Anotação de sobrescrita
    public void start(Stage palco) throws Exception {
        //Setando o arquivo fxml que será aberto a partir desse método
        Parent cenario = FXMLLoader.load(getClass().getResource("/view/LoginFXML.fxml"));
        //Criando a cena e setando o cenario em seu construtor
        Scene scene = new Scene(cenario);         
        //Retirando a borda do windows
        palco.initStyle(StageStyle.UNDECORATED);
        //Setando a cena no palco
        palco.setScene(scene);
        //Mostra a tela
        palco.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
