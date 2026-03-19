public class Barber extends Thread {

    public Barber(String nom) {
        super(nom);  
    }

    @Override
    public void run() {
        while (true) {
            Client client = Barberia.barberia.seguentClient();

            if (client != null) {
                System.out.println("Li toca al client " + client.getNom());
                client.tallarseElCabell();
                
                try {
                    Thread.sleep(900 + (long)(Math.random() * 100));
                } catch (InterruptedException e) {}

            } else {
                System.out.println("Barber " + getName() + " dormint");
                
                synchronized (Barberia.barberia.condBarber) {
                    try {
                        Barberia.barberia.condBarber.wait();
                    } catch (InterruptedException e) {}
                }
            }
        }
    }
}
