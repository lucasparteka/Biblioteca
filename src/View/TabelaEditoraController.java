package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Controller.AcoesEditora;
import Model.Editora;
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

public class TabelaEditoraController implements Initializable{
	
	private AcoesEditora acoesEditora;
	private Editora editora;
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
    private Pagination paginacao;

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
	
    public Node createPage(int pageIndex) {
    	
    	colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaNacionalidade.setCellValueFactory(new PropertyValueFactory<>("nacionalidade"));
    	tabelaEditora.setItems(FXCollections.observableArrayList(acoesEditora.retornaEditoras(pageIndex)));
    	return tabelaEditora;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		acoesEditora = new AcoesEditora();
		int nLinhas = acoesEditora.retornaQuantidade();
		int nLinhasPorPagina = 3;
		int nPaginas = (nLinhas + (nLinhasPorPagina - 1)) / nLinhasPorPagina;
		paginacao.setCurrentPageIndex(0);
		paginacao.setPageCount(nPaginas);
		paginacao.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
	}

}
