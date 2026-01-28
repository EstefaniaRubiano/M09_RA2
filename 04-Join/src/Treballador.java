
import java.util.Random;


public class Treballador extends Thread {

    private final float SOU_ANUAL_BRUT; 
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd;

    public Treballador(String nom, float sou_anual_brut, int edat_inici_treball, int edat_fi_treball){
        super(nom);
        this.SOU_ANUAL_BRUT = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        edat_actual = 0;
        cobrat = 0.0f;
        this.rnd = new Random();
    }

    public float getCobrat() {
        return cobrat;
    }
    
    public int getEdat() {
        return edat_actual;
    }

    public void cobra(){
        float sou_mensual_brut = SOU_ANUAL_BRUT / 12.0f;
        cobrat += sou_mensual_brut;
    }

    public void pagaImpostos(){
        float impostos = (SOU_ANUAL_BRUT / 12.0f) * 0.24f;
        cobrat -= impostos;
    }

    @Override
    public void run(){
        for(int i = edat_inici_treball; i < edat_fi_treball; i++){
            for (int j = 0; j < 12; j++) {
                cobra();
                pagaImpostos();

                // Simula el temps que "pasa" el mes
                try {
                    Thread.sleep(rnd.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        edat_actual = edat_fi_treball;
    }
}
