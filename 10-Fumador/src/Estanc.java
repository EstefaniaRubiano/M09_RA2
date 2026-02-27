
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {
    private List<Tabac> llistaTabac;
    private List<Paper> llistaPaper;
    private List<Llumi> llistaLlumi;
    private boolean obert;
    private Random random;

    public Estanc() {
        llistaTabac = new ArrayList<>();
        llistaPaper = new ArrayList<>();
        llistaLlumi = new ArrayList<>();
        obert = false;
        random = new Random();
    }

    public synchronized void addTabac() {
        llistaTabac.add(new Tabac());
        System.out.println("Afegint Tabac");
        notifyAll();
    }

    public synchronized void addLlumi() {
        llistaLlumi.add(new Llumi());
        System.out.println("Afegint Llumí");
        notifyAll();
    }

    public synchronized void addPaper() {
        llistaPaper.add(new Paper());
        System.out.println("Afegint Paper");
        notifyAll();
    }

    public void nouSubministrament() {
        int opcio = random.nextInt(3);
        switch (opcio) {
            case 0 -> addTabac();
            case 1 -> addPaper();
            default -> addLlumi();
        }
    }

    private synchronized <Producte> Producte venProducte(List<Producte> llista) throws InterruptedException {
        while (llista.isEmpty() && obert) {
            wait();
        }
        if (!llista.isEmpty()) {
            return llista.remove(0);
        }
        return null;
    }

    public Tabac venTabac() throws InterruptedException {
        return venProducte(llistaTabac);
    }
    public Paper venPaper() throws InterruptedException {
        return venProducte(llistaPaper);
    }
    public Llumi venLlumi() throws InterruptedException {
        return venProducte(llistaLlumi);
    }

    public synchronized void tancarEstanc() {
        obert = false;
        System.out.println("Estanc tancat");
        notifyAll();
    }

    @Override
    public void run() {
        obert = true;
        System.out.println("Estanc obert");
        while (obert) {
            nouSubministrament();
            try {
                int espera = 500 + random.nextInt(1001);
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
