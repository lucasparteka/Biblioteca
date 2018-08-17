package View;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import Controller.AcoesPeriodico;
import Model.Periodico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InformacoesPeriodicoController implements Initializable {

	private Periodico periodico;
	private AcoesPeriodico acoesPeriodico;

	public Periodico getPeriodico() {
		return periodico;
	}

	public void setPeriodico(Periodico periodico) {
		this.periodico = periodico;
	}

	@FXML
	private JFXTextField campoID;

	@FXML
	private JFXTextField campoTitulo;

	@FXML
	private JFXTextField campoCodBarras;

	@FXML
	private JFXTextField campoEstante;

	@FXML
	private JFXTextField campoExemplares;

	@FXML
	private JFXTextField campoDisponiveis;

	@FXML
	private JFXTextField campoISSN;

	@FXML
	private JFXTextField campoVolume;

	@FXML
	private JFXTextField campoAno;

	@FXML
	private Button botaoSalvar;

	@FXML
	private Button botaoEditar;

	@FXML
	private Button botaoCancelar;

	@FXML
	private Label labelStatus;

	@FXML
	void pesquisarPeriodico(ActionEvent event) {
		if (campoID.getText().isEmpty()) {
			labelStatus.setText("Digite um id");
		} else {
			labelStatus.setText("");
			acoesPeriodico = new AcoesPeriodico();
			periodico = new Periodico();
			setPeriodico(acoesPeriodico.pesquisarPeriodico(Long.parseLong(campoID.getText())));
			if (periodico == null) {
				labelStatus.setText("Periodico não encontrado");
			} else {
				labelStatus.setText("Periodico localizado");
				campoTitulo.setText(periodico.getTitulo());
				campoAno.setText(Integer.toString(periodico.getAno()));
				campoCodBarras.setText(periodico.getCodigoBarras());
				campoDisponiveis.setText(Integer.toString(periodico.getDisponiveis()));
				campoEstante.setText(Integer.toString(periodico.getEstante()));
				campoExemplares.setText(Integer.toString(periodico.getExemplares()));
				campoISSN.setText(Integer.toString(periodico.getIssn()));
				campoVolume.setText(Integer.toString(periodico.getVolume()));
				botaoEditar.setDisable(false);
			}
		}

	}

	@FXML
	void editarPeriodico(ActionEvent event) {
		botaoSalvar.setDisable(false);
		campoID.setDisable(true);
		campoAno.setEditable(true);
		campoCodBarras.setEditable(true);
		campoEstante.setEditable(true);
		campoExemplares.setEditable(true);
		campoISSN.setEditable(true);
		campoTitulo.setEditable(true);
		campoVolume.setEditable(true);
		campoDisponiveis.setEditable(true);
	}

	@FXML
	void salvarEdicao(ActionEvent event) {
		if (campoCodBarras.getText().isEmpty() || campoDisponiveis.getText().isEmpty()
				|| campoEstante.getText().isEmpty() || campoExemplares.getText().isEmpty()
				|| campoISSN.getText().isEmpty() || campoTitulo.getText().isEmpty()
				|| campoVolume.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			getPeriodico().setAno(Integer.parseInt(campoAno.getText()));
			getPeriodico().setCodigoBarras(campoCodBarras.getText());
			getPeriodico().setDisponiveis(Integer.parseInt(campoDisponiveis.getText()));
			getPeriodico().setEstante(Integer.parseInt(campoEstante.getText()));
			getPeriodico().setExemplares(Integer.parseInt(campoExemplares.getText()));
			getPeriodico().setIssn(Integer.parseInt(campoISSN.getText()));
			getPeriodico().setTitulo(campoTitulo.getText());
			getPeriodico().setVolume(Integer.parseInt(campoVolume.getText()));
			labelStatus.setText("Alterado com sucesso");
			campoAno.setText("");
			campoCodBarras.setText("");
			campoDisponiveis.setText("");
			campoEstante.setText("");
			campoExemplares.setText("");
			campoID.setText("");
			campoISSN.setText("");
			campoTitulo.setText("");
			campoVolume.setText("");
			botaoEditar.setDisable(true);
			botaoCancelar.setDisable(true);
			acoesPeriodico.acoesPeriodicoController(getPeriodico(), AcoesPeriodico.ALTERAR_CADASTRO);
		}
	}

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
