public class Associacio {
    private final int numSocis = 1000;
    private Soci[] socis;
    
    public Associacio() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci("Soci-" + i);
        }
    }
    
    public void iniciaCompteTempsSoci() {
        Compte.getInstancia();
        for (Soci soci : socis) {
            soci.start();
        }
    }
   
    public void esperaPeriodeSocis() {
        for (Soci soci : socis) {
            try {
                soci.join(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes(){
        Compte compte = Compte.getInstancia();
        System.out.println("Saldo: " + compte.getSaldo());
    }
    
    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSoci();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }
}
