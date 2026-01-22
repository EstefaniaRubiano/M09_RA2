import java.util.Scanner;

public class Coet {
    private static final int NUM_MOTORS = 4;
    private static final int MIN_POTENCIA = 0;
    private static final int MAX_POTENCIA = 10;

    private Motor[] motors;

    public Coet() {
        motors = new Motor[NUM_MOTORS];
        for (int i = 0; i < NUM_MOTORS; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void arranca() {
        // iniciar els 4 motors
        for (int i = 0; i < NUM_MOTORS; i++) {
            motors[i].start();
        }
    }

    public void passaAPotencia(int p) {
        // Validar potencia
        if (p < MIN_POTENCIA || p > MAX_POTENCIA) {
            System.out.println("ERROR: La potència ha d'estar entre " + 
                               MIN_POTENCIA + " i " + MAX_POTENCIA);
            return;
        }
        
        // Establecer potencia en todos los motores
        System.out.println("Passant a potència " + p);
        for (int i = 0; i < NUM_MOTORS; i++) {
            motors[i].setPotencia(p);
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int potencia = scanner.nextInt();
            coet.passaAPotencia(potencia);
            
            if (potencia == 0) {
                break;
            }
        }
        
        scanner.close();
    }
}
