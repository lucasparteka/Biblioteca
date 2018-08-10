package View;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        JFXButton ssbutton1 = new JFXButton("CADASTRAR");
        JFXButton ssbutton2 = new JFXButton("PESSOA");
        JFXButton ssbutton3 = new JFXButton("AUTOR");
        JFXButton ssbutton7 = new JFXButton("LIVRO");
        JFXButton ssbutton5 = new JFXButton("PERIODICO");
        JFXButton ssbutton6 = new JFXButton("MAT ESPECIAL");
        JFXButton ssbutton4 = new JFXButton("EDITORA");
        JFXNodesList nodesList3 = new JFXNodesList();
        nodesList3.setSpacing(20);
        // init nodes
        nodesList3.addAnimatedNode(ssbutton1);
        nodesList3.addAnimatedNode(ssbutton2);
        nodesList3.addAnimatedNode(ssbutton3);
        nodesList3.addAnimatedNode(ssbutton4);
        nodesList3.addAnimatedNode(ssbutton5);
        nodesList3.addAnimatedNode(ssbutton6);
        nodesList3.addAnimatedNode(ssbutton7);

        ssbutton2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarPessoa.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("CADASTRAR NOVO USUARIO");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        ssbutton3.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarAutor.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("CADASTRAR NOVO AUTOR");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        ssbutton4.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarEditora.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("CADASTRAR NOVA EDITORA");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        ssbutton5.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarPeriodico.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("CADASTRAR NOVO MATERIAL PERIODICO");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        ssbutton6.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarMatespecial.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("CADASTRAR NOVO MATERIAL ESPECIAL");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        ssbutton7.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/CadastrarLivro.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("CADASTRAR NOVO LIVRO");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        JFXButton s4button1 = new JFXButton("CONSULTAR");
        JFXButton s4button2 = new JFXButton("PESSOA");
        JFXButton s4button3 = new JFXButton("AUTOR");
        JFXButton s4button4 = new JFXButton("LIVRO");
        JFXButton s4button5 = new JFXButton("PERIODICO");
        JFXButton s4button6 = new JFXButton("MAT ESPECIAL");
        JFXButton s4button7 = new JFXButton("EDITORA");
        
        s4button2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesPessoa.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("INFORMAÇÕES USUARIO");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        
        s4button3.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesAutor.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("INFORMAÇÕES AUTOR");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        
        s4button4.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesLivro.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("INFORMAÇÕES LIVRO");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        
        s4button5.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesPeriodico.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("INFORMAÇÕES PERIODICO");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        
        s4button6.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesMatEspecial.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("INFORMAÇÕES MATERIAL ESPECIAL");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        
        s4button7.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/InformacoesEditora.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("INFORMAÇÕES EDITORA");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        

        JFXNodesList nodesList4 = new JFXNodesList();
        nodesList4.setSpacing(20);
        // init nodes
        nodesList4.addAnimatedNode(s4button1);
        nodesList4.addAnimatedNode(s4button2);
        nodesList4.addAnimatedNode(s4button3);
        nodesList4.addAnimatedNode(s4button4);
        nodesList4.addAnimatedNode(s4button5);
        nodesList4.addAnimatedNode(s4button6);
        nodesList4.addAnimatedNode(s4button7);

        JFXButton sbutton1 = new JFXButton("EMPRESTIMOS");
        JFXButton sbutton2 = new JFXButton("NOVO EMPRESTIMO");
        JFXButton sbutton4 = new JFXButton("LISTAR EMPRESTIMOS");

        sbutton2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/RealizarEmprestimo.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("REALIZAR NOVO EMPRESTIMO");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        sbutton4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("View/TabelaEmprestimos.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("EMPRESTIMOS EM ABERTO");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        JFXNodesList nodesList2 = new JFXNodesList();
        nodesList2.setSpacing(20);
        // init nodes
        nodesList2.addAnimatedNode(sbutton1);
        nodesList2.addAnimatedNode(sbutton2);
        //nodesList2.addAnimatedNode(sbutton3);
        nodesList2.addAnimatedNode(sbutton4);
        nodesList2.setRotate(0);

        JFXButton button1 = new JFXButton("VAMOS COMEÇAR");
        // button1.getStylesheets().add(MyDoc.class.getResource("estilo.css").toExternalForm());
        button1.setTranslateY(440);
        button1.setTranslateX(-70);

        JFXNodesList nodesList = new JFXNodesList();
        nodesList.setSpacing(180);
        nodesList.addAnimatedNode(button1);
        nodesList.addAnimatedNode(nodesList4);
        nodesList.addAnimatedNode(nodesList2);
        nodesList.addAnimatedNode(nodesList3);
        // seta nodes para baixo com 0 graus
        nodesList.setRotate(90);

        AnchorPane main = new AnchorPane();
        main.getChildren().add(nodesList);
        AnchorPane.setLeftAnchor(nodesList, Double.valueOf(710));
        AnchorPane.setTopAnchor(nodesList, Double.valueOf(180));
        Scene scene = new Scene(main, 700, 600);
        scene.getStylesheets().add(Main.class.getResource("/style/new.css").toExternalForm());
        stage.setScene(scene);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

}
