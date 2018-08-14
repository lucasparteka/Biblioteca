package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Controller.AcoesAutor;
import Model.Autor;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TabelaAutoresController implements Initializable {

	private AcoesAutor acoesAutor;
	private Autor autorSelecionado;
	private ArrayList<Autor> listAutores;
	private ArrayList<Autor> listAutor;

	public ArrayList<Autor> getListAutor() {
		return listAutor;
	}

	public void setListAutor(ArrayList<Autor> listAutor) {
		this.listAutor = listAutor;
	}

	public TabelaAutoresController() {

	}

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
	private Pagination paginacao;

	@FXML
	void selecionarAutor(ActionEvent event) {
		setAutorSelecionado(tabelaAutores.getSelectionModel().getSelectedItem());
		Stage stage = (Stage) botaoSelecionar.getScene().getWindow();
		stage.close();
	}

	private Node createPage(int pageIndex) {
		colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobreNome"));
		tabelaAutores.setItems(FXCollections.observableArrayList(acoesAutor.retornaAutores(pageIndex)));
		return tabelaAutores;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		acoesAutor = new AcoesAutor();
		int nLinhas = acoesAutor.retornaQuantidade();
		int nLinhasPorPagina = 3;
		int nPaginas = (nLinhas + (nLinhasPorPagina - 1)) / nLinhasPorPagina;
		paginacao.setCurrentPageIndex(0);
		paginacao.setPageCount(nPaginas);
		paginacao.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
	}

}
