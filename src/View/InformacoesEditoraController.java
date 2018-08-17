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
import javafx.stage.Stage;

public class InformacoesEditoraController implements Initializable{
	
	private Editora editora;
	private AcoesEditora acoesEditora;
	
	public InformacoesEditoraController() {
		acoesEditora = new AcoesEditora();
	}
	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

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
    private Button botaoCancelar;

    @FXML
    void cancelarAcao(ActionEvent event) {
    	Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
    }

    @FXML
    void editarDados(ActionEvent event) {
    	campoID.setDisable(true);
		botaoSalvar.setDisable(false);
		campoNomeEditora.setEditable(true);
    }

    @FXML
    void pesquisarEditora(ActionEvent event) {
    	
    	acoesEditora = new AcoesEditora();
    	editora = new Editora();
    	editora = acoesEditora.pesquisar(Long.parseLong(campoID.getText()));
    	
    	if(editora == null) {
    		labelStatus.setText("Editora não encontrada!");
    		campoNacionalidade.setText("");
    		campoNomeEditora.setText("");
    	} else {
    		labelStatus.setText("");
    		campoNomeEditora.setText(editora.getNome());
    		campoNacionalidade.setText(editora.getNacionalidade());
    		labelStatus.setText("Editora localizada");
    		botaoEditar.setDisable(false);
    	}
    	
    }

    @FXML
    void salvarEdicao(ActionEvent event) {
    	if(campoNomeEditora.getText().isEmpty()) {
    		labelStatus.setText("Preencha todos os campos");
    	} else {
    		getEditora().setId(Long.parseLong(campoID.getText()));
    		getEditora().setNacionalidade(campoNacionalidade.getText());
    		getEditora().setNome(campoNomeEditora.getText());
    		acoesEditora.acoesEditoraController(editora, AcoesEditora.ALTERAR_CADASTRO);
    		labelStatus.setText("Cadastro alterado");
    		campoID.setText("");
    		campoID.setDisable(false);
    		campoNacionalidade.setText("");
    		campoNomeEditora.setText("");
    		botaoEditar.setDisable(true);
    		botaoSalvar.setDisable(true);
    		
    	}
    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
