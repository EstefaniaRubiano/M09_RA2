/*
 * Classe PrincipalEstricte
 * Crea dos fils que s'executen de manera alterna.
 */

public class PrincipalEstricte {

    public static void main(String[] args) {

        Fil filJuan = new Fil(
                "Juan",
                Thread.NORM_PRIORITY,
                true,   // usem sleep
                false   // sense càrrega
        );

        Fil filPepe = new Fil(
                "Pepe",
                Thread.NORM_PRIORITY,
                true,
                false
        );

        // Iniciem els fils
        filJuan.start();
        filPepe.start();

        System.out.println("Termina thread main");
    }
}
