public class Taula {

    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
            filosofs[i] = new Filosof("Fil" + i);

        }

        // Asignar forquilles
        for (int i = 0; i < numFilosofs; i++) {
            if (i == numFilosofs - 1) {
                filosofs[i].setForquillaEsquerra(forquilles[0]);
                filosofs[i].setForquillaDreta(forquilles[i]);
            } else {
                filosofs[i].setForquillaEsquerra(forquilles[i]);
                filosofs[i].setForquillaDreta(forquilles[i + 1]);
            }
        }
    }


}
