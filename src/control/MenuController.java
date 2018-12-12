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
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/view/UpsertFXML.fxml"));
            //Setando o controller que precisou ser retirado para passar o objeto pelo construtor na edição
            fxmlloader.setController(new UpsertController());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Carregando o fxml na scene:
            stage.setScene(new Scene(fxmlloader.load()));
            stage.show();
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
        Parent menu_parent = FXMLLoader.load(getClass().getResource("/view/ListarCarrosFXML.fxml"));
        Scene menu_scene = new Scene(menu_parent);

        //Setando o palco a partir do palco anterior
        Stage palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        palco.setScene(menu_scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
