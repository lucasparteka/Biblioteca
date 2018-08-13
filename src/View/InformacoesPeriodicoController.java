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

public class InformacoesPeriodicoController implements Initializable{
	
	private Periodico periodico;
	private AcoesPeriodico acoesPeriodico;
	
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
    private Label labelStatus;

    @FXML
    void cancelarAcao(ActionEvent event) {

    }

    @FXML
    void editarPeriodico(ActionEvent event) {

    }

    @FXML
    void pesquisarPeriodico(ActionEvent event) {
    	
    	acoesPeriodico = new AcoesPeriodico();
    	periodico = acoesPeriodico.pesquisarPeriodico(campoTitulo.getText());
    	
    	if(periodico == null) {
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
