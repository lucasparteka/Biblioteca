package View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import Controller.AcoesPessoa;
import Controller.AcoesEmprestimo;
import Model.AbstractInformacional;
import Model.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mask.ValidarNumeros;
import javafx.scene.Node;

public class RealizarEmprestimoController implements Initializable {

    private AcoesPessoa pesquisarUsuario;
    private Pessoa usuario;
    private AcoesEmprestimo realizarEmprestimo;
    private ObservableList<String> obsTipoMaterial;
    private ArrayList<String> listTipoMaterial = new ArrayList<>();
    private AbstractInformacional abstractInformacional;

    public AbstractInformacional getAbstractInformacional() {
        return abstractInformacional;
    }

    public void setAbstractInformacional(AbstractInformacional abstractInformacional) {
        this.abstractInformacional = abstractInformacional;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    public AcoesPessoa getPesquisarUsuario() {
        return pesquisarUsuario;
    }

    public void setPesquisarUsuario(AcoesPessoa pesquisarUsuario) {
        this.pesquisarUsuario = pesquisarUsuario;
    }

    @FXML
    private JFXTextField campoCPF;

    @FXML
    private Button botaoConfirmarEmp;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoSelecionarTipo;

    @FXML
    private Label labelTeste;

    @FXML
    private JFXTextField campoNome;

    @FXML
    private JFXComboBox<String> dropTipoMaterial;

    @FXML
    private JFXTextField campoCodBarras;

    @FXML
    private JFXTextField campoTitulo;

    @FXML
    private JFXTextField campoID;

    @FXML
    private JFXDatePicker barraDataAtual;

    @FXML
    private JFXDatePicker barraDataEntrega;

    @FXML
    private Label labelStatus;

   
    @FXML
    public void validarCPF() {
    	ValidarNumeros validar = new ValidarNumeros();
    	validar.validarCpf(campoCPF);
    }

    @FXML
    void abirMaterial(ActionEvent event) throws IOException {

        if (dropTipoMaterial.getSelectionModel().getSelectedItem() == null) {

        } else if (dropTipoMaterial.getSelectionModel().getSelectedItem().equals("Livro")) {
            FXMLLoader loader = new FXMLLoader(TabelaLivrosController.class.getResource("TabelaLivros.fxml"));
            Parent cadastro = loader.load();
            TabelaLivrosController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setScene(new Scene(cadastro));
            dialog.showAndWait();

            setAbstractInformacional(controller.getLivroSelecionado());

            if (abstractInformacional != null) {
                campoCodBarras.setText(controller.getLivroSelecionado().getCodigoBarras());
                campoTitulo.setText(controller.getLivroSelecionado().getTitulo());
            }

        } else if (dropTipoMaterial.getSelectionModel().getSelectedItem().equals("Periodico")) {

            FXMLLoader loader = new FXMLLoader(TabelaPeriodicosController.class.getResource("TabelaPeriodicos.fxml"));
            Parent cadastro = loader.load();
            TabelaPeriodicosController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setScene(new Scene(cadastro));
            dialog.showAndWait();

            setAbstractInformacional(controller.getPeriodicoSelecionado());

            if (abstractInformacional != null) {
                campoCodBarras.setText(controller.getPeriodicoSelecionado().getCodigoBarras());
                campoTitulo.setText(controller.getPeriodicoSelecionado().getTitulo());
            }

        } else if (dropTipoMaterial.getSelectionModel().getSelectedItem().equals("Material Especial")) {

            FXMLLoader loader = new FXMLLoader(TabelaPeriodicosController.class.getResource("TabelaMatEspecial.fxml"));
            Parent cadastro = loader.load();
            TabelaMatEspecialController controller = loader.getController();
            Stage dialog = new Stage();
            dialog.initOwner(((Node) event.getSource()).getScene().getWindow());
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setScene(new Scene(cadastro));
            dialog.showAndWait();

            setAbstractInformacional(controller.getMaterialSelecionado());

            if (abstractInformacional != null) {
                campoCodBarras.setText(controller.getMaterialSelecionado().getCodigoBarras());
                campoTitulo.setText(controller.getMaterialSelecionado().getTitulo());

            }

        }

    }

    @FXML
    void cancelarAcao(ActionEvent event) {

        Stage stage = (Stage) botaoCancelar.getScene().getWindow();
        stage.close();

    }

    @FXML
    void pesquisarUsuario(ActionEvent event) {

        if (campoCPF.getText().isEmpty()) {

        } else {
            usuario = new Pessoa();
            pesquisarUsuario = new AcoesPessoa();
            //setUsuario(pesquisarUsuario.pesquisar(campoCPF.getText()));
            if (getUsuario() == null) {
                campoCPF.getStylesheets().add(RealizarEmprestimoController.class.getResource("/style/edit_TextField.css").toExternalForm());
                labelStatus.setText("Cpf não localizado");
            } else {
            	campoCPF.getStylesheets().add(RealizarEmprestimoController.class.getResource("/style/edit_TextField_1.css").toExternalForm());
            	labelStatus.setText("");
                campoNome.setText(usuario.getNome());
                dropTipoMaterial.setDisable(false);
                botaoSelecionarTipo.setDisable(false);
            }
        }

    }

    @FXML
    void realizarEmprestimo(ActionEvent event) {

        Long idLong = Long.parseLong(campoID.getText());
        realizarEmprestimo = new AcoesEmprestimo();
        realizarEmprestimo.novoEmprestimo(abstractInformacional, idLong, "hoje", "Amanha", usuario);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // botaoConfirmarEmp.setDisable(true);
        // campoNome.setDisable(true);
        // campoCodBarras.setDisable(true);
        // campoTitulo.setDisable(true);
        // dropTipoMaterial.setDisable(true);
        // botaoSelecionarTipo.setDisable(true);
        listTipoMaterial.add("Livro");
        listTipoMaterial.add("Periodico");
        listTipoMaterial.add("Material Especial");

        obsTipoMaterial = FXCollections.observableArrayList(listTipoMaterial);

        dropTipoMaterial.setItems(obsTipoMaterial);

    }

}
