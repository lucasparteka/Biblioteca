package View;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.AcoesMatEspecial;
import Model.MaterialEspecial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InformacoesMatEspecialController implements Initializable {
	
	MaterialEspecial matEspecial;
	AcoesMatEspecial acoesMatEspecial;
	
    @FXML
    private TextField campoTitulo;

    @FXML
    private TextField campoDescricao;

    @FXML
    private TextField campoTipo;

    @FXML
    private Button botaoSalvar;

    @FXML
    private TextField campoCodBarras;

    @FXML
    private TextField campoEstante;

    @FXML
    private TextField campoExemplares;

    @FXML
    private Button botaoEditar;

    @FXML
    private TextField campoDisponiveis;

    @FXML
    private Label labelStatus;

    @FXML
    void cancelarAcao(ActionEvent event) {

    }

    @FXML
    void editarMatEspecial(ActionEvent event) {

    }

    @FXML
    void pesquisarMatEspecial(ActionEvent event) {
    	
    	acoesMatEspecial = new AcoesMatEspecial();
    	matEspecial = new MaterialEspecial();
    	matEspecial = acoesMatEspecial.buscarMatEspecial(campoTitulo.getText());
    	
    	if(matEspecial == null) {
    		labelStatus.setText("Material especial não encontrado");
    	} else {
    		labelStatus.setText("");
    		campoTitulo.setText(matEspecial.getTitulo());
    		campoCodBarras.setText(matEspecial.getCodigoBarras());
    		campoDescricao.setText(matEspecial.getDescricao());
    		campoDisponiveis.setText(Integer.toString(matEspecial.getDisponiveis()));
    		campoEstante.setText(Integer.toString(matEspecial.getEstante()));
    		campoExemplares.setText(Integer.toString(matEspecial.getExemplares()));
    		campoTipo.setText(matEspecial.getTipo());
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
