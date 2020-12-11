/**
 * Product Class/Widget
 *
 * @author MiguelTrejo
 * The Product class creates a Product object with Widget class within.
 * */

public abstract class Product implements Item {

    int id;
    String name;
    String manufacturer;
    ItemType type;

    public Product(String name, String manufacturer, ItemType type) {

        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;

    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ItemType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
    }

}

class Widget extends Product implements Item{

    Widget(String name, String manufacturer, ItemType type) {
        super(name, manufacturer, type);
    }
}