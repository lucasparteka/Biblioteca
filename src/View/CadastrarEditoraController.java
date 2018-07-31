package View;

import Controller.AcoesEditora;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lparteka
 */
public class CadastrarEditoraController implements Initializable {

    AcoesEditora cadEditora;

    @FXML
    private JFXTextField CampoNomeEditora;

    @FXML
    private JFXTextField campoID;

    @FXML
    private ToggleGroup nacionalidade;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Label labelStatus;

    public void somenteLetrasNome(KeyEvent keyEvent) {
        CampoNomeEditora.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                CampoNomeEditora.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
    }
    
    
    public void restrictNumbersOnly(KeyEvent keyEvent) {
        campoID.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                campoID.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    void cadastrarEditora(ActionEvent event) {

        if (campoID.getText().isEmpty() || CampoNomeEditora.getText().isEmpty()) {
            labelStatus.setText("Preencha todos os campos");
        } else {
            long idLong = Long.parseLong(campoID.getText());
            
            ToggleButton selecionado = (ToggleButton) nacionalidade.getSelectedToggle();
            cadEditora.realizarCadastro(CampoNomeEditora.getText(), selecionado.getText(), idLong);
            labelStatus.setText("Cadastrado com sucesso");
            campoID.setText("");
            CampoNomeEditora.setText("");
        }

    }

    @FXML
    void cancelarAcao(ActionEvent event) {
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadEditora = new AcoesEditora();
    }

}
