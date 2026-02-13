public class Filosof extends Thread {
    private int numComensal;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    
    public Filosof(int numComensal, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.numComensal = numComensal;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = 0;
    }

    private void esperar(double min, double max) {
        try {
            double aleatori = Math.random() * (max - min) + min;
            long temps = (long)(aleatori * 1000);
            sleep(temps);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public void pensar() {
        System.out.println("Filòsof " + numComensal + " pensant");
        esperar(1, 2);
    }
    
    public void menjar() {
        System.out.println("Filòsof " + numComensal + " menja");
        esperar(1, 2);
        gana = 0;
    }

    public void agafarForquillaEsquerra() {
        
    }
    
    public void agafarForquillaDreta() {
    
    }
    
    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }
    
    public void deixarForquilles() {
        synchronized(forquillaEsquerra) {
            forquillaEsquerra.setPropietari(Forquilla.LLIURE);
            System.out.println("Filòsof " + numComensal + " deixa la forquilla esquerra " + forquillaEsquerra.getNumero());
            forquillaEsquerra.notifyAll();
        }
        
        synchronized(forquillaDreta) {
            forquillaDreta.setPropietari(Forquilla.LLIURE);
            System.out.println("Filòsof " + numComensal + " deixa la forquilla dreta " + forquillaDreta.getNumero());
            forquillaDreta.notifyAll();
        }
    }
    
    @Override
    public void run() {
        while (true) {
            pensar();
            agafarForquilles();
            menjar();
            deixarForquilles();
        }
    }

}
