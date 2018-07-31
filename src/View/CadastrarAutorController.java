package View;

import Controller.AcoesAutor;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mask.ValidarNome;
import mask.ValidarNumeros;

/**
 * FXML Controller class
 *
 * @author lparteka
 */
public class CadastrarAutorController implements Initializable {

    private AcoesAutor cadastrarAutor;

    @FXML
    private JFXTextField campoNome;

    @FXML
    private JFXTextField campoSobreNome;

    @FXML
    private JFXTextField campoID;

    @FXML
    private Label labelStatus;

    @FXML
    private Button botaoCancelar;
    
    @FXML
    void restrictNumbersOnly(KeyEvent keyEvent) {
        ValidarNumeros validaId = new ValidarNumeros();
        validaId.validarQuatroDig(campoID);
    }

    @FXML
    void validarLetras(KeyEvent keyEvent) {
        ValidarNome validaNome = new ValidarNome();
        validaNome.validarNome(campoNome);
        validaNome.validarNome(campoSobreNome);

    }

    @FXML
    void cadastrarAutor(ActionEvent event) {

        if (campoID.getText().isEmpty() || campoNome.getText().isEmpty() || campoSobreNome.getText().isEmpty()) {
            labelStatus.setText("Preencha todos os campos");
        } else {
            long idLong = Long.parseLong(campoID.getText());
            cadastrarAutor.realizarCadastro(campoNome.getText(), campoSobreNome.getText(), idLong);
            labelStatus.setText("Cadastrado com sucesso");
            campoID.setText("");
            campoNome.setText("");
            campoSobreNome.setText("");
        }

    }

    @FXML
    void cancelarAcao(ActionEvent event) {
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadastrarAutor = new AcoesAutor();
        RequiredFieldValidator validator = new RequiredFieldValidator();
        campoID.getValidators().add(validator);
        validator.setMessage("Somente numeros!");

    }

}