public class Filosof extends Thread {
    private long iniciGana;
    private long fiGana;
    private long gana;

    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;

    public Filosof(String nom) {
        super(nom);  
        this.gana = 0;
    }

    public void agafarForquillaEsquerra() {
        forquillaEsquerra.agafar();
    }

    public void agafarForquillaDreta() {
        forquillaDreta.agafar();
    }

    public void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    public void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
    }

    public void pensar() throws InterruptedException {
        iniciGana = System.currentTimeMillis();
        int temps = 1000 + (int)(Math.random() * 1000);
        Thread.sleep(temps);
    }

    public long calcularGana() {
        fiGana = System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000;
        return gana;
    }

    public void resetGana() {
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }

    public void menjar() throws InterruptedException {
        agafarForquilles();

        System.out.println(getName() + " té forquilles esq(" + 
            forquillaEsquerra.getNum() + ") dreta(" + forquillaDreta.getNum() + ")");
        System.out.println(getName() + " menja amb gana " + calcularGana());

        int temps = 1000 + (int)(Math.random() * 1000);
        Thread.sleep(temps);

        System.out.println(getName() + " ha acabat de menjar");
        System.out.println(getName() + " deixa les forquilles");

        resetGana();
        deixarForquilles();
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(getName() + " pensant");
                pensar();
                menjar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void setForquillaEsquerra(Forquilla f) {
        this.forquillaEsquerra = f;
    }

    public void setForquillaDreta(Forquilla f) {
        this.forquillaDreta = f;
    }
}
