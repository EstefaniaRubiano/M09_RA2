public class Assistent extends Thread {
    private Esdeveniment esdeveniment;

    public Assistent (String nom, Esdeveniment esdeveniment) {
        super(nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        
    }
}
