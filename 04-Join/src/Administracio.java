public class Administracio {

    private final int NUM_POBLACIO_ACTIVA = 50;
    private final Treballador[] POBLACIO_ACTIVA;

    public Administracio() {
        POBLACIO_ACTIVA = new Treballador[NUM_POBLACIO_ACTIVA];

        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            String nom = "Ciutadà-" + i;
            POBLACIO_ACTIVA[i] = new Treballador(nom, 25000f, 20, 65);
        }
    }

    private void mostrarEstadistiques() {
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            Treballador t = POBLACIO_ACTIVA[i];
            System.out.printf("%s -> edat: %d / total: %.2f%n", 
                              t.getName(), 
                              t.getEdat(), 
                              t.getCobrat());
        }
    }
    public static void main(String[] args) {
        Administracio admin = new Administracio();

        for (int i = 0; i < admin.NUM_POBLACIO_ACTIVA; i++) {
            admin.POBLACIO_ACTIVA[i].start();
        }

        for (int i = 0; i < admin.NUM_POBLACIO_ACTIVA; i++) {
            try {
                admin.POBLACIO_ACTIVA[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        admin.mostrarEstadistiques();
        
    }

}
