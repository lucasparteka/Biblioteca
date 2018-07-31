package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.AcoesEditora;
import Model.Editora;
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

public class TabelaEditoraController implements Initializable{
	
	private AcoesEditora acoesEditora;
	private Editora editora;
	private ObservableList<Editora> observableEditora;
	private ArrayList<Editora> arrayEditora = new ArrayList<>();
	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public ArrayList<Editora> getArrayEditora() {
		return arrayEditora;
	}

	public void setArrayEditora(ArrayList<Editora> arrayEditora) {
		this.arrayEditora = arrayEditora;
	}

	@FXML
    private TableView<Editora> tabelaEditora;

    @FXML
    private TableColumn<Editora, Long> colunaID;

    @FXML
    private TableColumn<Editora, String> colunaNome;

    @FXML
    private TableColumn<Editora, String> colunaNacionalidade;

    @FXML
    private Button botaoSelecionar;
    
    @FXML
    private Button botaoCancelar;
    
    @FXML
    void cancelarAcao(ActionEvent event) {
    	Stage stage = (Stage) botaoCancelar.getScene().getWindow();
	    stage.close(); 
    }

    @FXML
    void selecionarEditora(ActionEvent event) {
    	setEditora(tabelaEditora.getSelectionModel().getSelectedItem());
    	Stage stage = (Stage) botaoSelecionar.getScene().getWindow();
	    stage.close(); 

    }
	
    public void carregarEditoras() {
    	
    	colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaNacionalidade.setCellValueFactory(new PropertyValueFactory<>("nacionalidade"));
    	
    	acoesEditora = new AcoesEditora();
    	setArrayEditora(acoesEditora.retornaEditoras());
    	observableEditora = FXCollections.observableArrayList(getArrayEditora());
    	tabelaEditora.setItems(observableEditora);
    	
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarEditoras();
		if(observableEditora.isEmpty()) {
			botaoSelecionar.setDisable(true);
		}
	}

}
