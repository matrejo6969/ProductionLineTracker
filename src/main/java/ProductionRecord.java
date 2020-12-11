/**
 * ProductionRecord Class
 *
 * @author MiguelTrejo
 * The ProductionRecord class holds data of the products being made and added
 * with a serialnumber.
 */

import java.util.Date;

public class ProductionRecord {
    int productionNumber;
    int productID;
    String serialNumber;
    Date dateProduced;


    // accessors & mutators for all fields
    public int getProductionNumber() {
        return productionNumber;
    }

    public void setProductionNumber(int productionNumber) {
        this.productionNumber = productionNumber;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getDateProduced() {
        return dateProduced;
    }

    public Date setDateProduced(Date dateProduced) {
        return dateProduced = dateProduced;
    }

    // constructor called when user records production from user interface
    // New Code (Look at the bottom for changes)
    // constructor called when user records production from user interface
    public ProductionRecord(int productID) {
        this.productionNumber = 0;
        this.serialNumber = "0";
        this.dateProduced = new Date();
    }

    // overloaded constructor when creating ProductionRecord obj from database
    public ProductionRecord(int productionNumber, int productID, String serialNumber, Date dateProduced) {
        this.productionNumber = productionNumber;
        this.productID = productID;
        this.serialNumber = serialNumber;
        this.dateProduced = dateProduced;
    }

    // overloaded constructor for unique serial #
    public ProductionRecord(Product product, int count) {
        serialNumber = product.getManufacturer().substring(0,3) + product.type.code + String.format("%05d", count);
        productID = 0;
        productionNumber = 0;
        this.dateProduced = new Date();
    }



    @Override
    public String toString() {
        return "Prod. Num: " + productionNumber + " Product ID: " + productID + " Serial Num: " + serialNumber
            + " Date: " + dateProduced;
    }
}