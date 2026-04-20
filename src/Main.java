public class Main {
    public static void main(String[] args) {
        // Obtendo a instância única do Logger
        HomeLogger logger = HomeLogger.getInstance();
        logger.log("Sistema Smart Home iniciado.");
    }
}

// --- PADRÃO SINGLETON ---
class HomeLogger {
    private static HomeLogger instance;
    
    private HomeLogger() {} // Construtor privado
    
    public static HomeLogger getInstance() {
        if (instance == null) {
            instance = new HomeLogger();
        }
        return instance;
    }
    
    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}
