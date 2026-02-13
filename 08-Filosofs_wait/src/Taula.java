public class Taula {
    private Filosof[] comensals;
    private Forquilla[] forquilles;
    
    public Taula(int numFilosofs) {
        // Crear forquilles
        forquilles = new Forquilla[numFilosofs];
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }
        
        // Crear filòsofs
        comensals = new Filosof[numFilosofs];
        for (int i = 0; i < numFilosofs; i++) {
            Forquilla esq = forquilles[i];
            Forquilla dret = forquilles[(i + 1) % numFilosofs];
            comensals[i] = new Filosof(i, esq, dret);
        }
    }
    
    public void showTaula() {
        for (int i = 0; i < comensals.length; i++) {
            int esq = i;
            int dret = (i + 1) % comensals.length;
            System.out.println("Comensal: fil" + i + " esq:" + esq + " dret:" + dret);
        }
        System.out.println("-------------------------------------------");
    }
    
    public void cridarATaula() {
        for (Filosof filosof : comensals) {
            filosof.start();
        }
    }
    
    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}
