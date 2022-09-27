package it.polito.tdp.librettovoti;

import it.polito.tdp.librettovoti.model.Libretto;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //carica oggetto root con riferimento creato da un metodo statico
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
    //istanzio n oggetto di tipo FXMLLoader  con parametro che indica quale file fxml uso
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        //creo riferimento a root dal metodo NON statico load, però così ho un riferimento ell'oggetto Controller
        // da poter utilizzare per conoscere il riferimento dell'oggetto di tipo controller che viene creato in automatico dalla load()
        Parent root= loader.load();

        FXMLController controller=loader.getController();

        Libretto model=new Libretto();
        controller.setModel(model);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
