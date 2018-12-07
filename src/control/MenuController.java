/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kbyte
 */
public class MenuController implements Initializable {

    @FXML
    private JFXButton logoutBTN;

    @FXML
    private JFXButton cadastroBTN;

    @FXML
    private JFXButton listarBTN;

    @FXML
    void handlerGoCadastrar(ActionEvent event) throws IOException {
        Parent menu_parent = FXMLLoader.load(getClass().getResource("/view/UpsertFXML.fxml"));
        Scene menu_scene = new Scene(menu_parent);

        //Setando o palco a partir do palco anterior
        Stage palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        palco.setScene(menu_scene);
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        Parent menu_parent = FXMLLoader.load(getClass().getResource("/view/LoginFXML.fxml"));
        Scene menu_scene = new Scene(menu_parent);

        //Setando o palco a partir do palco anterior
        Stage palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        palco.setScene(menu_scene);
    }

    @FXML
    void handlerGoListar(ActionEvent event) throws IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
