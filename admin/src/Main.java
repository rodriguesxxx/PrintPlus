import services.SessionService;

public class Main {
    public static void main(String[] args) {

        try {
            SessionService sessionService = new SessionService();
            sessionService.getSessionFiles("ABCD");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
