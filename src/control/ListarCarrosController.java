package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import DAO.CarroDAO;
import DAO.Conexao;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;
import model.Carro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ListarCarrosController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton VoltarButton;

    @FXML
    private TableColumn<Carro, String> FabricanteCol;

    @FXML
    private TableColumn<Carro, String> nomeCol;

    @FXML
    private TableColumn<Carro, String> AnoCol;

    @FXML
    private JFXButton PesquisarButton;

    @FXML
    private JFXButton EditarButton;

    @FXML
    private TableColumn<Carro, Float> PrecoCol;

    @FXML
    private JFXTextField PesquisarField;

    @FXML
    private TableView<Carro> TabelaCarros;

    Carro carroSelecionado;

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert VoltarButton != null : "fx:id=\"VoltarButton\" was not injected: check your FXML file 'ListarCarros.fxml'.";
        assert FabricanteCol != null : "fx:id=\"FabricanteCol\" was not injected: check your FXML file 'ListarCarros.fxml'.";
        assert nomeCol != null : "fx:id=\"nomeCol\" was not injected: check your FXML file 'ListarCarros.fxml'.";
        assert AnoCol != null : "fx:id=\"AnoCol\" was not injected: check your FXML file 'ListarCarros.fxml'.";
        assert PesquisarButton != null : "fx:id=\"PesquisarButton\" was not injected: check your FXML file 'ListarCarros.fxml'.";
        assert EditarButton != null : "fx:id=\"EditarButton\" was not injected: check your FXML file 'ListarCarros.fxml'.";
        assert PrecoCol != null : "fx:id=\"PrecoCol\" was not injected: check your FXML file 'ListarCarros.fxml'.";
        assert PesquisarField != null : "fx:id=\"PesquisarField\" was not injected: check your FXML file 'ListarCarros.fxml'.";
        assert TabelaCarros != null : "fx:id=\"TabelaCarros\" was not injected: check your FXML file 'ListarCarros.fxml'.";
    }

    private ObservableList<Carro> getObservableList(ArrayList<Carro> carros) {
        ObservableList<Carro> obsCategorias = FXCollections.observableArrayList(carros);

        return obsCategorias;
    }

    //Armazenando o carro selecionado na classe, pois o método excluir e editar irão manipulá-lo
    public void selectCarro(Carro car) {
        this.carroSelecionado = car;
    }

    @FXML
    private void handlerVoltar(ActionEvent event) throws IOException {
        //Retornando para a tela de menu
        Parent menu_parent = FXMLLoader.load(getClass().getResource("/view/MenuFXML.fxml"));
        Scene menu_scene = new Scene(menu_parent);

        //Setando o palco a partir do palco anterior
        Stage palco = (Stage) ((Node) event.getSource()).getScene().getWindow();

        palco.setScene(menu_scene);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //Nome Fabricante Ano Preco
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        FabricanteCol.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        AnoCol.setCellValueFactory(new PropertyValueFactory<>("ano"));
        PrecoCol.setCellValueFactory(new PropertyValueFactory<>("preco"));
        Connection con = Conexao.AbrirConexão();
        ArrayList<Carro> carros = new CarroDAO(con).getCarroLista();
        TabelaCarros.setItems(getObservableList(carros));
        TabelaCarros.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selectCarro(newValue));
    }

    @FXML
    private void handlerExcluir(ActionEvent event) throws IOException {
        //Abrindo Conexão
        Connection con = Conexao.AbrirConexão();
        CarroDAO carroDAO = new CarroDAO(con);
        
        if (carroSelecionado != null) {
            int remo = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o carro '" + carroSelecionado.getNome() + "' ?");
            //Cancelar == 2 | Não é == 1 | Sim é == 0
            if (remo == 0) {
                boolean ex = carroDAO.ExcluirCarro(carroSelecionado.getId());
                if (ex) {
                    TabelaCarros.getItems().remove(carroSelecionado);
                    JOptionPane.showMessageDialog(null, "Carro removido com sucesso !");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao remover o Carro.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, primeiro selecione algum carro para excluí-lo.");
        }

    }

    @FXML
    private void handlerEditar(ActionEvent event) throws IOException {
          
        if (this.carroSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Primeiro selecione o carro do qual deseja editar.");
        } else {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/view/UpsertFXML.fxml"));
            //Setando o Controller no fxmlloader
            fxmlloader.setController(new UpsertController(this.carroSelecionado));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Carregando o fxml na scene:
            stage.setScene(new Scene(fxmlloader.load()));
            stage.show();
        }
    }

}
