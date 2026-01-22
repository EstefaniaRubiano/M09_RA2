
public class Motor extends Thread {

    private static final int MIN_INTERVAL = 1000;
    private static final int MAX_INTERVAL = 2000;

    private int potenciaActual; 
    private int potenciaObjectiu;  
    private int numMotor;  
    private boolean enMarxa;      

    public Motor(int numMotor) {
        this.numMotor = numMotor;
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.enMarxa = true;
    }

    public synchronized void setPotencia(int p) {
        this.potenciaObjectiu = p;
    }

    @Override
    public void run() {
        while (enMarxa) {
            
            if (potenciaActual < potenciaObjectiu) {
                // Incrementar
                potenciaActual++;
                System.out.printf("Motor %d: Incre. Objectiu: %d Actual: %d%n", 
                                  numMotor, potenciaObjectiu, potenciaActual);
                
            } else if (potenciaActual > potenciaObjectiu) {
                // Decrementar
                potenciaActual--;
                System.out.printf("Motor %d: Decre. Objectiu: %d Actual: %d%n", 
                                  numMotor, potenciaObjectiu, potenciaActual);
                
            } else {
                // No fer res (ja està en el objectiu)
                if (potenciaActual != 0) {
                    // Estoy en el objetivo pero NO es 0, muestro FerRes
                    System.out.printf("Motor %d: FerRes Objectiu: %d Actual: %d%n", 
                                      numMotor, potenciaObjectiu, potenciaActual);
                }
            }
            
            // Si arribem a 0 i l'objectiu és 0, apagar el motor
            if (potenciaActual == 0 && potenciaObjectiu == 0) {
                enMarxa = false;
            }
            
            // Dormir entre 1 i 2 segons
            try {
                int interval = MIN_INTERVAL + (int)(Math.random() * (MAX_INTERVAL - MIN_INTERVAL + 1));
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
