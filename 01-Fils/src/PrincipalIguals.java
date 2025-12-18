/*
 * Classe PrincipalIguals
 * Crea dos fils amb la mateixa prioritat.
 * Els fils s'executen intercalats.
 */

public class PrincipalIguals {

    public static void main(String[] args) {

        // Creem dos fils amb la mateixa prioritat màxima
        Fil juan = new Fil(
                "Juan",
                Thread.MAX_PRIORITY,
                false, // sense sleep
                true // amb càrrega
        );

        Fil pepe = new Fil(
                "Pepe",
                Thread.MAX_PRIORITY,
                false,
                true
        );

        // Iniciar els fils
        juan.start();
        pepe.start();

        // El fil principal acaba
        System.out.println("Acaba thread main");
    }
}
