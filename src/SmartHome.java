
 // Classe que utiliza o modelo singleton
class HomeLogger {
    
    // Atributo estático que armazenará a única instância da classe
    private static HomeLogger instance;
    // Construtor PRIVADO: Impede que outras classes usem "new HomeLogger()"
    private HomeLogger() {
    }

    // Método estático global: É a única forma de obter o objeto Logger
    public static HomeLogger getInstance() {
        if (instance == null) {
            instance = new HomeLogger();
        }
        return instance;
    }

    public void log(String msg) {
        System.out.println("[SMART-HOME-LOG] " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        HomeLogger logger1 = HomeLogger.getInstance();
        logger1.log("Sistema iniciado com sucesso.");

    }
}
