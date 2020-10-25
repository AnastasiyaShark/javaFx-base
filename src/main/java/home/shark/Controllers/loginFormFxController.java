package home.shark.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class loginFormFxController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passField;

    @FXML
    private Button buttonLogin;

    @FXML
    private ImageView bottomImageView;

    @FXML
    private Button buttonExit;

    @FXML
    private TextField emailField;

    @FXML
    private ImageView topImageView;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert passField != null : "fx:id=\"passField\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert bottomImageView != null : "fx:id=\"bottomImageView\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert buttonExit != null : "fx:id=\"buttonExit\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file 'LoginForm.fxml'.";
        assert topImageView != null : "fx:id=\"topImageView\" was not injected: check your FXML file 'LoginForm.fxml'.";

        System.out.println("loginFormFxController:: I am created!");

        setupHandlers();
    }

    private void setupHandlers() {
        buttonExit.setOnAction(this::buttonExitOnActionHandler);
        buttonLogin.setOnAction(this::buttonLoginOnActionHandler);
    }

    private void buttonExitOnActionHandler(ActionEvent event) {
        Platform.exit();
    }

    private void buttonLoginOnActionHandler(ActionEvent event) {
        Scene scene = null;
        Stage thisStage = null;
        try {
            thisStage = (Stage) buttonLogin.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainForm.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            scene = new Scene(root1);
        } catch (NullPointerException | IOException nullPointerException) {
            return;
        }
        thisStage.setTitle("Logged into: " + thisStage.getTitle());
        thisStage.setScene( scene );
    }
}
