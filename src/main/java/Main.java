import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

        Product productProduced = new Widget("iPod", "Apple", ItemType.AUDIO);

        // test constructor used when creating production records from user interface
        int numProduced = 3;  // this will come from the combobox in the UI
        int itemCount = 0;

        for (int productionRunProduct = 0; productionRunProduct < numProduced; productionRunProduct++) {
            ProductionRecord pr = new ProductionRecord(productProduced, itemCount++);
            // using the iterator as the product id for testing
            System.out.println(pr.toString());
        }

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