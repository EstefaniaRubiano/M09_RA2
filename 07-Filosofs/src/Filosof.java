public class Filosof extends Thread{
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;

    public Filosof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        super(nom);
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = 0;
    }

    public void pensar() {
        try {
            System.out.println("Filòsof: " + getName() + " pensant");
            Thread.sleep((long)(Math.random() * 1000 + 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void menjar() {
        boolean haMenjat = false;

        while (!haMenjat) {
            synchronized (forquillaEsquerra) {
                if (!forquillaEsquerra.isEnUs()) {
                    forquillaEsquerra.setEnUs(true);
                    System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra " + forquillaEsquerra.getN_forquilles());

                    synchronized(forquillaDreta) {
                        if (!forquillaDreta.isEnUs()) {
                            
                            forquillaDreta.setEnUs(true);
                            System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getN_forquilles());
                            System.out.println("Filòsof: " + getName() + " menja");
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) { 
            pensar();
            menjar();
        }

    }

}
