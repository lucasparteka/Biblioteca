package View;

import Controller.AcoesLivro;
import Model.Livro;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lparteka
 */
public class InformacoesLivroController implements Initializable {

    AcoesLivro cadastrarLivro;

    @FXML
    private TextField campoTitulo;

    @FXML
    private TextField campoISBN;

    @FXML
    private TextField campoAno;

    @FXML
    private TextField campoVolume;

    @FXML
    private TextField campoEdicao;

    @FXML
    private TextField campoEditora;

    @FXML
    private TextField campoID;

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
    private Button botaoSalvar;


    @FXML
    void cancelarAcao(ActionEvent event) {

    }

    @FXML
    void editarLivro(ActionEvent event) {
        botaoSalvar.setDisable(false);
    }

    @FXML
    void pesquisarLivro(ActionEvent event) {

        Long IdLong = Long.parseLong(campoID.getText());
        Livro livro = cadastrarLivro.pequisar(IdLong);

        if(livro == null) {
        	JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com esse id");
        } else {
        	String edicaoString = Integer.toString(livro.getEdicao());
            String volumeString = Integer.toString(livro.getVolume());
            String anoString = Integer.toString(livro.getAno());
            String dispString = Integer.toString(livro.getDisponiveis());
            String isbnString = Integer.toString(livro.getISBN());
            String estanteString = Integer.toString(livro.getEstante());
            String exemplaresString = Integer.toString(livro.getExemplares());

            campoTitulo.setText(livro.getTitulo());
            campoCodBarras.setText(livro.getCodigoBarras());
            campoAno.setText(anoString);
            campoCodBarras.setText(livro.getCodigoBarras());
            campoEdicao.setText(edicaoString);
            campoEditora.setText(livro.getEditora());
            campoEstante.setText(estanteString);
            campoExemplares.setText(exemplaresString);
            campoISBN.setText(isbnString);
            campoTitulo.setText(livro.getTitulo());
            campoVolume.setText(volumeString);
            campoDisponiveis.setText(dispString);

            botaoEditar.setDisable(false);
        }
        

    }

    @FXML
    void salvarEdicao(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadastrarLivro = new AcoesLivro();
        botaoEditar.setDisable(true);
        botaoSalvar.setDisable(true);

    }

}
