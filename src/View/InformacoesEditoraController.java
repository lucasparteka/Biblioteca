package View;

import java.net.URL;
import java.util.ResourceBundle;
import Controller.AcoesEditora;
import Model.Editora;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InformacoesEditoraController implements Initializable{
	
	Editora editora;
	AcoesEditora cadEditora;

	@FXML
    private TextField CampoNomeEditora;

    @FXML
    private TextField campoNacionalidade;

    @FXML
    private TextField campoID;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoSalvar;
    
    @FXML
    private Label labelStatus;

    @FXML
    void cancelarAcao(ActionEvent event) {

    }

    @FXML
    void editarDados(ActionEvent event) {

    }

    @FXML
    void pesquisarEditora(ActionEvent event) {
    	
    	long idLong = Long.parseLong(campoID.getText());
    	cadEditora = new AcoesEditora();
    	editora = cadEditora.pesquisar(idLong);
    	
    	if(editora == null) {
    		labelStatus.setText("Editora não encontrada!");
    	} else {
    		labelStatus.setText("");
    		CampoNomeEditora.setText(editora.getNome());
    	}
    	
    }

    @FXML
    void salvarEdicao(ActionEvent event) {

    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
