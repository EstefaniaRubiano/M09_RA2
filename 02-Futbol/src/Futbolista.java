public class Futbolista extends Thread {

    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols = 0;
    private int ntirades = 0;

    public Futbolista(String nom) {
        super(nom);
    }

    public int getNgols() {
        return ngols;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
            ntirades++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Futbolista[] futbolistes = new Futbolista[NUM_JUGADORS];

        String[] noms = { "Piqué", "Vinicius", "Torres", "Ramos", "Rondaldo", "Lewandowski",
                "Nerea", "Tenz", "Aspas", "Bassit", "Yamin Lamal" };

        for (int i = 0; i < NUM_JUGADORS; i++) {
            futbolistes[i] = new Futbolista(noms[i]);
        }

        // Iniciar els fils
        System.out.println("Inici dels xuts ---------------------");
        for (int i = 0; i < NUM_JUGADORS; i++) {
            futbolistes[i].start();
        }
        // Esperar que acabin els fils
        for (int i = 0; i < NUM_JUGADORS; i++) {
            futbolistes[i].join(); 
        }
        System.out.println("Fi dels xuts ------------------------");

        System.out.println("--- Estadístiques -------------------");
        for (int i = 0; i < NUM_JUGADORS; i++) {
            System.out.println(futbolistes[i].getName() + " -> " + 
                                futbolistes[i].getNgols());
        }
    }
}
