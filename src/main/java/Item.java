/**
 * Item Interface
 *
 * @author MiguelTrejo
 * This Item Interface is implemented by the Product class and
 * makes sure all of this informaiton gets included into Product.
 */

public interface Item {
    public int getID();

    public String getManufacturer();

    public String getName();

    public void setManufacturer(String manufacturer);

    public void setName(String name);

    public ItemType getType();
}