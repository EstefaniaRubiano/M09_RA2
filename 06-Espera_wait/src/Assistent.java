public class Assistent extends Thread {
    private Esdeveniment esdeveniment;

    public Assistent (String nom, Esdeveniment esdeveniment) {
        super(nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (Math.random() < 0.5) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
                Thread.sleep((int) (Math.random() * 1000));
                
            } catch (InterruptedException e) {
                break;  
            }
        }
    }
}
