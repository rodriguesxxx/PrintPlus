package enums;

public enum RequestEnum {

    BASE_URL("http://localhost:8080/printplus/api");
    
    private final String value;

    RequestEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
