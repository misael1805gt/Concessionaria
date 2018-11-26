/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.Conexao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import DAO.UsuarioDAO;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author Juciano Victor
 */
public class LoginController implements Initializable {

    //Declaração dos elementos manipuláveis da tela
    //OBS:O nome deve ser igual ao do arquivo FXML
    @FXML
    private JFXPasswordField passTextField;

    @FXML
    private JFXTextField loginTextField;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXButton signUpBtn;

    @FXML
    private JFXButton sairBTN;

    @FXML
    protected void handleLogin(ActionEvent event) throws IOException {

        //Recebendo dados dos campos login e senha
        String login = loginTextField.getText();
        String senha = passTextField.getText();

        Connection con = Conexao.AbrirConexão();
        UsuarioDAO userDAO = new UsuarioDAO(con);

        if (userDAO.logar(login, senha)) {
            Parent menu_parent = FXMLLoader.load(getClass().getResource("/view/MenuFXML.fxml"));
            Scene menu_scene = new Scene(menu_parent);
            //Setando o palco apartir do palco anterior
            Stage palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
            palco.setScene(menu_scene);
        } else {
            loginTextField.setText("");
            passTextField.setText("");
            JOptionPane.showMessageDialog(null, "Login e/ou senha incorretos.");
        }
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
