/**
 * ItemType Enum
 *
 * @author MiguelTrejo
 * ItemType enum has a String and ItemType code for each ItemType.
 */

public enum ItemType {
    AUDIO("AU"),
    VISUAL("VI"),
    AUDIO_MOBILE("AM"),
    VISUAL_MOBILE("VM");

    public final String code;

    ItemType(String code) {
        this.code = code;
    }

    public String getItemTypeChoice() {
        return this.code;
    }

    public String getCode() {
        return code;
    }

}
