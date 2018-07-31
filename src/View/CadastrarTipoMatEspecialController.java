package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lparteka
 */
public class CadastrarTipoMatEspecialController implements Initializable {

	@FXML
	private JFXTextField campoTipo;

	@FXML
	private JFXTextField campoID;

	@FXML
	private Label labelStatus;

	@FXML
	private Button botaoCancelar;

	@FXML
	void cadastrarMatEspecial(ActionEvent event) {

	}

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

}
