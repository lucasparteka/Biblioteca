package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;

import Controller.AcoesPeriodico;
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
public class CadastrarPeriodicoController implements Initializable {

	private AcoesPeriodico acoesPeriodico;

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
	private JFXTextField campoISSN;

	@FXML
	private JFXTextField campoVolume;

	@FXML
	private JFXSlider campoAno;

	@FXML
	private Label labelStatus;

	@FXML
	private Button botaoCancelar;

	public void somenteNumeros(KeyEvent keyEvent) {
		ValidarNumeros.validarQuatroDig(campoDisponiveis);
		ValidarNumeros.validarQuatroDig(campoEstante);
		ValidarNumeros.validarQuatroDig(campoExemplares);
		ValidarNumeros.validarQuatroDig(campoVolume);
		ValidarNumeros.validarOitoDig(campoCodBarras);
		ValidarNumeros.validarOitoDig(campoISSN);
	}

	@FXML
	void cadastrarPeriodico(ActionEvent event) {

		if (campoCodBarras.getText().isEmpty() || campoDisponiveis.getText().isEmpty()
				|| campoEstante.getText().isEmpty() || campoExemplares.getText().isEmpty()
				|| campoISSN.getText().isEmpty() || campoTitulo.getText().isEmpty()
				|| campoVolume.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			int estanteInt = Integer.parseInt(campoEstante.getText());
			int exemplaresInt = Integer.parseInt(campoExemplares.getText());
			int disponiveisInt = Integer.parseInt(campoDisponiveis.getText());
			int issnInt = Integer.parseInt(campoISSN.getText());
			int volumeInt = Integer.parseInt(campoVolume.getText());
			double x = campoAno.getValue();
			int anoInt = (int) x;

			acoesPeriodico.realizarCadastro(campoCodBarras.getText(), estanteInt, exemplaresInt, disponiveisInt,
					campoTitulo.getText(), issnInt, anoInt, volumeInt);

			labelStatus.setText("Cadastrado com sucesso");
			campoCodBarras.setText("");
			campoDisponiveis.setText("");
			campoEstante.setText("");
			campoExemplares.setText("");
			campoISSN.setText("");
			campoTitulo.setText("");
			campoVolume.setText("");
		}
	}

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		acoesPeriodico = new AcoesPeriodico();
	}

}
