package View;

import Controller.AcoesLivro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mask.ValidarNumeros;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.input.KeyEvent;

public class CadastrarLivroController implements Initializable {

    static AcoesLivro cadastrarLivro;

    @FXML
    private JFXTextField campoID;

    @FXML
    private JFXTextField campoCodBarras;

    @FXML
    private JFXTextField campoEstante;

    @FXML
    private JFXTextField campoExemplares;

    @FXML
    private JFXTextField campoTitulo;

    @FXML
    private JFXTextField campoDisponiveis;

    @FXML
    private JFXTextField campoISBN;

    @FXML
    private JFXTextField campoAno;

    @FXML
    private JFXTextField campoVolume;

    @FXML
    private JFXTextField campoEdicao;

    @FXML
    private JFXTextField campoEditora;

    @FXML
    private JFXTextField campoNomeAutor;

    @FXML
    private Label labelStatus;

    @FXML
    private Button botaoCancelar;

    public void somenteNumeros(KeyEvent keyEvent) {
        ValidarNumeros validar = new ValidarNumeros();
        validar.validarQuatroDig(campoID);
        validar.validarQuatroDig(campoAno);
        validar.validarOitoDig(campoCodBarras);
        validar.validarQuatroDig(campoDisponiveis);
        validar.validarQuatroDig(campoEdicao);
        validar.validarQuatroDig(campoEstante);
        validar.validarQuatroDig(campoExemplares);
        validar.validarOitoDig(campoISBN);
        validar.validarQuatroDig(campoVolume);
    }
    
    @FXML
    void cadastrarLivro(ActionEvent event) {

        if (campoAno.getText().isEmpty() || campoCodBarras.getText().isEmpty() || campoDisponiveis.getText().isEmpty()
                || campoEdicao.getText().isEmpty() || campoEditora.getText().isEmpty()
                || campoEstante.getText().isEmpty() || campoExemplares.getText().isEmpty()
                || campoID.getText().isEmpty() || campoISBN.getText().isEmpty() || campoNomeAutor.getText().isEmpty()
                || campoTitulo.getText().isEmpty() || campoVolume.getText().isEmpty()) {
            labelStatus.setText("Preencha todos os campos");
        } else {
            Long idLong = Long.parseLong(campoID.getText());
            int estanteInt = Integer.parseInt(campoEstante.getText());
            int exemplaresInt = Integer.parseInt(campoExemplares.getText());
            int disponiveisInt = Integer.parseInt(campoDisponiveis.getText());
            int isbnInt = Integer.parseInt(campoISBN.getText());
            int anoInt = Integer.parseInt(campoAno.getText());
            int volumeInt = Integer.parseInt(campoVolume.getText());
            int edicaoInt = Integer.parseInt(campoEdicao.getText());

            cadastrarLivro.realizarCadastro(idLong, campoCodBarras.getText(), estanteInt, exemplaresInt, disponiveisInt,
                    campoTitulo.getText(), isbnInt, anoInt, volumeInt, edicaoInt, campoEditora.getText());
            labelStatus.setText("Cadastrado com sucesso");
            campoAno.setText("");
            campoCodBarras.setText("");
            campoDisponiveis.setText("");
            campoEdicao.setText("");
            campoEditora.setText("");
            campoEstante.setText("");
            campoExemplares.setText("");
            campoID.setText("");
            campoISBN.setText("");
            campoNomeAutor.setText("");
            campoTitulo.setText("");
            campoVolume.setText("");
        }

    }

    @FXML
    void cancelarAcao(ActionEvent event) {
        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void localizarAutor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(TabelaLivrosController.class.getResource("TabelaAutores.fxml"));
        Parent cadastro = loader.load();
        TabelaAutoresController controller = loader.getController();
        Stage dialog = new Stage();
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setScene(new Scene(cadastro));
        dialog.showAndWait();

        if (controller.getAutorSelecionado() != null) {
            campoNomeAutor.setText(controller.getAutorSelecionado().getNome());
        }
    }

    @FXML
    void localizarEditora(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(TabelaEditoraController.class.getResource("TabelaEditora.fxml"));
        Parent cadastro = loader.load();
        TabelaEditoraController controller = loader.getController();
        Stage dialog = new Stage();
        dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setScene(new Scene(cadastro));
        dialog.showAndWait();

        if (controller.getEditora() != null) {
            campoEditora.setText(controller.getEditora().getNome());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadastrarLivro = new AcoesLivro();
    }

}
