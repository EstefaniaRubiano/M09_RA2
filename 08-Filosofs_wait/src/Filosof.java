public class Filosof extends Thread {
    private int numComensal;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    
    public Filosof(int numComensal, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        super("fil" + numComensal);
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
        System.out.println("Filòsof: " + getName() + " pensant");
        esperar(1, 2);
    }
    
    public void menjar() {
        System.out.println("Filòsof: " + getName() + " menja");
        esperar(1, 2);
        gana = 0;
    }

    public void agafarForquillaEsquerra() {
        synchronized(forquillaEsquerra) {
            while (forquillaEsquerra.getPropietari() != Forquilla.LLIURE) {
                try {
                    forquillaEsquerra.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            forquillaEsquerra.setPropietari(numComensal);
            System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra " + forquillaEsquerra.getNumero());
        }
    }
    
    public void agafarForquillaDreta() {
        synchronized(forquillaDreta) {
            while (forquillaDreta.getPropietari() != Forquilla.LLIURE) {
                try {
                    forquillaDreta.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            forquillaDreta.setPropietari(numComensal);
            System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getNumero());
        }
    }
    
    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }
    
    public void deixarForquilles() {
        synchronized(forquillaEsquerra) {
            forquillaEsquerra.setPropietari(Forquilla.LLIURE);
            forquillaEsquerra.notifyAll();
        }
        
        synchronized(forquillaDreta) {
            forquillaDreta.setPropietari(Forquilla.LLIURE);
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
