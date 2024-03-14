package services;

import enums.RequestEnum;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestService {
    
    static private HttpClient client = HttpClient.newHttpClient();
    
    public static HttpResponse<String> get(String endpoint) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(RequestEnum.BASE_URL.value() + endpoint))
            .GET()
            .build();
            
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        return httpResponse;
    }

   public static byte[] getFile(String endpoint) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(RequestEnum.BASE_URL.value() + endpoint))
            .GET()
            .build();
        
        HttpResponse<byte[]> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        return httpResponse.body();
   }
}

