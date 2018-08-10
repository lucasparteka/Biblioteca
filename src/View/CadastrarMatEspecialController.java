package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Controller.AcoesMatEspecial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mask.ValidarNumeros;

public class CadastrarMatEspecialController implements Initializable {

	private AcoesMatEspecial acoesMatEspecial;

	@FXML
	private JFXTextField campoCodBarras;

	@FXML
	private JFXTextField campoEstante;

	@FXML
	private JFXTextField campoExemplares;

	@FXML
	private JFXTextField campoDisponiveis;

	@FXML
	private JFXTextField campoTitulo;

	@FXML
	private JFXTextField campoDescricao;

	@FXML
	private ToggleGroup tipomaterial;

	@FXML
	private Label labelStatus;

	@FXML
	private Button botaoCancelar;

	public void somenteNumeros(KeyEvent keyEvent) {
		ValidarNumeros.validarQuatroDig(campoDisponiveis);
		ValidarNumeros.validarQuatroDig(campoEstante);
		ValidarNumeros.validarQuatroDig(campoExemplares);
		ValidarNumeros.validarOitoDig(campoCodBarras);
	}

	@FXML
	void cadastrarMatEspecial(ActionEvent event) {

		int idTipoMaterial = 0;
		ToggleButton selecionado = (ToggleButton) tipomaterial.getSelectedToggle();
		if(selecionado.getText().equals("CD")) {
			idTipoMaterial = 1;
		} else if (selecionado.getText().equals("DVD")) {
			idTipoMaterial = 2;
		} else if (selecionado.getText().equals("FITA")) {
			idTipoMaterial = 3;
		}
		
		if (campoCodBarras.getText().isEmpty() || campoDescricao.getText().isEmpty()
				|| campoDisponiveis.getText().isEmpty() || campoEstante.getText().isEmpty()
				|| campoExemplares.getText().isEmpty() || selecionado.getText().isEmpty()
				|| campoTitulo.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			int estanteInt = Integer.parseInt(campoEstante.getText());
			int exemplaresInt = Integer.parseInt(campoExemplares.getText());
			int disponiveisInt = Integer.parseInt(campoDisponiveis.getText());

			acoesMatEspecial.realizarCadastro(campoCodBarras.getText(), estanteInt, exemplaresInt, disponiveisInt,
					campoTitulo.getText(), campoDescricao.getText(), idTipoMaterial);
			labelStatus.setText("cadastrado com sucesso");
			campoCodBarras.setText("");
			campoDescricao.setText("");
			campoDisponiveis.setText("");
			campoEstante.setText("");
			campoExemplares.setText("");
			campoTitulo.setText("");
		}

	}

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		acoesMatEspecial = new AcoesMatEspecial();
	}

}
