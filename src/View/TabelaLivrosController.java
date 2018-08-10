package View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Autor;
import Model.Editora;
import Model.Livro;
import dao.LivroDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TabelaLivrosController implements Initializable {
	
	private LivroDAO livroDAO;
	private ObservableList<Livro> observableLivro;
	private ArrayList<Livro> listLivro;
	private Livro livroSelecionado;
	
	public ArrayList<Livro> getListLivro() {
		return listLivro;
	}

	public void setListLivro(ArrayList<Livro> listLivro) {
		this.listLivro = listLivro;
	}
	
	public Livro getLivroSelecionado() {
		return livroSelecionado;
	}

	public void setLivroSelecionado(Livro livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}

	@FXML
    private TableView<Livro> tabelaLivros;

    @FXML
    private TableColumn<Livro, Long> colunaID;

    @FXML
    private TableColumn<Livro, String> colunaTitulo;

    @FXML
    private TableColumn<Livro, Integer> colunaCodBarras;

    @FXML
    private TableColumn<Livro, Integer> colunaEstante;

    @FXML
    private TableColumn<Livro, Integer> colunaExemplares;

    @FXML
    private TableColumn<Livro, Integer> colunaDisponiveis;

    @FXML
    private TableColumn<Livro, Integer> colunaISBN;

    @FXML
    private TableColumn<Livro, Integer> colunaAno;

    @FXML
    private TableColumn<Livro, Integer> colunaEdicao;

    @FXML
    private TableColumn<Livro, String> colunaEditora;
    
    @FXML
    private TableColumn<Livro, String> colunaAutor;

    @FXML
    private Button botaoSelecionar;
    
    @FXML
    private Label labelTeste;
    
    @FXML
    void cancelarAcao(ActionEvent event) {
    	Stage stage = (Stage) botaoSelecionar.getScene().getWindow();
	    stage.close();
    }

    @FXML
    public void selecionarLivro(ActionEvent event) throws IOException {
    	setLivroSelecionado(tabelaLivros.getSelectionModel().getSelectedItem());
    	Stage stage = (Stage) botaoSelecionar.getScene().getWindow();
	    stage.close();    	
    }
    
    public void carregarTabelaLivros() {
    	
    	colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
    	colunaAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
    	colunaCodBarras.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
    	colunaExemplares.setCellValueFactory(new PropertyValueFactory<>("exemplares"));
    	colunaDisponiveis.setCellValueFactory(new PropertyValueFactory<>("disponiveis"));
    	colunaEdicao.setCellValueFactory(new PropertyValueFactory<>("edicao"));
    	colunaEstante.setCellValueFactory(new PropertyValueFactory<>("estante"));
    	colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
    	colunaAutor.setCellValueFactory(cellDataAutor -> new SimpleStringProperty(cellDataAutor.getValue().getAutor().getNome()));
    	colunaEditora.setCellValueFactory(cellDataEditora -> new SimpleStringProperty(cellDataEditora.getValue().getEditora().getNome()));

    	
    	livroDAO = new LivroDAO();
    	setListLivro(livroDAO.retornaTodosLivros());
    	observableLivro = FXCollections.observableArrayList(getListLivro());
    	tabelaLivros.setItems(observableLivro);
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarTabelaLivros();
	}

}
