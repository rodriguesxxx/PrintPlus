package models;

import java.util.List;

public class Response {

    private String message;
    private int code;
    private List<File> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    public List<File> getData() {
        return data;
    }

    public void setData(List<File> data) {
        this.data = data;
    }
}
