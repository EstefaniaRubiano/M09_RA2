
public class Compte {
    private static Compte instancia = null;
    private float saldo;

    private Compte() {
        this.saldo = 0f;
    }

    public static Compte getInstancia() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
