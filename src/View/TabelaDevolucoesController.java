package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Pojo.TabelaEmprestimoPojo;
import dao.DevolucoesDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TabelaDevolucoesController implements Initializable{
	
	private DevolucoesDAO devolucoesDAO;
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
    private Button botaoCancelar;

    @FXML
    void cancelarAcao(ActionEvent event) {

    }
    
    public void carregarDevolucoes() {

		colunaUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
		colunaDataDevolucao.setCellValueFactory(new PropertyValueFactory<>("dataDevolucao"));
		colunaDataEmprestimo.setCellValueFactory(new PropertyValueFactory<>("dataEmprestimo"));
		colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipoMaterial"));
		colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));

		devolucoesDAO = new DevolucoesDAO();
		//setListEmprestimosTabela(devolucoesDAO.retornaDevolucoes());
		observableEmprestimo = FXCollections.observableArrayList(listEmprestimosTabela);
		tabelaEmprestimos.setItems(observableEmprestimo);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarDevolucoes();
	}

}
