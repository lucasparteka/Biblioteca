package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FirstScreenController implements Initializable {

	@FXML
	private StackPane rootPane;

	@FXML
	void cadastrar(ActionEvent event) {
		makeFadeOut();
	}

	@FXML
	void consultas(ActionEvent event) {

	}

	@FXML
	void emprestimos(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootPane.setOpacity(0);
		makeFadeTransition();
	}
	
	private void makeFadeTransition() {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(200));
		fadeTransition.setNode(rootPane);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();
		
	}

	private void makeFadeOut() {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(200));
		fadeTransition.setNode(rootPane);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);

		fadeTransition.setOnFinished((ActionEvent event) -> {
			abrirTelaCadastrar();
		});
		fadeTransition.play();

	}

	private void abrirTelaCadastrar() {
		try {
			Parent secondView;
			secondView = (StackPane) FXMLLoader.load(getClass().getResource("TelaCadastros.fxml"));
			Scene newScene = new Scene(secondView);
			Stage curStage = (Stage) rootPane.getScene().getWindow();
			curStage.setScene(newScene);
			
		} catch (IOException ex) {
			Logger.getLogger(FirstScreenController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
