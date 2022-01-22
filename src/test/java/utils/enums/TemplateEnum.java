package utils.enums;

public enum TemplateEnum {
    COLUMN_TEMPLATE("tpl_01"),
    FULL_WIDTH_TEMPLATE("tpl_02"),
    EMPTY_TEMPLATE("tpl_03");

    private final String value;

    TemplateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
