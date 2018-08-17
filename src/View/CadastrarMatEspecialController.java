package View;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import Controller.AcoesMatEspecial;
import Model.MaterialEspecial;
import enums.TipoMaterialEspecial;
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
	private MaterialEspecial materialEspecial;

	public CadastrarMatEspecialController() {
		acoesMatEspecial = new AcoesMatEspecial();
	}

	public MaterialEspecial getMaterialEspecial() {
		return materialEspecial;
	}

	public void setMaterialEspecial(MaterialEspecial materialEspecial) {
		this.materialEspecial = materialEspecial;
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
		materialEspecial = new MaterialEspecial();
		ToggleButton selecionado = (ToggleButton) tipomaterial.getSelectedToggle();
		if (campoCodBarras.getText().isEmpty() || campoDescricao.getText().isEmpty()
				|| campoDisponiveis.getText().isEmpty() || campoEstante.getText().isEmpty()
				|| campoExemplares.getText().isEmpty() || selecionado.getText().isEmpty()
				|| campoTitulo.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			if (selecionado.getText().equals("CD")) {
				getMaterialEspecial().setIdTipo(TipoMaterialEspecial.CD.idTipoEscolhido);
				getMaterialEspecial().setTipo(TipoMaterialEspecial.CD.nomeTipoEscolhido);
			} else if (selecionado.getText().equals("DVD")) {
				getMaterialEspecial().setIdTipo(TipoMaterialEspecial.DVD.idTipoEscolhido);
				getMaterialEspecial().setTipo(TipoMaterialEspecial.DVD.nomeTipoEscolhido);
			} else if (selecionado.getText().equals("FITA")) {
				getMaterialEspecial().setIdTipo(TipoMaterialEspecial.FITA.idTipoEscolhido);
				getMaterialEspecial().setTipo(TipoMaterialEspecial.FITA.nomeTipoEscolhido);
			}
			getMaterialEspecial().setCodigoBarras(campoCodBarras.getText());
			getMaterialEspecial().setDescricao(campoDescricao.getText());
			getMaterialEspecial().setDisponiveis(Integer.parseInt(campoDisponiveis.getText()));
			getMaterialEspecial().setEstante(Integer.parseInt(campoEstante.getText()));
			getMaterialEspecial().setExemplares(Integer.parseInt(campoExemplares.getText()));
			getMaterialEspecial().setTitulo(campoTitulo.getText());

			acoesMatEspecial.acoesMatEspecialController(materialEspecial, AcoesMatEspecial.INSERIR_CADASTRO);
			labelStatus.setText("Cadastrado com sucesso");
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
