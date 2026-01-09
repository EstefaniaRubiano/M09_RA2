
public class MainDemoFil {
    public static void main(String[] args) {
        // Capturar el fil actual que s'està executant
        Thread filActual = Thread.currentThread(); 

        System.out.println("MainDemoFil.main:");

        System.out.println("Prioritat -> " + filActual.getPriority() + 
                            "\nNom -> " + filActual.getName() + 
                            "\ntoString() -> " + filActual.toString());
    }
}
