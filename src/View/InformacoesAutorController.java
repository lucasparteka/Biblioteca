package View;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.AcoesAutor;
import Model.Autor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InformacoesAutorController implements Initializable {

	Autor autor;
	AcoesAutor cadAutor;
	
	@FXML
	private TextField campoID;

	@FXML
	private Button botaoEditar;

	@FXML
	private Button botaoSalvar;

	@FXML
	private TextField campoNome;

	@FXML
	private TextField campoSobrenome;

	@FXML
	private Label labelStatus;

	@FXML
	void cancelarAcao(ActionEvent event) {

	}

	@FXML
	void habilitarEdicao(ActionEvent event) {

	}

	@FXML
	void pesquisarAutor(ActionEvent event) {
		
		long idLong = Long.parseLong(campoID.getText());
		cadAutor = new AcoesAutor();
		autor = cadAutor.pesquisar(idLong);
		
		if(autor == null) {
    		labelStatus.setText("Autor não encontrado!");
    	} else {
    		labelStatus.setText("");
    		campoNome.setText(autor.getNome());
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
