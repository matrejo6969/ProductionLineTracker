public interface Item {
    public int getID();

    public String getManufacturer();

    public String getName();

    public void setManufacturer(String manufacturer);

    public void setName(String name);

    public ItemType getType();
}