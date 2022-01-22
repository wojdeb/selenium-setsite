package utils.enums;

public enum ColorEnum {
    BLUE("color-blue"),
    WHITE("color-white"),
    GREEN("color-green");

    private final String value;

    ColorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
