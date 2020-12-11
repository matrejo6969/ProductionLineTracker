/**
 * MoviePlayer Class
 *
 * @author MiguelTrejo
 * MoviePlayer class creates a product object that holds data as a MoviePlayer
 * while being implemented by the MultimeidaContro and extends Product.
 */

public class MoviePlayer extends Product implements MultimediaControl{
    Screen screen;
    MonitorType monitorType;

    public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
        super(name, manufacturer, ItemType.VISUAL);
        this.screen = screen;
        this.monitorType = monitorType;
    }
    @Override
    public void play() {
        System.out.println("Playing Movie");
    }
    @Override
    public void stop() {
        System.out.println("Stop Movie");
    }
    @Override
    public void previous() {
        System.out.println("Previous Movie");
    }
    @Override
    public void next() {
        System.out.println("Next Movie");
    }
    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type + "\n" +"Screen: " + "\n" + screen + "\n" + "Monitor Type: " + monitorType;
    }

}
