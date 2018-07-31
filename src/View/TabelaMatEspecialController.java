package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.MaterialEspecial;
import dao.MatEspecialDAO;
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

public class TabelaMatEspecialController implements Initializable{
	
	private MatEspecialDAO matEspecialDAO;
	private ObservableList<MaterialEspecial> observableMatEspecial;
	private ArrayList<MaterialEspecial> listMatEspecial;
	private MaterialEspecial materialSelecionado;
	
	
	public MaterialEspecial getMaterialSelecionado() {
		return materialSelecionado;
	}

	public void setMaterialSelecionado(MaterialEspecial materialSelecionado) {
		this.materialSelecionado = materialSelecionado;
	}

	public ArrayList<MaterialEspecial> getListMatEspecial() {
		return listMatEspecial;
	}

	public void setListMatEspecial(ArrayList<MaterialEspecial> listMatEspecial) {
		this.listMatEspecial = listMatEspecial;
	}


	@FXML
    private TableView<MaterialEspecial> tabelaMatEspecial;

    @FXML
    private TableColumn<MaterialEspecial, Long> colunaID;

    @FXML
    private TableColumn<MaterialEspecial, String> colunaTitulo;

    @FXML
    private TableColumn<MaterialEspecial, Integer> colunaCodBarras;

    @FXML
    private TableColumn<MaterialEspecial, Integer> colunaEstante;

    @FXML
    private TableColumn<MaterialEspecial, Integer> colunaExemplares;

    @FXML
    private TableColumn<MaterialEspecial, Integer> colunaDisponiveis;

    @FXML
    private TableColumn<MaterialEspecial, String> colunaDescricao;

    @FXML
    private TableColumn<MaterialEspecial, String> colunaTipo;

    @FXML
    private Button botaoSelecionar;

    @FXML
    void cancelarAcao(ActionEvent event) {
    	Stage stage = (Stage) botaoSelecionar.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void selecionarMatespecial(ActionEvent event) {
    	setMaterialSelecionado(tabelaMatEspecial.getSelectionModel().getSelectedItem());
    	Stage stage = (Stage) botaoSelecionar.getScene().getWindow();
	    stage.close();  
    }
    
    public void carregarMatEspecial() {
    	
    	colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
    	colunaCodBarras.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
    	colunaDisponiveis.setCellValueFactory(new PropertyValueFactory<>("disponiveis"));
    	colunaEstante.setCellValueFactory(new PropertyValueFactory<>("estante"));
    	colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    	colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

    	matEspecialDAO = new MatEspecialDAO();
    	setListMatEspecial(matEspecialDAO.retornaMatEspecial());
    	observableMatEspecial = FXCollections.observableArrayList(getListMatEspecial());
    	tabelaMatEspecial.setItems(observableMatEspecial);
    	
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarMatEspecial();
	}

}
