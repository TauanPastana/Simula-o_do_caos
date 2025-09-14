package Padroes_Projetos;
import java.util.Random;
import java.util.Scanner;


public class Utilidades {
    private static Utilidades instance;
    private final Scanner scanner;
    private final Random random;
    

    private Utilidades() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }
    
    // Método estático para obter a instância única
    public static Utilidades getInstance() {
        if (instance == null) {
            instance = new Utilidades();
        }
        return instance;
    }
    
    public Scanner getScanner() {
        return scanner;
    }
    
    public Random getRandom() {
        return random;
    }
    

    public void closeResources() {
        if (scanner != null) {
            scanner.close();
        }
    }
}


