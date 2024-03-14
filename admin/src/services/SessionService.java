package services;

import enums.FileEnum;
import enums.SessionEnum;
import models.File;
import models.Response;
import utils.FileUtil;

import java.util.List;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SessionService {

    public List<File> getSessionFiles(String session) throws Exception { 
        HttpResponse<String> responseJson = RequestService.get(SessionEnum.BASE_ENDPOINT.value() + "/" + session + "/files");
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = objectMapper.readValue(responseJson.body(), Response.class);
        
        if(response.getData() == null || response.getData().isEmpty()) {
            throw new Exception("Sessão sem arquivos!");
        }

        return response.getData();
    }

    public void saveSessionFiles(String session) throws Exception {
        List<File> files = getSessionFiles(session);
        java.io.File newPath = new java.io.File(FileEnum.BASE_DIR.value() + session);

        if(!newPath.exists()) {
            newPath.mkdirs();
        }

        for(File file : files) {
            byte[] fileRaw = RequestService.getFile("/"+session+"/"+file.getId());
            FileUtil.save(fileRaw, newPath + "/" + file.getFilename());
        }
    }
}
