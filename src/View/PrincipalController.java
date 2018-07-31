package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalController implements Initializable {

    @FXML
    void cadastrarAutor(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarAutor.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Novo Autor");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();

    }

    @FXML
    void cadastrarEditora(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarEditora.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Nova Editora");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void cadastrarLivro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarLivro.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Novo Livro");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void cadastrarMatEspecial(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarMatespecial.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Novo Material especial");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void cadastrarPeriodico(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarPeriodico.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Novo Periódico");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void cadastrarPessoa(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarPessoa.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Nova Pessoa");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void consultarAutor(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesAutor.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Consultar Autor");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void consultarEditora(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesEditora.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Consultar Editora");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void consultarLivro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesLivro.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Nova Pessoa");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void consultarMatEspecial(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesMatEspecial.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Consultar Material Especial");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();

    }

    @FXML
    void consultarPeriodico(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesPeriodico.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Consultar Periodico");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();

    }

    @FXML
    void consultarPessoa(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesPessoa.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Nova Pessoa");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();

    }

    @FXML
    void listarDevolucoes(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/TabelaDevolucoes.fxml"));
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void listarEmprestimos(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/TabelaEmprestimos.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Emprestimos em aberto");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @FXML
    void realizarEmprestimo(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/RealizarEmprestimo.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Realizar Emprestimo");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
