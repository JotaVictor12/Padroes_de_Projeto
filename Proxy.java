public class Main {
    public static void main(String[] args) {
        HomeLogger logger = HomeLogger.getInstance();
        logger.log("Sistema iniciado.");

        // Usando a Factory para criar um dispositivo sem conhecer a classe concreta
        SmartDevice lampada = DeviceFactory.createDevice("SAMSUNG");
        if (lampada != null) {
            lampada.ligar();
        }
        SmartDevice lampadaReal = DeviceFactory.createDevice("SAMSUNG");
        SmartDevice segura = new SecurityProxy(lampadaReal, "GUEST"); // Vai falhar
        segura.ligar();
    }
}

// --- PADRÃO ADAPTER ---
interface SmartDevice { 
    void ligar(); 
}

class LampadaSamsung { 
    public void ligado() { System.out.println("-> [HARDWARE] Samsung acesa."); } 
}

class SamsungAdapter implements SmartDevice {
    private LampadaSamsung lampada = new LampadaSamsung();
    public void ligar() { lampada.ligado(); }
}

// --- PADRÃO FACTORY ---
class DeviceFactory {
    public static SmartDevice createDevice(String type) {
        if (type.equalsIgnoreCase("SAMSUNG")) return new SamsungAdapter();
        return null;
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

class SecurityProxy implements SmartDevice {
    private SmartDevice DispositivoReal;
    private String credencial;

    public SecurityProxy(SmartDevice dispositivo, String papel) {
        this.DispositivoReal = dispositivo;
        this.credencial = papel;
    }

    public void ligar() {
        if ("ADMIN".equals(credencial)) {
            HomeLogger.getInstance().log("Proxy: Acesso autorizado.");
            DispositivoReal.ligar();
        } else {
            HomeLogger.getInstance().log("Proxy: Acesso NEGADO.");
        }
    }
}
