
public class Motor extends Thread {

    private int potenciaActual;   // Potencia actual del motor
    private int potenciaObjectiu; // Potencia objetiu
    private int numMotor;         // Num identificador del motor 

    public Motor(int numMotor) {

    }

    public void setPotencia(int p) {
        // Establir la potència objectiu
    }

    @Override
    public void run() {
        // bucle infinit
        // Compara potenciaActual con potenciaObjectiu
        // Si actual < objectiu -> mostrar "Incre."
        // Si actual > objectiu -> mostrar "Decre."
        // Si actual == objectiu -> mostrar "FerRes"
        // Si potenciaObjectiu == 0 y actual == 0 -> sortir del bucle
        // Dormir un interval aleatori entre 1-2 segons
    }
}
