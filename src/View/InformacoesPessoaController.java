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

	@FXML
	private JFXTextField campoCPF;

	@FXML
	private JFXTextField campoNome;

	@FXML
	private JFXTextField campoTelefone;

	@FXML
	private JFXTextField campoID;

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
		campoID.setDisable(false);
		campoNome.setDisable(false);
		campoTelefone.setDisable(false);
	}

	@FXML
	void pesquisarPessoa(ActionEvent event) {
		if (campoCPF.getText().isEmpty()) {
			labelStatus.setText("Digite um CPF");
		} else {
			labelStatus.setText("");
			acoesPessoa = new AcoesPessoa();
			pessoa = new Pessoa();
			pessoa = acoesPessoa.buscarPessoa(campoCPF.getText());
			if (pessoa == null) {
				labelStatus.setText("Cadastro não encontrado");
			} else {
				String idString = Long.toString(pessoa.getId());
				campoID.setText(idString);
				campoNome.setText(pessoa.getNome());
				campoTelefone.setText(pessoa.getTelefone());
				labelStatus.setText("Cadastro localizado");
				botaoEditar.setDisable(false);
				campoCPF.setDisable(true);
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

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		botaoSalvar.setDisable(true);
		botaoEditar.setDisable(true);
		campoNome.setDisable(true);
		campoID.setDisable(true);
		campoTelefone.setDisable(true);
	}

}
