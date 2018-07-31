package View;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.AcoesPeriodico;
import Model.Periodico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InformacoesPeriodicoController implements Initializable{
	
	private Periodico periodico;
	private AcoesPeriodico cadPeriodico;
	
	@FXML
    private TextField campoID;

    @FXML
    private TextField campoTitulo;

    @FXML
    private TextField campoISSN;

    @FXML
    private TextField campoAno;

    @FXML
    private TextField campoVolume;

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
    void editarPeriodico(ActionEvent event) {

    }

    @FXML
    void pesquisarPeriodico(ActionEvent event) {
    	
    	long idLong = Long.parseLong(campoID.getText());
    	cadPeriodico = new AcoesPeriodico();
    	periodico = cadPeriodico.pesquisarPeriodicoPorId(idLong);
    	
    	if(periodico == null) {
    		labelStatus.setText("Periodico não encontrado");
    	} else {
    		labelStatus.setText("");
    		campoTitulo.setText(periodico.getTitulo());
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
