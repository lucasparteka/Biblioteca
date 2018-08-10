package View;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import Controller.AcoesEditora;
import Model.Editora;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InformacoesEditoraController implements Initializable{
	
	private Editora editora;
	private AcoesEditora acoesEditora;

	@FXML
    private JFXTextField campoNomeEditora;

    @FXML
    private JFXTextField campoNacionalidade;
    
    @FXML
    private JFXTextField campoID;

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
    	
    	acoesEditora = new AcoesEditora();
    	//editora = new Editora();
    	editora = acoesEditora.pesquisar(Long.parseLong(campoID.getText()));
    	
    	if(editora == null) {
    		labelStatus.setText("Editora não encontrada!");
    	} else {
    		labelStatus.setText("");
    		campoNomeEditora.setText(editora.getNome());
    		campoNacionalidade.setText(editora.getNacionalidade());
    		labelStatus.setText("Editora localizada");
    	}
    	
    }

    @FXML
    void salvarEdicao(ActionEvent event) {

    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
