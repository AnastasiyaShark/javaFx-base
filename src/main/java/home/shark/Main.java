package home.shark;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    //Переопределяем один метод здесь который загружает XML в сцену и показывает её.
    @Override
    public void start(Stage primaryStage){
        URL loginFormUrl = null;
        try {
            Parent root;
            //Вот этот кусок очень важный. Здесь мы указываем какой XML
            //файл загрузить. Нам не нужно создавать контроллер, он будет создан JavaFx
            //на основе загруженого FXML файла
            loginFormUrl = getClass().getResource("/LoginForm.fxml");
            root = FXMLLoader.load(loginFormUrl);
            //Название заголовка программы при старте
            primaryStage.setTitle("Hello World");
            //Указываем/Создаем сцену,которую будем менять : элемент + размеры (ширина и высота)
            primaryStage.setScene(new Scene(root, 1024, 768));
            //Показываем сцену
            primaryStage.show();
        } catch (IOException exception){
            if (loginFormUrl != null) {
                System.err.printf("failed to load fxml [%s] file due to: %s", loginFormUrl.toString() , exception.toString());
            } else {
                System.err.println("failed to load fxml file due to: " + exception.toString());
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}