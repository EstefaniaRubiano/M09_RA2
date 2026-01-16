
public class DormAleatori extends Thread{

    private static final int NUM_ITERACIONS = 10;
    private long tempsCreacio; // Moment en el que es construeix

    public DormAleatori(String name) {
        super(name);
        this.tempsCreacio = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_ITERACIONS; i++) {
            // Calcular temps total transcurrit
            long tempsTotal = System.currentTimeMillis() - tempsCreacio;

            // Generar l'interval aleatori
            int interval = (int)(Math.random() * 1000); 

            // Mostrar el missatge
            System.out.printf("%-10s a dormir %5dms total %5dms%n", 
                            getName() + "(" + i + ")", interval, tempsTotal);

            // Dormir
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Crear Joan
        DormAleatori joan = new DormAleatori("Joan");
        // Crear Pep
        DormAleatori pep = new DormAleatori("Pep");
        // Iniciar fils
        joan.start();
        pep.start();
        // Mostrar fi del main
        System.out.println("-- Fi del main ---------------------------");
    }

}
