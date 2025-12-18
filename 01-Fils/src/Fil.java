/*
 * Classe Fil
 * Aquesta classe crea un fil d'execució.
 * El fil mostra el seu nom i un comptador.
 */

public class Fil extends Thread {

    // Indica si el fil ha de fer una pausa amb sleep o no
    private boolean usarSleep;  
    // Indica si el fil ha de simular una càrrega de feina o no
    private boolean usarCarrega;  

    // Constructor del fil
    public Fil(String nomFil, int prioritat, boolean usarSleep, boolean usarCarrega) {
        this.setName(nomFil); // Assignem el nom al fil
        this.setPriority(prioritat); // Assignem la prioritat
        this.usarSleep = usarSleep;
        this.usarCarrega = usarCarrega;
    }

    @Override
    public void run() {

        // El fil compta del 1 al 9
        for (int i = 1; i <= 9; i++) {

            System.out.println(getName() + " " + i);

            // Simular treball amb càrrega (bucle fins a 1000)
            if (usarCarrega) {
                for (int j = 0; j < 1000; j++) {
                    // NO fa res, només és per simular càrrega
                }
            }

            // Simular alternancia estricta amb sleep
            if (usarSleep) {
                try {
                    Thread.sleep(1); // 1 ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Missatge de finalització del fil
        System.out.println("Acaba el fil " + getName());
    }
}
