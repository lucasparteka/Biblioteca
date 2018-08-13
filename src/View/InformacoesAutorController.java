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

	}

	@FXML
	void pesquisarAutor(ActionEvent event) {
		if (campoID.getText().isEmpty()) {
			labelStatus.setText("Digite um id");
		} else {
			labelStatus.setText("");
			acoesAutor = new AcoesAutor();
			autor = new Autor();
			autor = acoesAutor.pesquisarAutor(Long.parseLong(campoID.getText()));
			if (autor == null) {
				labelStatus.setText("Autor não encontrado!");
			} else {
				labelStatus.setText("");
				campoNome.setText(autor.getNome());
				campoSobrenome.setText(autor.getSobreNome());
			}
		}

	}

	@FXML
	void salvarEdicao(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
