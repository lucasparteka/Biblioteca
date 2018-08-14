package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Controller.AcoesAutor;
import Model.Autor;
import dao.AutorDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TabelaAutoresController implements Initializable {

	private AcoesAutor acoesAutor;
	private ObservableList<Autor> observableAutores;
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
		int controle = pageIndex + 1;
		int fim = controle * 3;
		int inicio = fim - 3;

		colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobreNome"));

		tabelaAutores.setItems(FXCollections.observableArrayList(listAutor.subList(inicio, fim)));

		return tabelaAutores;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Autor autor1 = new Autor();
		autor1.setNome("Lucas");
		autor1.setSobreNome("Leal");
		Autor autor2 = new Autor();
		autor2.setNome("Andre");
		autor2.setSobreNome("Leal");
		Autor autor3 = new Autor();
		autor3.setNome("Bruna");
		autor3.setSobreNome("Leal");
		Autor autor4 = new Autor();
		autor4.setNome("Marcia");
		autor4.setSobreNome("Leal");
		Autor autor5 = new Autor();
		autor5.setNome("Juca");
		autor5.setSobreNome("Leal");
		Autor autor6 = new Autor();
		autor6.setNome("Antonio");
		autor6.setSobreNome("Leal");
		Autor autor7 = new Autor();
		autor7.setNome("Pedro");
		autor7.setSobreNome("Leal");
		Autor autor8 = new Autor();
		autor8.setNome("José");
		autor8.setSobreNome("Leal");
		Autor autor9 = new Autor();
		autor9.setNome("Catia");
		autor9.setSobreNome("Leal");
		Autor autor10 = new Autor();
		autor10.setNome("Leandro");
		autor10.setSobreNome("Leal");
		Autor autor11 = new Autor();
		autor11.setNome("Carol");
		autor11.setSobreNome("Leal");
		Autor autor12 = new Autor();
		autor12.setNome("Mariana");
		autor12.setSobreNome("Leal");

		listAutor = new ArrayList<>();
		listAutor.add(autor1);
		listAutor.add(autor2);
		listAutor.add(autor3);
		listAutor.add(autor4);
		listAutor.add(autor5);
		listAutor.add(autor6);
		listAutor.add(autor7);
		listAutor.add(autor8);
		listAutor.add(autor9);
		listAutor.add(autor10);
		listAutor.add(autor11);
		listAutor.add(autor12);

		int nLinhas = listAutor.size();
		int nLinhasPorPagina = 3;
		int nPaginas = (nLinhas + (nLinhasPorPagina - 1)) / nLinhasPorPagina;
		paginacao.setCurrentPageIndex(0);
		paginacao.setPageCount(nPaginas);
		paginacao.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
	}

}
