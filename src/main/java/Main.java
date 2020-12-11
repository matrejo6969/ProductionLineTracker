/**
 * Main class
 *
 * @author MiguelTrejo
 * Main class where the application start and main method exist.
 */

import java.util.Date;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Employee Name (first last)");
        String name = scan.nextLine();
        System.out.println("Enter Employee password");
        String password = scan.nextLine();
        Employee employee = new Employee(name, password);
        System.out.println(employee);



    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root, 600, 450);

        primaryStage.setTitle("Production Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}