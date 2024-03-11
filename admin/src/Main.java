import configs.FileConfig;
import services.RequestService;
import services.SessionService;
import utils.FileUtil;

public class Main {
    public static void main(String[] args) {

        try {
            SessionService sessionService = new SessionService();
            sessionService.saveSessionFiles("ABCD");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
