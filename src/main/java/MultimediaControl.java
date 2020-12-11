/**
 * MultimediaControl interface.
 *
 * @author MiguelTrejo
 * Multimedia Control interface holds the valued of Play, Stop, Previous, Next
 * while being used by AudioPlayer and MoviePlayer classes.
 * */

public interface MultimediaControl {

    public void play();

    public void stop();

    public void previous();

    public void next();

}