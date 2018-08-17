package View;

import Controller.AcoesPessoa;
import Model.Pessoa;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mask.ValidarNumeros;

/**
 * FXML Controller class
 *
 * @author lparteka
 */
public class InformacoesPessoaController implements Initializable {

	private AcoesPessoa acoesPessoa;
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public InformacoesPessoaController() {
		acoesPessoa = new AcoesPessoa();
	}

	@FXML
	private JFXTextField campoCPF;

	@FXML
	private JFXTextField campoNome;

	@FXML
	private JFXTextField campoTelefone;

	@FXML
	private Button botaoEditar;

	@FXML
	private Button botaoSalvar;

	@FXML
	private Button botaoCancelar;

	@FXML
	private Label labelStatus;

	@FXML
	void habilitarEdicao(ActionEvent event) {
		botaoSalvar.setDisable(false);
		campoNome.setEditable(true);
		campoTelefone.setEditable(true);
		campoCPF.setDisable(true);
	}

	@FXML
	void pesquisarPessoa(ActionEvent event) {
		if (campoCPF.getText().isEmpty()) {
			labelStatus.setText("Primeiro digite um CPF");
		} else {
			labelStatus.setText("");
			pessoa = new Pessoa();
			setPessoa(acoesPessoa.buscarPessoa(campoCPF.getText()));
			if (pessoa == null) {
				labelStatus.setText("Cadastro não encontrado");
			} else {
				campoNome.setText(pessoa.getNome());
				campoTelefone.setText(pessoa.getTelefone());
				labelStatus.setText("Cadastro localizado");
				botaoEditar.setDisable(false);
			}
		}

	}

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void validarCpf(KeyEvent event) {
		ValidarNumeros.validarCpf(campoCPF);
	}

	@FXML
	void salvarEdicao(ActionEvent event) {
		if(campoNome.getText().isEmpty() || campoTelefone.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			getPessoa().setNome(campoNome.getText());
			getPessoa().setTelefone(campoTelefone.getText());
			acoesPessoa.acoesPessoaController(pessoa, AcoesPessoa.ALTERAR_CADASTRO);
			labelStatus.setText("Cadastro alterado");
			campoCPF.setDisable(false);
			campoCPF.setText("");
			campoNome.setText("");
			campoTelefone.setText("");
			botaoSalvar.setDisable(true);
			botaoEditar.setDisable(true);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}

}
