package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Controller.AcoesPeriodico;
import Model.Periodico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TabelaPeriodicosController implements Initializable {

	private Periodico periodicoSelecionado;
	private ArrayList<Periodico> listPeriodico;
	private ObservableList<Periodico> observablePeriodico;
	private AcoesPeriodico acoesPeriodico;

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
	private Pagination paginacao;

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
	private Button botaoCancelar;

	@FXML
	private Label labelStatus;

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void selecionarLivro(ActionEvent event) {
		if (tabelaPeriodico.getSelectionModel().getSelectedItem().getDisponiveis() < 1) {
			labelStatus.setText("Material selecionado não possui exemplares disponíveis");
		} else {
			setPeriodicoSelecionado(tabelaPeriodico.getSelectionModel().getSelectedItem());
			Stage stage = (Stage) botaoSelecionar.getScene().getWindow();
			stage.close();
		}
	}

	public Node createPage(int pageIndex) {

		colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		colunaAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
		colunaCodBarras.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
		colunaDisponiveis.setCellValueFactory(new PropertyValueFactory<>("disponiveis"));
		colunaEstante.setCellValueFactory(new PropertyValueFactory<>("estante"));
		colunaExemplares.setCellValueFactory(new PropertyValueFactory<>("exemplares"));
		colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaISSN.setCellValueFactory(new PropertyValueFactory<>("issn"));
		colunaVolume.setCellValueFactory(new PropertyValueFactory<>("volume"));

		tabelaPeriodico.setItems(FXCollections.observableArrayList(acoesPeriodico.retornaPeriodicos(pageIndex)));

		return tabelaPeriodico;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		acoesPeriodico = new AcoesPeriodico();
		int nLinhas = acoesPeriodico.retornaQuantidade();
		int nLinhasPorPagina = 3;
		int nPaginas = (nLinhas + (nLinhasPorPagina - 1)) / nLinhasPorPagina;
		paginacao.setCurrentPageIndex(0);
		paginacao.setPageCount(nPaginas);
		paginacao.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
	}

}
