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

    private void esperar(double min, double max) {
        try {
            double numeroAleatori = Math.random() * (max - min) + min;
            long tempsEspera = (long)(numeroAleatori * 1000);
            sleep(tempsEspera);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public void pensar() {
        System.out.println("Filòsof: " + getName() + " pensant");
        esperar(1, 2); // 1-2 segundos
    }

    public void menjar() {
        System.out.println("Filòsof: " + getName() + " menja");
        esperar(1, 2); 
        if(gana > 0){                                                           //evitar numeros negatius
        gana--;
        }
    }

    @Override
    public void run() {
        while (gana < 4) { 
            if (forquillaEsquerra.isEnUs()) {
                esperar(0.5, 1);
                
            } else {
                forquillaEsquerra.setEnUs(true);
                System.out.println("Filòsof: " + getName() + " agafa la forquilla esquerra " + forquillaEsquerra.getN_forquilles());
                
                if (forquillaDreta.isEnUs()) {
                    forquillaEsquerra.setEnUs(false);
                    System.out.println("Filòsof: " + getName() + " deixa l'esquerra(" + forquillaEsquerra.getN_forquilles() + ") i espera (dreta ocupada)");
                    
                    esperar(0.5, 1);
                    
                    if (gana < 3) gana++;
                    System.out.println("Filòsof: " + getName() + " gana=" + gana);
                    
                } else {
                    forquillaDreta.setEnUs(true);
                    System.out.println("Filòsof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getN_forquilles());
                    
                    menjar();
                    
                    forquillaDreta.setEnUs(false);
                    forquillaEsquerra.setEnUs(false);
                    
                    pensar();
                }
            }
        }
    }
}

