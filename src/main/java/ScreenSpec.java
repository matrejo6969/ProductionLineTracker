/**
 * ScreenSpec Interface
 *
 * @author MiguelTrejo
 * ScreenSpec Interface makes sure all the Screen object have
 * Resolution, Refreshrate and ResponseTime. 
 */

public interface ScreenSpec {

    public String getResolution();

    public int getRefreshRate();

    public int getResponseTime();

}
