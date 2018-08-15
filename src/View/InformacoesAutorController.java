package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Controller.AcoesAutor;
import Model.Autor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InformacoesAutorController implements Initializable {

	private Autor autor;
	private AcoesAutor acoesAutor;

	public InformacoesAutorController() {
		acoesAutor = new AcoesAutor();
		autor = new Autor();
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@FXML
	private Button botaoCancelar;

	@FXML
	private Button botaoEditar;

	@FXML
	private Button botaoSalvar;

	@FXML
	private JFXTextField campoID;

	@FXML
	private TextField campoNome;

	@FXML
	private TextField campoSobrenome;

	@FXML
	private Label labelStatus;

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void habilitarEdicao(ActionEvent event) {
		campoID.setDisable(true);
		botaoSalvar.setDisable(false);
		campoNome.setEditable(true);
		campoSobrenome.setEditable(true);
	}

	@FXML
	void pesquisarAutor(ActionEvent event) {
		if (campoID.getText().isEmpty()) {
			labelStatus.setText("Digite um id");
		} else {
			labelStatus.setText("");
			this.setAutor(acoesAutor.pesquisarAutor(Long.parseLong(campoID.getText())));
			if (this.getAutor() == null) {
				labelStatus.setText("Autor não encontrado!");
			} else {
				labelStatus.setText("");
				campoNome.setText(this.getAutor().getNome());
				campoSobrenome.setText(this.getAutor().getSobreNome());
				botaoEditar.setDisable(false);
			}
		}
	}

	@FXML
	void salvarEdicao(ActionEvent event) {
		if (campoNome.getText().isEmpty() || campoSobrenome.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			this.getAutor().setNome(campoNome.getText());
			this.getAutor().setSobreNome(campoSobrenome.getText());
			acoesAutor.executarOperacao(autor, AcoesAutor.ALTERAR_CADASTRO);
			labelStatus.setText("Alterado com sucesso");
			campoNome.setText("");
			campoSobrenome.setText("");
			campoID.setText("");
			campoID.setDisable(false);
			campoNome.setEditable(false);
			campoSobrenome.setEditable(false);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
