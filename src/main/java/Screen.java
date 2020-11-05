public class Screen implements ScreenSpec{
    String resolution;
    int refreshRate;
    int responseTime;

    Screen(String resolution, int refreshRate, int responseTime) {
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.responseTime = responseTime;
    }
    public String getResolution() {
        return resolution;
    }
    public int getResponseTime() {
        return responseTime;
    }
    public int getRefreshRate() {
        return refreshRate;
    }
    public String toString() {
        return "Resolution: " + resolution + "\n" + "Refresh Rate: " + refreshRate + "\n" + "Response Time: " + responseTime;
    }

}
