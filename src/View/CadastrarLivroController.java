package View;

import Controller.AcoesLivro;
import Model.Autor;
import Model.Editora;
import Model.Livro;

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

	private AcoesLivro acoesLivro;
	private Livro livro;
	private Autor autor;
	private Editora editora;
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

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
		ValidarNumeros.validarQuatroDig(campoAno);
		ValidarNumeros.validarOitoDig(campoCodBarras);
		ValidarNumeros.validarQuatroDig(campoDisponiveis);
		ValidarNumeros.validarQuatroDig(campoEdicao);
		ValidarNumeros.validarQuatroDig(campoEstante);
		ValidarNumeros.validarQuatroDig(campoExemplares);
		ValidarNumeros.validarOitoDig(campoISBN);
		ValidarNumeros.validarQuatroDig(campoVolume);
	}

	@FXML
	void cadastrarLivro(ActionEvent event) {

		if (campoAno.getText().isEmpty() || campoCodBarras.getText().isEmpty() || campoDisponiveis.getText().isEmpty()
				|| campoEdicao.getText().isEmpty() || campoEditora.getText().isEmpty()
				|| campoEstante.getText().isEmpty() || campoExemplares.getText().isEmpty()
				|| campoISBN.getText().isEmpty() || campoNomeAutor.getText().isEmpty()
				|| campoTitulo.getText().isEmpty() || campoVolume.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			livro = new Livro();
			getLivro().setAno(Integer.parseInt(campoAno.getText()));
			getLivro().setAutor(autor);
			getLivro().setCodigoBarras(campoCodBarras.getText());
			getLivro().setDisponiveis(Integer.parseInt(campoDisponiveis.getText()));
			getLivro().setEdicao(Integer.parseInt(campoEdicao.getText()));
			getLivro().setEditora(editora);
			getLivro().setEstante(Integer.parseInt(campoEstante.getText()));
			getLivro().setExemplares(Integer.parseInt(campoExemplares.getText()));
			getLivro().setISBN(Integer.parseInt(campoISBN.getText()));
			getLivro().setTitulo(campoTitulo.getText());
			getLivro().setVolume(Integer.parseInt(campoVolume.getText()));
			
//			int estanteInt = Integer.parseInt(campoEstante.getText());
//			int exemplaresInt = Integer.parseInt(campoExemplares.getText());
//			int disponiveisInt = Integer.parseInt(campoDisponiveis.getText());
//			int isbnInt = Integer.parseInt(campoISBN.getText());
//			int anoInt = Integer.parseInt(campoAno.getText());
//			int volumeInt = Integer.parseInt(campoVolume.getText());
//			int edicaoInt = Integer.parseInt(campoEdicao.getText());

			acoesLivro.realizarCadastro(getLivro(), AcoesLivro.INSERIR_CADASTRO);
			labelStatus.setText("Cadastrado com sucesso");
			campoAno.setText("");
			campoCodBarras.setText("");
			campoDisponiveis.setText("");
			campoEdicao.setText("");
			campoEditora.setText("");
			campoEstante.setText("");
			campoExemplares.setText("");
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
		FXMLLoader loader = new FXMLLoader(TabelaAutoresController.class.getResource("TabelaAutores.fxml"));
		Parent cadastro = loader.load();
		TabelaAutoresController controller = loader.getController();
		Stage dialog = new Stage();
		dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.setScene(new Scene(cadastro));
		dialog.showAndWait();

		if (controller.getAutorSelecionado() != null) {
			setAutor(controller.getAutorSelecionado());
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
			setEditora(controller.getEditora());
			campoEditora.setText(controller.getEditora().getNome());
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		acoesLivro = new AcoesLivro();
	}

}
