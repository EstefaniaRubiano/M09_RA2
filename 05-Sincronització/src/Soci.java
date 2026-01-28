import java.util.Random;

public class Soci extends Thread {
    private final Compte compte;
    private final float aportacio = 10f;
    private final int esperaMax = 100;
    private Random random;
    private final int maxAnys = 10;
    
    public Soci(String nom) {
        super(nom);
        this.compte = Compte.getInstancia();
        this.random = new Random();
    }
    
    public Compte getCompte() {
        return compte;
    }
    
    @Override
    public void run() {
        int totalMesos = maxAnys * 12; 
        
        for (int mes = 0; mes < totalMesos; mes++) {
            synchronized (compte) {
                float saldoActual = compte.getSaldo();
                
                if (mes % 2 == 0) {
                    compte.setSaldo(saldoActual + aportacio);
                } else {
                    compte.setSaldo(saldoActual - aportacio);
                }
            }
            
            try {
                Thread.sleep(random.nextInt(esperaMax));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
