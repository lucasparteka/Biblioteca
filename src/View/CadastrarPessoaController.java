package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Controller.AcoesPessoa;
import Model.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mask.ValidarNumeros;
import mask.ValidarCPF;
import mask.ValidarNome;

public class CadastrarPessoaController implements Initializable {

	private AcoesPessoa acoesPessoa;
	private Pessoa pessoa;

	public CadastrarPessoaController() {
		acoesPessoa = new AcoesPessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@FXML
	private JFXTextField campoNome;

	@FXML
	private JFXTextField campoCPF;

	@FXML
	private JFXTextField campoTelefone;

	@FXML
	private JFXTextField campoSobrenome;

	@FXML
	private Label labelStatus;

	@FXML
	private Button botaoCancelar;

	@FXML
	public void validarNumeros(KeyEvent event) {
		ValidarNumeros.validarCpf(campoCPF);
		ValidarNumeros.validarTelefone(campoTelefone);
	}

	@FXML
	public void validarLetras(KeyEvent keyEvent) {
		ValidarNome.validarTamanhoCampo(campoNome);
		ValidarNome.validarTamanhoCampo(campoSobrenome);
	}

	@FXML
	void cadastrarPessoa(ActionEvent event) {
		ValidarCPF validar = new ValidarCPF();

		if (campoCPF.getText().isEmpty() || campoSobrenome.getText().isEmpty() || campoNome.getText().isEmpty()
				|| campoTelefone.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			if (validar.isCPF(campoCPF.getText()) == false) {
				campoCPF.getStylesheets().add(
						CadastrarPessoaController.class.getResource("/style/destacaTextField.css").toExternalForm());
				labelStatus.setText("Preencha os campos corretamente");
			} else {
				campoCPF.getStylesheets().add(CadastrarPessoaController.class
						.getResource("/style/normalizaTextField.css").toExternalForm());
				if (campoTelefone.getText().length() < 13) {
					campoTelefone.getStylesheets().add(CadastrarPessoaController.class
							.getResource("/style/destacaTextField.css").toExternalForm());
					labelStatus.setText("Preencha os campos corretamente");
				} else {
					campoTelefone.getStylesheets().add(CadastrarPessoaController.class
							.getResource("/style/normalizaTextField.css").toExternalForm());
					acoesPessoa = new AcoesPessoa();
					if (acoesPessoa.verificarCadastro(campoCPF.getText()) == false) {
						pessoa = new Pessoa();
						getPessoa().setCpf(campoCPF.getText());
						getPessoa().setNome(campoNome.getText() + " " + campoSobrenome.getText());
						getPessoa().setTelefone(campoTelefone.getText());
						acoesPessoa.acoesPessoaController(pessoa, AcoesPessoa.INSERIR_CADASTRO);
						labelStatus.setText("Cadastrado com sucesso");
						campoCPF.setText("");
						campoSobrenome.setText("");
						campoNome.setText("");
						campoTelefone.setText("");
					} else {
						labelStatus.setText("Usuario ja cadastrado");
					}
				}

			}
		}
	}

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

}
