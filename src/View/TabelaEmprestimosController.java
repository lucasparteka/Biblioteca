package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.AcoesEmprestimo;
import Pojo.TabelaEmprestimoPojo;
import dao.EmprestimoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TabelaEmprestimosController implements Initializable {

	private EmprestimoDAO emprestimoDAO;
	private ObservableList<TabelaEmprestimoPojo> observableEmprestimo;
	private ArrayList<TabelaEmprestimoPojo> listEmprestimosTabela;

	public ArrayList<TabelaEmprestimoPojo> getListEmprestimosTabela() {
		return listEmprestimosTabela;
	}

	public void setListEmprestimosTabela(ArrayList<TabelaEmprestimoPojo> listEmprestimosTabela) {
		this.listEmprestimosTabela = listEmprestimosTabela;
	}

	@FXML
	private TableView<TabelaEmprestimoPojo> tabelaEmprestimos;

	@FXML
	private TableColumn<TabelaEmprestimoPojo, Long> colunaID;

	@FXML
	private TableColumn<TabelaEmprestimoPojo, String> colunaTitulo;

	@FXML
	private TableColumn<TabelaEmprestimoPojo, String> colunaTipo;

	@FXML
	private TableColumn<TabelaEmprestimoPojo, String> colunaUsuario;

	@FXML
	private TableColumn<TabelaEmprestimoPojo, String> colunaDataEmprestimo;

	@FXML
	private TableColumn<TabelaEmprestimoPojo, String> colunaDataDevolucao;
	
	@FXML
    private Button botaoDevolucao;

    @FXML
    private Button botaoCancelar;
    
    @FXML
    private Button botaoCancelarEmprestimo;

    @FXML
    void cancelarAcao(ActionEvent event) {

    }

    @FXML
    void registrarDevolucao(ActionEvent event) {
    	
    	Long idLong = tabelaEmprestimos.getSelectionModel().getSelectedItem().getId();
    	AcoesEmprestimo acoesEmprestimo = new AcoesEmprestimo();
    	acoesEmprestimo.registrarDevolucao(idLong);
    	carregarEmprestimos();
    	
    }
    
    @FXML
    void cancelarEmprestimo(ActionEvent event) {
    	
    	Long idLong = tabelaEmprestimos.getSelectionModel().getSelectedItem().getId();
    	AcoesEmprestimo acoesEmprestimo = new AcoesEmprestimo();
    	acoesEmprestimo.cancelaremprestimo(idLong);
    	carregarEmprestimos();
    }

	public void carregarEmprestimos() {

		colunaUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
		colunaDataDevolucao.setCellValueFactory(new PropertyValueFactory<>("dataDevolucao"));
		colunaDataEmprestimo.setCellValueFactory(new PropertyValueFactory<>("dataEmprestimo"));
		colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipoMaterial"));
		colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));

		emprestimoDAO = new EmprestimoDAO();
		setListEmprestimosTabela(emprestimoDAO.retornaEmprestimosTabela());
		observableEmprestimo = FXCollections.observableArrayList(listEmprestimosTabela);
		tabelaEmprestimos.setItems(observableEmprestimo);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarEmprestimos();
	}
}
