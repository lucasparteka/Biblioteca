package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.AcoesAutor;
import Model.Autor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TabelaAutoresController implements Initializable{
	
	private AcoesAutor acoesAutor;
	private ObservableList<Autor> observableAutores;
	private Autor autorSelecionado;
	private ArrayList<Autor> listAutores = new ArrayList<>();
	
	
	public ArrayList<Autor> getListAutores() {
		return listAutores;
	}

	public void setListAutores(ArrayList<Autor> listAutores) {
		this.listAutores = listAutores;
	}

	public Autor getAutorSelecionado() {
		return autorSelecionado;
	}

	public void setAutorSelecionado(Autor autorSelecionado) {
		this.autorSelecionado = autorSelecionado;
	}

	@FXML
    private TableView<Autor> tabelaAutores;

    @FXML
    private TableColumn<Autor, Long> colunaID;

    @FXML
    private TableColumn<Autor, String> colunaNome;

    @FXML
    private TableColumn<Autor, String> colunaSobrenome;
    
    @FXML
    private Button botaoSelecionar;
    
    @FXML
    void selecionarAutor(ActionEvent event) {
    	setAutorSelecionado(tabelaAutores.getSelectionModel().getSelectedItem());
    	Stage stage = (Stage) botaoSelecionar.getScene().getWindow();
	    stage.close(); 
    }
    
    public void carregarAutores() {
    	
    	colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobreNome"));
    	
    	acoesAutor = new AcoesAutor();
    	setListAutores(acoesAutor.retornaAutores());
    	observableAutores = FXCollections.observableArrayList(getListAutores());
    	tabelaAutores.setItems(observableAutores);
    	
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarAutores();
		if(observableAutores.isEmpty()) {
			botaoSelecionar.setDisable(true);
		}
		
	}

}
