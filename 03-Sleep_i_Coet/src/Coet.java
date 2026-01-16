
public class Coet {
    private static final int NUM_MOTORS = 4;
    private static final int MIN_POTENCIA = 0;
    private static final int MAX_POTENCIA = 10;

    private Motor[] motors;

    public Coet() {

    }

    public void arranca() {
        // iniciar els 4 motors
    }

    public void passaAPotencia(int p) {
        // Comprobar si p està entre 0 i 10
        // Si NO està en rang -> mostrar error i return
        // Si SI està en rang -> mostrar "Passant a potència p"
        // Cridar a setPotencia(p) en els 4 motors
    }

    public static void main(String[] args) {
        // Crear un objecte Coet
        // Arrencar el coet (truca a arranca())
        // Crear un Scanner para leer de consola
        // Bucle infinito:
        //  - Leer un número entero
        //  - Llamar a passaAPotencia(numero)
        //  - Si el número es 0, salir del bucle
        // Cerrar Scanner
    }
}
