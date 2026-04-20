public class HomeLogger {
    private static HomeLogger instance;
    private HomeLogger() {}
    public static HomeLogger getInstance() {
        if (instance == null) instance = new HomeLogger();
        return instance;
    }
    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}
