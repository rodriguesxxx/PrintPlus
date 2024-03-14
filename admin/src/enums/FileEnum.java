package enums;


public enum FileEnum {
    BASE_DIR("/home/rodriguesxxx/projects/IFNMG/PrintPlus/admin/storage/sessions/"),
    BASE_ENDPOINT("/files");

    private final String value;

    FileEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
