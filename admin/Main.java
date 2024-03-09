import java.net.http.HttpResponse;

import services.Request;

public class Main {
    public static void main(String[] args) {

        try {
            HttpResponse response = Request.get("/files/ABCD/download/0d99573d-4db6-454c-9f6f-fddaa1d72536");
            System.out.println(response.body());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
