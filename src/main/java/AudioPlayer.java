class AudioPlayer extends Product implements MultimediaControl {
    String supportedAudioFormats;
    String supportedPlaylistFormats;

    public AudioPlayer(String name, String manufacturer, String supportedAudioFormats, String supportedPlaylistFormats) {
        super(name, manufacturer, ItemType.AUDIO);
        this.supportedAudioFormats = supportedAudioFormats;
        this.supportedPlaylistFormats = supportedPlaylistFormats;
    }

    @Override
    public void previous() {
        System.out.println("Previous");
    }

    @Override
    public void play() {
        System.out.println("Playing");
    }

    @Override
    public void next() {
        System.out.println("Next");
    }

    @Override
    public void stop() {
        System.out.println("Stop");
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type + "\n" +
                "Supported Audio Formats: " + supportedAudioFormats + "\nSupported Playlist Formats: " + supportedPlaylistFormats;
    }
}

