/**
 * Controller class
 *
 * @author MiguelTrejo
 * The Controller Class observed by the sample.fxml file, provides a GUI,
 * a method to connect to the Database and display information.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
// all sql imports
import java.sql.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    private TextField txtProductName;

    @FXML
    private TextField txtManufacturer;

    @FXML
    private ChoiceBox<String> chbItemType;

    @FXML
    private Button btnAddProduct;

    @FXML
    private TableView<Product> tblExistingProducts;

    @FXML
    private TableColumn<?, ?> tblProductID;

    @FXML
    private TableColumn<?, ?> tblProductName;

    @FXML
    private TableColumn<?, ?> tblManufacturer;

    @FXML
    private TableColumn<?, ?> tblItemType;

    @FXML
    private ListView<Product> txlChooseProducts;

    @FXML
    private ComboBox<String> cmbQuantity;



    @FXML
    private TextArea txaOutput;                  // used to catch exceptions

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./resources/resourcesDB";

    // Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn = null;     // set to null
    Statement stmt = null;      // set to null

    //New Code
    private final ObservableList<Product> data = FXCollections.observableArrayList();

    // Only do once
    public void initialize() {
        connectToDb();
        // Count 1-10 w/ editable box for product amount
        for (int count = 1; count <= 10; count++) {
            cmbQuantity.getItems().add(String.valueOf(count));
            cmbQuantity.setEditable(true);
            cmbQuantity.getSelectionModel().selectFirst();
        }
        // Fill choice box w/ enum types
        chbItemType.getItems().addAll(
            String.valueOf(ItemType.AUDIO),
            String.valueOf(ItemType.VISUAL),
            String.valueOf(ItemType.VISUAL_MOBILE),
            String.valueOf(ItemType.AUDIO_MOBILE));
        chbItemType.getSelectionModel().selectFirst();

        //New Code

        setupProduceTable();
        setupProductLineTable();

    }

    // Connection to Database
    public void connectToDb() {
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);     // no user or password used yet

        } catch (SQLException e) {               // catch SQL exceptions
            txaOutput.appendText(e.toString());

        } catch (ClassNotFoundException e) {    // catch class exceptions
            txaOutput.appendText(e.toString());
        }
    }

    // Add Product button
    @FXML
    void addProduct(ActionEvent event) {

        setupProduceTable();
        setupProductLineTable();
        String productName = txtProductName.getText();
        String manufacturer = txtManufacturer.getText();
        String itemType = chbItemType.getValue();
        System.out.println("Product Successfully Added\n");
        try {
            stmt = conn.createStatement();


            String sql = "select PRODUCTION_NUM, PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED" +
                "\nfrom PRODUCTIONRECORD";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                txaOutput.appendText(
                    ("PRODUCT NUM: ") + rs.getString(1) + (" ") +
                        ("PRODUCT ID ") + rs.getString(2) + (" ") +
                        ("SERIAL_NUM ") + rs.getString(3) + (" ") +
                        ("DATE: ") + rs.getString(4) + (" ") +
                        "\n");
            }

            // Adding product into database
            final String insertSql = "INSERT INTO PRODUCT(NAME, MANUFACTURER, TYPE)"
                + "VALUES (?, ?, ?)";

            // Prepared Statements w/ parameters
            PreparedStatement pStatement = conn.prepareStatement(insertSql);
            pStatement.setString(1, productName);
            pStatement.setString(2, manufacturer);
            pStatement.setString(3, itemType);

            pStatement.executeUpdate();



        } catch (SQLException e) {              // catch SQL exceptions
            txaOutput.appendText(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    //New Code
    public void setupProductLineTable() {
        String name = txtProductName.getText();
        String manufacturer = txtManufacturer.getText();
        String type = String.valueOf(chbItemType.getValue());

        Product widget = new Widget(name, manufacturer, ItemType.valueOf(type));
        data.add(widget);
        //tblProductID.setCellValueFactory(new PropertyValueFactory("ProductID"));
        tblProductName.setCellValueFactory(new PropertyValueFactory("name"));
        tblManufacturer.setCellValueFactory(new PropertyValueFactory("manufacturer"));
        tblItemType.setCellValueFactory(new PropertyValueFactory("type"));

        tblExistingProducts.setItems(data);

    }
    public void setupProduceTable() {

        txlChooseProducts.setItems(data);
    }
   /* public void showProductList() {
        try {
            stmt = conn.createStatement();
            String searchSql = "SELECT * FROM PRODUCT";
            ResultSet bs = stmt.executeQuery(searchSql);
            final ObservableList<Product> items = tempName.getItems();
            {
                while (bs.next()) {
                    String name = bs.getString(2);
                    String manufacturer = bs.getString(4);
                    String type = bs.getString(3);
                }
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        setupProductLineTable();
    }*/


}