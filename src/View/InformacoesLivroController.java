package View;

import Controller.AcoesLivro;
import Model.Autor;
import Model.Editora;
import Model.Livro;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
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

/**
 * FXML Controller class
 *
 * @author lparteka
 */
public class InformacoesLivroController implements Initializable {

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
	private JFXTextField campoID;

	@FXML
	private JFXTextField campoTitulo;

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
    private Button botaoAlterarEditora;

    @FXML
    private JFXTextField campoAutor;

    @FXML
    private Button botaoAlterarAutor;

	@FXML
	private Button botaoSalvar;

	@FXML
	private Button botaoEditar;

	@FXML
	private Button botaoCancelar;

	@FXML
	private Label labelStatus;

	@FXML
	void pesquisarLivro(ActionEvent event) {
		if (campoID.getText().isEmpty()) {
			labelStatus.setText("digite um id");
		} else {
			labelStatus.setText("");
			livro = new Livro();
			livro = acoesLivro.pequisar(Long.parseLong(campoID.getText()));
			setAutor(livro.getAutor());
			setEditora(livro.getEditora());
			if (livro == null) {
				labelStatus.setText("Nenhum livro encontrado com esse id");
			} else {
				labelStatus.setText("");
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
			}
		}
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
			campoAutor.setText(controller.getAutorSelecionado().getNome());
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
	
	@FXML
	void cancelarAcao(ActionEvent event) {
		Stage stage = (Stage) botaoCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void editarLivro(ActionEvent event) {
		botaoSalvar.setDisable(false);
		botaoAlterarAutor.setDisable(false);
		botaoAlterarEditora.setDisable(false);
		campoID.setDisable(true);
		campoAno.setEditable(true);
		campoCodBarras.setEditable(true);
		campoDisponiveis.setEditable(true);
		campoEdicao.setEditable(true);
		campoEstante.setEditable(true);
		campoExemplares.setEditable(true);
		campoISBN.setEditable(true);
		campoTitulo.setEditable(true);
		campoVolume.setEditable(true);
	}

	@FXML
	void salvarEdicao(ActionEvent event) {
		if (campoAno.getText().isEmpty() || campoCodBarras.getText().isEmpty() || campoDisponiveis.getText().isEmpty()
				|| campoEdicao.getText().isEmpty() || campoEditora.getText().isEmpty()
				|| campoEstante.getText().isEmpty() || campoExemplares.getText().isEmpty()
				|| campoISBN.getText().isEmpty() || campoAutor.getText().isEmpty()
				|| campoTitulo.getText().isEmpty() || campoVolume.getText().isEmpty()) {
			labelStatus.setText("Preencha todos os campos");
		} else {
			//livro = new Livro();
			getLivro().setAno(Integer.parseInt(campoAno.getText()));
			getLivro().setAutor(getAutor());
			getLivro().setCodigoBarras(campoCodBarras.getText());
			getLivro().setDisponiveis(Integer.parseInt(campoDisponiveis.getText()));
			getLivro().setEdicao(Integer.parseInt(campoEdicao.getText()));
			getLivro().setEditora(getEditora());
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

			acoesLivro.realizarCadastro(getLivro(), AcoesLivro.ALTERAR_CADASTRO);
			labelStatus.setText("Alterado com sucesso");
			campoAno.setText("");
			campoCodBarras.setText("");
			campoDisponiveis.setText("");
			campoEdicao.setText("");
			campoEditora.setText("");
			campoEstante.setText("");
			campoExemplares.setText("");
			campoISBN.setText("");
			campoAutor.setText("");
			campoTitulo.setText("");
			campoVolume.setText("");
			botaoAlterarAutor.setDisable(true);
			botaoAlterarEditora.setDisable(true);
			botaoEditar.setDisable(true);
			botaoSalvar.setDisable(true);
			botaoEditar.setDisable(true);
			campoID.setDisable(false);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		acoesLivro = new AcoesLivro();
		botaoEditar.setDisable(true);
		botaoSalvar.setDisable(true);
	}

}
