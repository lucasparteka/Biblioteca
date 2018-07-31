package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Controller.AcoesMatEspecial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CadastrarMatEspecialController implements Initializable {

    private AcoesMatEspecial cadMatEspecial;

    @FXML
    private JFXTextField campoID;

    @FXML
    private JFXTextField campoCodBarras;

    @FXML
    private JFXTextField campoEstante;

    @FXML
    private JFXTextField campoExemplares;

    @FXML
    private JFXTextField campoDisponiveis;

    @FXML
    private JFXTextField campoTitulo;

    @FXML
    private JFXTextField campoDescricao;

    @FXML
    private JFXTextField campoTipo;

    @FXML
    private Label labelStatus;

    @FXML
    private Button botaoCancelar;
    
    public void somenteNumeros(KeyEvent keyEvent) {
        campoID.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                campoID.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        campoCodBarras.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                campoCodBarras.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        campoDisponiveis.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                campoDisponiveis.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        campoEstante.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                campoEstante.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        campoExemplares.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                campoExemplares.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    void cadastrarMatEspecial(ActionEvent event) {

        if (campoCodBarras.getText().isEmpty() || campoDescricao.getText().isEmpty()
                || campoDisponiveis.getText().isEmpty() || campoEstante.getText().isEmpty()
                || campoExemplares.getText().isEmpty() || campoID.getText().isEmpty() || campoTipo.getText().isEmpty()
                || campoTitulo.getText().isEmpty()) {
            labelStatus.setText("Preencha todos os campos");
        } else {
            Long idLong = Long.parseLong(campoID.getText());
            int estanteInt = Integer.parseInt(campoEstante.getText());
            int exemplaresInt = Integer.parseInt(campoExemplares.getText());
            int disponiveisInt = Integer.parseInt(campoDisponiveis.getText());

            cadMatEspecial.realizarCadastro(idLong, campoCodBarras.getText(), estanteInt, exemplaresInt, disponiveisInt,
                    campoTitulo.getText(), campoDescricao.getText(), campoTipo.getText());
            labelStatus.setText("cadastrado com sucesso");
            campoCodBarras.setText(null);
            campoDescricao.setText(null);
            campoDisponiveis.setText(null);
            campoEstante.setText(null);
            campoExemplares.setText(null);
            campoID.setText(null);
            campoTipo.setText(null);
            campoTitulo.setText(null);
        }

    }

    @FXML
    void cancelarAcao(ActionEvent event) {
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadMatEspecial = new AcoesMatEspecial();
    }

}
