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

    AcoesEditora acoesEditora;

    @FXML
    private JFXTextField campoNomeEditora;

    @FXML
    private ToggleGroup nacionalidade;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Label labelStatus;

    @FXML
    void cadastrarEditora(ActionEvent event) {

        if (campoNomeEditora.getText().isEmpty()) {
            labelStatus.setText("Preencha todos os campos");
        } else {
            ToggleButton selecionado = (ToggleButton) nacionalidade.getSelectedToggle();
            acoesEditora.realizarCadastro(campoNomeEditora.getText(), selecionado.getText());
            labelStatus.setText("Cadastrado com sucesso");
            campoNomeEditora.setText("");
        }

    }

    @FXML
    void cancelarAcao(ActionEvent event) {
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acoesEditora = new AcoesEditora();
    }

}
