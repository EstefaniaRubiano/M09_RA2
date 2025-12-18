/*
 * Classe PrincipalDiferents
 * Crea dos fils amb prioritats diferents.
 * Un fil s'executa més que l'altre.
 */

public class PrincipalDiferents {

    public static void main(String[] args) {

        // Fil Pepe amb prioritat baixa
        Fil filPepe = new Fil(
                "Pepe",
                Thread.MIN_PRIORITY,
                false,
                true
        );

        // Fil Juan amb prioritat alta
        Fil filJuan = new Fil(
                "Juan",
                Thread.MAX_PRIORITY,
                false,
                true
        );

        // Iniciem primer Pepe i després Juan
        filPepe.start();
        filJuan.start();

        System.out.println("Acaba thread main");
    }
}
