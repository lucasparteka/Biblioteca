package View;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import Controller.AcoesMatEspecial;
import Model.MaterialEspecial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InformacoesMatEspecialController implements Initializable {

	private MaterialEspecial matEspecial;
	private AcoesMatEspecial acoesMatEspecial;

	@FXML
	private JFXTextField campoID;

	@FXML
	private JFXTextField campoTitulo;

	@FXML
	private JFXTextField campoEstante;

	@FXML
	private JFXTextField campoExemplares;

	@FXML
	private JFXTextField campoDisponiveis;

	@FXML
	private JFXTextField campoCodBarras;

	@FXML
	private JFXTextField campoDescricao;

	@FXML
	private Button botaoSalvar;

	@FXML
	private Button botaoEditar;

	@FXML
	private Button botaoCancelar;

	@FXML
	private Label labelStatus;

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void editarMatEspecial(ActionEvent event) {

	}

	@FXML
	void pesquisarMatEspecial(ActionEvent event) {
		if (campoID.getText().isEmpty()) {
			labelStatus.setText("Digite um id");
		} else {
			labelStatus.setText("");
			acoesMatEspecial = new AcoesMatEspecial();
			matEspecial = new MaterialEspecial();
			matEspecial = acoesMatEspecial.buscarMatEspecial(Long.parseLong(campoID.getText()));

			if (matEspecial == null) {
				labelStatus.setText("Material especial não encontrado");
			} else {
				labelStatus.setText("");
				campoTitulo.setText(matEspecial.getTitulo());
				campoCodBarras.setText(matEspecial.getCodigoBarras());
				campoDescricao.setText(matEspecial.getDescricao());
				campoDisponiveis.setText(Integer.toString(matEspecial.getDisponiveis()));
				campoEstante.setText(Integer.toString(matEspecial.getEstante()));
				campoExemplares.setText(Integer.toString(matEspecial.getExemplares()));
			}

		}

	}

	@FXML
	void salvarEdicao(ActionEvent event) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
