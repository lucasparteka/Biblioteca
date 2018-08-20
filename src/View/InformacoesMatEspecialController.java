package View;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import Controller.AcoesMatEspecial;
import Model.MaterialEspecial;
import enums.EnumTipoMatEspecial;
//import enums.TipoMaterialEspecial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class InformacoesMatEspecialController implements Initializable {

	private MaterialEspecial materialEspecial;
	private AcoesMatEspecial acoesMatEspecial;

	public InformacoesMatEspecialController() {
		acoesMatEspecial = new AcoesMatEspecial();
	}

	public MaterialEspecial getMaterialEspecial() {
		return materialEspecial;
	}

	public void setMaterialEspecial(MaterialEspecial materialEspecial) {
		this.materialEspecial = materialEspecial;
	}

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
	private JFXToggleButton toggleCD;

	@FXML
	private ToggleGroup grupoToggle;

	@FXML
	private JFXToggleButton toggleDVD;

	@FXML
	private JFXToggleButton toggleFITA;

	@FXML
	void pesquisarMatEspecial(ActionEvent event) throws Exception {
		if (campoID.getText().isEmpty()) {
			labelStatus.setText("Digite um id");
		} else {
			labelStatus.setText("");
			materialEspecial = new MaterialEspecial();
			materialEspecial = acoesMatEspecial.buscarMatEspecial(Long.parseLong(campoID.getText()));

			if (materialEspecial == null) {
				labelStatus.setText("Material especial não encontrado");
			} else {
				labelStatus.setText("Cadastro localizado");
				campoTitulo.setText(getMaterialEspecial().getTitulo());
				campoCodBarras.setText(getMaterialEspecial().getCodigoBarras());
				campoDescricao.setText(getMaterialEspecial().getDescricao());
				campoDisponiveis.setText(Integer.toString(getMaterialEspecial().getDisponiveis()));
				campoEstante.setText(Integer.toString(getMaterialEspecial().getEstante()));
				campoExemplares.setText(Integer.toString(getMaterialEspecial().getExemplares()));
				switch (getMaterialEspecial().getTipo()) {
				case "CD":
					toggleCD.setSelected(true);
					break;
				case "DVD":
					toggleDVD.setSelected(true);
					break;
				case "FITA":
					toggleFITA.setSelected(true);
					break;
				}
				botaoEditar.setDisable(false);
			}
		}
	}

	@FXML
	void editarMatEspecial(ActionEvent event) {
		campoID.setDisable(true);
		campoCodBarras.setEditable(true);
		campoDescricao.setEditable(true);
		campoDisponiveis.setEditable(true);
		campoEstante.setEditable(true);
		campoExemplares.setEditable(true);
		campoTitulo.setEditable(true);
		botaoSalvar.setDisable(false);
		toggleCD.setDisable(false);
		toggleDVD.setDisable(false);
		toggleFITA.setDisable(false);
	}

	@FXML
	void salvarEdicao(ActionEvent event) {

		ToggleButton selecionado = (ToggleButton) grupoToggle.getSelectedToggle();
		getMaterialEspecial().setCodigoBarras(campoCodBarras.getText());
		getMaterialEspecial().setDescricao(campoDescricao.getText());
		getMaterialEspecial().setDisponiveis(Integer.parseInt(campoDisponiveis.getText()));
		getMaterialEspecial().setEstante(Integer.parseInt(campoEstante.getText()));
		getMaterialEspecial().setExemplares(Integer.parseInt(campoExemplares.getText()));
		getMaterialEspecial().setTitulo(campoTitulo.getText());
		if (selecionado.getText().equals("CD")) {
			getMaterialEspecial().setIdTipo(EnumTipoMatEspecial.CD.getIdTabelaMaterialEscolhido());
			getMaterialEspecial().setTipo(EnumTipoMatEspecial.CD.getTipoMaterialEscolhido());
		} else if (selecionado.getText().equals("DVD")) {
			getMaterialEspecial().setIdTipo(EnumTipoMatEspecial.DVD.getIdTabelaMaterialEscolhido());
			getMaterialEspecial().setTipo(EnumTipoMatEspecial.DVD.getTipoMaterialEscolhido());
		} else if (selecionado.getText().equals("FITA")) {
			getMaterialEspecial().setIdTipo(EnumTipoMatEspecial.FITA.getIdTabelaMaterialEscolhido());
			getMaterialEspecial().setTipo(EnumTipoMatEspecial.FITA.getTipoMaterialEscolhido());
		}
		
		labelStatus.setText("Alterado com sucesso");
		campoCodBarras.setText("");
		campoDescricao.setText("");
		campoDisponiveis.setText("");
		campoEstante.setText("");
		campoExemplares.setText("");
		campoTitulo.setText("");
		campoID.setText("");
		campoID.setDisable(false);
		botaoSalvar.setDisable(true);
		botaoEditar.setDisable(true);
		toggleCD.setSelected(false);
		toggleDVD.setSelected(false);
		toggleFITA.setSelected(false);
		toggleCD.setDisable(true);
		toggleDVD.setDisable(true);
		toggleFITA.setDisable(true);
		
		acoesMatEspecial.acoesMatEspecialController(materialEspecial, AcoesMatEspecial.ALTERAR_CADASTRO);
	}

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
