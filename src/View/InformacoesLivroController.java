package View;

import Controller.AcoesLivro;
import Model.Livro;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lparteka
 */
public class InformacoesLivroController implements Initializable {

	private AcoesLivro acoesLivro;
	private Livro livro;

	@FXML
	private JFXTextField campoID;

	@FXML
	private JFXTextField campoTitulo;

	@FXML
	private JFXTextField campoAutor;

	@FXML
	private JFXTextField campoEditora;

	@FXML
	private JFXTextField campoAno;

	@FXML
	private JFXTextField campoExemplares;

	@FXML
	private JFXTextField campoEstante;

	@FXML
	private JFXTextField campoDisponiveis;

	@FXML
	private JFXTextField campoEdicao;

	@FXML
	private JFXTextField campoVolume;

	@FXML
	private JFXTextField campoCodBarras;

	@FXML
	private JFXTextField campoISBN;

	@FXML
	private Button botaoSalvar;

	@FXML
	private Button botaoEditar;

	@FXML
	private Button botaoCancelar;

	@FXML
	private Label labelStatus;

	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void editarLivro(ActionEvent event) {
		botaoSalvar.setDisable(false);
	}

	@FXML
	void pesquisarLivro(ActionEvent event) {
		if (campoID.getText().isEmpty()) {
			labelStatus.setText("digite um id");
		} else {
			labelStatus.setText("");
			livro = acoesLivro.pequisar(Long.parseLong(campoID.getText()));
			if (livro == null) {
				JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com esse id");
			} else {
				campoTitulo.setText(livro.getTitulo());
				campoCodBarras.setText(livro.getCodigoBarras());
				campoAno.setText(Integer.toString(livro.getAno()));
				campoCodBarras.setText(livro.getCodigoBarras());
				campoEdicao.setText(Integer.toString(livro.getEdicao()));
				campoEditora.setText(livro.getEditora().getNome());
				campoEstante.setText(Integer.toString(livro.getEstante()));
				campoExemplares.setText(Integer.toString(livro.getExemplares()));
				campoISBN.setText(Integer.toString(livro.getISBN()));
				campoTitulo.setText(livro.getTitulo());
				campoVolume.setText(Integer.toString(livro.getVolume()));
				campoDisponiveis.setText(Integer.toString(livro.getDisponiveis()));
				campoAutor.setText(livro.getAutor().getNome());

				botaoEditar.setDisable(false);
				campoID.setEditable(false);
			}
		}
	}

	@FXML
	void salvarEdicao(ActionEvent event) {

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		acoesLivro = new AcoesLivro();
		botaoEditar.setDisable(true);
		botaoSalvar.setDisable(true);
	}

}
