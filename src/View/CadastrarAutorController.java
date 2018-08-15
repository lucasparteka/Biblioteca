package View;

import Controller.AcoesAutor;
import Model.Autor;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mask.ValidarNome;

/**
 * FXML Controller class
 *
 * @author lparteka
 */
public class CadastrarAutorController implements Initializable {

	private AcoesAutor acoesAutor;
	private Autor autor;
	
	public CadastrarAutorController() {
		setAutor(new Autor());
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@FXML
	private JFXTextField campoNome;

	@FXML
	private JFXTextField campoSobreNome;

	@FXML
	private Label labelStatus;

	@FXML
	private Button botaoCancelar;

	@FXML
	void validarLetras(KeyEvent keyEvent) {
		ValidarNome validaNome = new ValidarNome();
		validaNome.validarNome(campoNome);
		validaNome.validarNome(campoSobreNome);
	}

	@FXML
	void cadastrarAutor(ActionEvent event) {

		if (campoNome.getText().isEmpty() || campoSobreNome.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			this.autor.setNome(campoNome.getText());
			this.autor.setSobreNome(campoSobreNome.getText());
			acoesAutor.executarOperacao(autor, AcoesAutor.INSERIR_CADASTRO);
			labelStatus.setText("Cadastrado com sucesso");
			campoNome.setText("");
			campoSobreNome.setText("");
		}
	}

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		acoesAutor = new AcoesAutor();
		RequiredFieldValidator validator = new RequiredFieldValidator();
		validator.setMessage("Somente numeros!");

	}

}
