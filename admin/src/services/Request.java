package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


//TODO: get para baixar arquivos
public class Request {
    
    public static String baseUrl = "http://localhost:8080/printplus/api";
    static private HttpClient client = HttpClient.newHttpClient();
    
    public static HttpResponse<String> get(String endpoint) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(baseUrl + endpoint))
            .GET()
            .build();
            
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        return httpResponse;
    }
}