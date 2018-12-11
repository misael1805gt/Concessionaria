/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.CarroDAO;
import DAO.Conexao;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Carro;

/**
 * FXML Controller class
 *
 * @author adrian
 */
public class UpsertController implements Initializable {

    @FXML
    private JFXTextField nomeTextField;

    @FXML
    private Label upsertLabel;

    @FXML
    private JFXTextField fabricanteTextField;

    @FXML
    private JFXTextField anoTextField;

    @FXML
    private JFXTextField precoTextField;

    //Objeto que será usado na hora de editar
    Carro carro;

    //Criando conexao 
    Connection conexao = Conexao.AbrirConexão();

    //Criando o objeto CarroDAO que se conectará com o banco e realizará a função de cadastrar
    CarroDAO carroDAO = new CarroDAO(conexao);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (this.carro != null) { //Se for editar
            //Trocando o texto da label para Editar Carro
            upsertLabel.setText("Editar Carro");
        }
    }

    public UpsertController() {//Será chamado quando o usuário quiser cadastrar
        this(null);//Entrará dentro do método UpsertController(Carro carro) passando null
    }

    public UpsertController(Carro carro) {
        this.carro = carro;
    }

    @FXML
    private void handlerSalvarBTN(ActionEvent event) throws IOException {
        //Capturando valor dos TextFields
        String nomeCarro = nomeTextField.getText();
        String fabricante = fabricanteTextField.getText();
        String ano = anoTextField.getText();
        //Convertendo o valor de String que vem do TextField para float, valor que o banco de dados pede.
        float preco = Float.parseFloat(precoTextField.getText());

        if (carro == null) {//Se não tiver nada dentro do objeto é porque o usuário irá cadastrar
            
            boolean cadastrado = carroDAO.CadastrarCarro(nomeCarro, ano, fabricante, preco);

            if (cadastrado) {
                JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR O CARRO !!");
            }

        } else {////Se tiver algo dentro do objeto é porque o usuário irá editar

            boolean editado = carroDAO.AlterarCarro(carro.getId(), nomeCarro, ano, fabricante, preco);

            if (editado) {
                JOptionPane.showMessageDialog(null, "Carro editado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "ERRO AO EDITAR O CARRO !!");
            }
        }

        //Retornando para a tela de listagem
        Parent menu_parent = FXMLLoader.load(getClass().getResource("/view/MenuFXML.fxml"));
        Scene menu_scene = new Scene(menu_parent);

        //Setando o palco a partir do palco anterior
        Stage palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        palco.setScene(menu_scene);

    }

}
