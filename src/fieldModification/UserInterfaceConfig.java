package fieldModification;

import java.util.Arrays;

public class UserInterfaceConfig {

    private String titleText;
    private String[] titleFonts;
    private int[] titleTextSizes;

    public String getTitleText() {
        return titleText;
    }

    public String[] getTitleFonts() {
        return titleFonts;
    }

    public int[] getTitleTextSizes() {
        return titleTextSizes;
    }

    @Override
    public String toString() {
        return "UserInterfaceConfig{" +
                "titleText='" + titleText + '\'' +
                ", titleFonts=" + Arrays.toString(titleFonts) +
                ", titleTextSizes=" + Arrays.toString(titleTextSizes) +
                '}';
    }
}
