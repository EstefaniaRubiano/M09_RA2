import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread {

    private Queue<Client> salaEspera = new LinkedList<>();
    private int maxCadires;
    public Object condBarber = new Object();
    public static Barberia barberia;

    public Barberia(int numCadires) {
        this.maxCadires = numCadires;
    }

    public synchronized Client seguentClient() {
        if (salaEspera.isEmpty()) {
            System.out.println("Ningú en espera");  
        }
        return salaEspera.poll();
    }

    public synchronized void entrarClient(Client c) {
        if (salaEspera.size() < maxCadires) {
            System.out.println("Client " + c.getNom() + " en espera");
            salaEspera.add(c);

            synchronized (condBarber) {
                condBarber.notify();
            }
        } else {
            System.out.println("No queden cadires, client " + c.getNom() + " se'n va");
        }
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            entrarClient(new Client(i));
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }

        try { Thread.sleep(10000); } catch (InterruptedException e) {}

        for (int i = 11; i <= 20; i++) {
            entrarClient(new Client(i));
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        barberia = new Barberia(3);
        Barber barber = new Barber("Pepe");
        barber.start();
        barberia.start();
    }
}
