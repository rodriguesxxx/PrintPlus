package enums;

public enum SessionEnum {
    BASE_DIR(FileEnum.BASE_DIR.value() + "sessions/"),
    BASE_ENDPOINT("/session");

    private final String value;

    SessionEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
