package View;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import Controller.AcoesPeriodico;
import Model.Periodico;
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
	private Periodico periodico;

	public Periodico getPeriodico() {
		return periodico;
	}

	public void setPeriodico(Periodico periodico) {
		this.periodico = periodico;
	}

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

		periodico = new Periodico();
		acoesPeriodico = new AcoesPeriodico();
		if (campoCodBarras.getText().isEmpty() || campoDisponiveis.getText().isEmpty()
				|| campoEstante.getText().isEmpty() || campoExemplares.getText().isEmpty()
				|| campoISSN.getText().isEmpty() || campoTitulo.getText().isEmpty()
				|| campoVolume.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			double x = campoAno.getValue();
			int anoInt = (int) x;
			getPeriodico().setAno(anoInt);
			getPeriodico().setCodigoBarras(campoCodBarras.getText());
			getPeriodico().setDisponiveis(Integer.parseInt(campoDisponiveis.getText()));
			getPeriodico().setEstante(Integer.parseInt(campoEstante.getText()));
			getPeriodico().setExemplares(Integer.parseInt(campoExemplares.getText()));
			getPeriodico().setIssn(Integer.parseInt(campoISSN.getText()));
			getPeriodico().setTitulo(campoTitulo.getText());
			getPeriodico().setVolume(Integer.parseInt(campoVolume.getText()));
			
			acoesPeriodico.acoesPeriodicoController(getPeriodico(), AcoesPeriodico.INSERIR_CADASTRO);

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
