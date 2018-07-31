package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Periodico;
import dao.PeriodicoDAO;
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

public class TabelaPeriodicosController implements Initializable{
	
	private PeriodicoDAO periodicoDAO;
	private Periodico periodicoSelecionado;
	private ArrayList<Periodico> listPeriodico;
	private ObservableList<Periodico> observablePeriodico;
	
	
	public ObservableList<Periodico> getObservableList() {
		return observablePeriodico;
	}

	public void setObservableList(ObservableList<Periodico> observablePeriodico) {
		this.observablePeriodico = observablePeriodico;
	}

	public ArrayList<Periodico> getListPeriodico() {
		return listPeriodico;
	}

	public void setListPeriodico(ArrayList<Periodico> listPeriodico) {
		this.listPeriodico = listPeriodico;
	}

	public Periodico getPeriodicoSelecionado() {
		return periodicoSelecionado;
	}

	public void setPeriodicoSelecionado(Periodico periodicoSelecionado) {
		this.periodicoSelecionado = periodicoSelecionado;
	}

	@FXML
    private TableView<Periodico> tabelaPeriodico;

    @FXML
    private TableColumn<Periodico, Long> colunaID;

    @FXML
    private TableColumn<Periodico, String> colunaTitulo;

    @FXML
    private TableColumn<Periodico, Integer> colunaCodBarras;

    @FXML
    private TableColumn<Periodico, Integer> colunaEstante;

    @FXML
    private TableColumn<Periodico, Integer> colunaExemplares;

    @FXML
    private TableColumn<Periodico, Integer> colunaDisponiveis;

    @FXML
    private TableColumn<Periodico, Integer> colunaISSN;

    @FXML
    private TableColumn<Periodico, Integer> colunaAno;

    @FXML
    private TableColumn<Periodico, Integer> colunaVolume;

    @FXML
    private Button botaoSelecionar;

    @FXML
    void cancelarAcao(ActionEvent event) {
    	Stage stage = (Stage) botaoSelecionar.getScene().getWindow();
	    stage.close();    	
    }

    @FXML
    void selecionarLivro(ActionEvent event) {
    	setPeriodicoSelecionado(tabelaPeriodico.getSelectionModel().getSelectedItem());
    	Stage stage = (Stage) botaoSelecionar.getScene().getWindow();
	    stage.close();    	

    }
    
    public void carregarPeriodicos() {
    	
    	colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
    	colunaAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
    	colunaCodBarras.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
    	colunaDisponiveis.setCellValueFactory(new PropertyValueFactory<>("disponiveis"));
    	colunaEstante.setCellValueFactory(new PropertyValueFactory<>("estante"));
    	colunaExemplares.setCellValueFactory(new PropertyValueFactory<>("exemplares"));
    	colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaISSN.setCellValueFactory(new PropertyValueFactory<>("issn"));
    	colunaVolume.setCellValueFactory(new PropertyValueFactory<>("volume"));
    	
    	periodicoDAO = new PeriodicoDAO();
    	setListPeriodico(periodicoDAO.retornaPeriodicos());
    	observablePeriodico = FXCollections.observableArrayList(getListPeriodico());
    	tabelaPeriodico.setItems(observablePeriodico);

    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarPeriodicos();
	}

}
