package services;

import configs.SessionConfig;
import models.File;
import models.Response;
import java.util.List;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

//TODO: salvar arquivos baixados
public class SessionService {

    public List<File> getSessionFiles(String session) throws Exception { 
        HttpResponse<String> responseJson = RequestService.get(SessionConfig.baseEndpoint + "/" + session + "/files");
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = objectMapper.readValue(responseJson.body(), Response.class);
        
        if(response.getData() == null || response.getData().isEmpty()) {
            throw new Exception("Sessão sem arquivos!");
        }

        return response.getData();
    }

    public void saveSessionFiles(String session) throws Exception {
        List<File> files = getSessionFiles(session);
    }
}
