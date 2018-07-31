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

public class TelaCadastrosController implements Initializable{
	
	@FXML
    private StackPane rootPane;

    @FXML
    void cadastrarAutor(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarAutor.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Novo Autor");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void cadastrarEditora(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarEditora.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Nova editora");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void cadastrarLivro(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarLivro.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Novo livro");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void cadastrarMatEspecial(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarMatEspecial.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Novo material especial");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void cadastrarPeriodico(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarPeriodico.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Novo periodico");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void cadastrarPessoa(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarPessoa.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Novo usuario");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }
    
    @FXML
    void voltarInicio(ActionEvent event) {
    	efeitoFade();
    }
    
    public void efeitoFade() {
    	
    	FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(200));
		fadeTransition.setNode(rootPane);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);

		fadeTransition.setOnFinished((ActionEvent event) -> {
			abrirTelaInicio();
		});
		fadeTransition.play();
    	
    }
    
    private void abrirTelaInicio() {
		try {
			Parent secondView;
			secondView = (StackPane) FXMLLoader.load(getClass().getResource("FirstScreen.fxml"));
			Scene newScene = new Scene(secondView);
			Stage curStage = (Stage) rootPane.getScene().getWindow();
			curStage.setScene(newScene);
			
		} catch (IOException ex) {
			Logger.getLogger(FirstScreenController.class.getName()).log(Level.SEVERE, null, ex);
		}

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

}
