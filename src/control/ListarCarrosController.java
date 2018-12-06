package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import DAO.CarroDAO;
import DAO.Conexao;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;
import model.Carro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListarCarrosController implements Initializable {
	
	public ListarCarrosController() {
		
		
	}

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
	private ObservableList<Carro> getObservableList(ArrayList<Carro> carros){
		ObservableList<Carro> obsCategorias = FXCollections.emptyObservableList();
		for(Carro c:carros) {
			System.out.println("pegou");
			obsCategorias.add(c);
			
		}
		return obsCategorias;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("Mostra as coisaOpora");
		Connection con = Conexao.AbrirConexão();
		ArrayList<Carro> carros = new CarroDAO(con).getCarroLista();
		TabelaCarros.setItems(getObservableList(carros));
	}
}
