package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Controller.AcoesPessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mask.ValidarNumeros;
import mask.ValidarNome;

/**
 * FXML Controller class
 *
 * @author lparteka
 */
public class CadastrarPessoaController implements Initializable {

    private AcoesPessoa cadastrarPessoa;

    @FXML
    private JFXTextField CampoNome;

    @FXML
    private JFXTextField CampoCPF;

    @FXML
    private JFXTextField CampoTelefone;

    @FXML
    private JFXTextField CampoID;

    @FXML
    private Label labelStatus;

    @FXML
    private Button botaoCancelar;

    @FXML
    public void validarNumeros(KeyEvent event) {
        ValidarNumeros validaNumeros = new ValidarNumeros();
        validaNumeros.validarCpf(CampoCPF);
        validaNumeros.validarTelefone(CampoTelefone);
        validaNumeros.validarQuatroDig(CampoID);

    }

    @FXML
    public void validarLetras(KeyEvent keyEvent) {
        ValidarNome validaNome = new ValidarNome();
        validaNome.validarNome(CampoNome);

    }

    @FXML
    void cadastrarPessoa(ActionEvent event) {

        if (CampoCPF.getText().isEmpty() || CampoID.getText().isEmpty() || CampoNome.getText().isEmpty() || CampoTelefone.getText().isEmpty()) {
            labelStatus.setText("Preencha todos os campos");
        } else {
            String cpfString = CampoCPF.getText();
            int qtdCaracteres = cpfString.length();
            if (qtdCaracteres < 14) {
                CampoCPF.getStylesheets().add(CadastrarPessoaController.class.getResource("/style/edit_TextField.css").toExternalForm());
                labelStatus.setText("Preencha os campos corretamente");
            } else {
                CampoCPF.getStylesheets().add(CadastrarPessoaController.class.getResource("/style/edit_TextField_1.css").toExternalForm());
                long idLong = Long.parseLong(CampoID.getText());
                cadastrarPessoa.realizarCadastro(idLong, CampoNome.getText(), CampoTelefone.getText(), CampoCPF.getText());
                labelStatus.setText("Cadastrado com sucesso");
                CampoCPF.setText("");
                CampoID.setText("");
                CampoNome.setText("");
                CampoTelefone.setText("");
            }

        }

    }

    @FXML
    void cancelarAcao(ActionEvent event) {
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadastrarPessoa = new AcoesPessoa();
    }

}
