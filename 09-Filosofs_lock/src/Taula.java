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

    public void showTaula() {
        for (Filosof filosof : filosofs) {
            System.out.println("Comensal:" + filosof.getName() + 
                " esq:" + filosof.getForquillaEsquerra().getNum() + 
                " dret:" + filosof.getForquillaDreta().getNum());
        }
    }

    public void cridarATaula() {
        for (Filosof filosof : filosofs) {
            filosof.start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }

}
