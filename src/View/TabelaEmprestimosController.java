package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Controller.AcoesEmprestimo;
import Model.Emprestimo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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

public class TabelaEmprestimosController implements Initializable {

	private AcoesEmprestimo acoesEmprestimo;
	private ArrayList<Emprestimo> listEmprestimosTabela;
	private int paginaAtual;

	public ArrayList<Emprestimo> getListEmprestimosTabela() {
		return listEmprestimosTabela;
	}

	public void setListEmprestimosTabela(ArrayList<Emprestimo> listEmprestimosTabela) {
		this.listEmprestimosTabela = listEmprestimosTabela;
	}

	@FXML
	private TableView<Emprestimo> tabelaEmprestimos;

	@FXML
	private TableColumn<Emprestimo, Long> colunaID;

	@FXML
	private TableColumn<Emprestimo, String> colunaTitulo;

	@FXML
	private TableColumn<Emprestimo, String> colunaStatus;

	@FXML
	private TableColumn<Emprestimo, String> colunaUsuario;

	@FXML
	private TableColumn<Emprestimo, String> colunaDataEmprestimo;

	@FXML
	private TableColumn<Emprestimo, String> colunaDataDevolucao;

	@FXML
	private Button botaoDevolucao;

	@FXML
	private Button botaoCancelar;

	@FXML
	private Button botaoCancelarEmprestimo;

	@FXML
	private Pagination paginacao;

	@FXML
	private Label labelStatus;

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void registrarDevolucao(ActionEvent event) {
		if (tabelaEmprestimos.getSelectionModel().getSelectedItem().getStatus().equals("Finalizado")) {
			labelStatus.setText("Esse emprestimo ja está finalizado");
		} else {
			AcoesEmprestimo.alterarStatusEmprestimo(tabelaEmprestimos.getSelectionModel().getSelectedItem(),
					AcoesEmprestimo.DEVOLVER_EMPRESTIMO);
			labelStatus.setText("Emprestimo Devolvido");
			createPage(paginaAtual);
		}
	}

	@FXML
	void cancelarEmprestimo(ActionEvent event) {
		if (tabelaEmprestimos.getSelectionModel().getSelectedItem().getStatus().equals("Finalizado")) {
			labelStatus.setText("Esse emprestimo ja está finalizado");
		} else {
			AcoesEmprestimo.alterarStatusEmprestimo(tabelaEmprestimos.getSelectionModel().getSelectedItem(),
					AcoesEmprestimo.EXCLUIR_EMPRESTIMO);
			labelStatus.setText("Emprestimo Cancelado");
			createPage(paginaAtual);
		}

	}

	public Node createPage(int pageIndex) {
		paginaAtual = pageIndex;
		colunaUsuario.setCellValueFactory(
				cellDataPessoa -> new SimpleStringProperty(cellDataPessoa.getValue().getPessoa().getNome()));
		colunaDataDevolucao.setCellValueFactory(new PropertyValueFactory<>("dataDevolucao"));
		colunaDataEmprestimo.setCellValueFactory(new PropertyValueFactory<>("dataEmprestimo"));
		colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		colunaTitulo.setCellValueFactory(cellDataAbstractInformacional -> new SimpleStringProperty(
				cellDataAbstractInformacional.getValue().getInformacional().getTitulo()));

		tabelaEmprestimos.setItems(FXCollections.observableArrayList(acoesEmprestimo.retornaEmprestimos(pageIndex)));
		return tabelaEmprestimos;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		acoesEmprestimo = new AcoesEmprestimo();
		int nLinhas = acoesEmprestimo.retornaQuantidade();
		int nLinhasPorPagina = 3;
		int nPaginas = (nLinhas + (nLinhasPorPagina - 1)) / nLinhasPorPagina;
		paginacao.setCurrentPageIndex(0);
		paginacao.setPageCount(nPaginas);
		paginacao.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
	}
}
