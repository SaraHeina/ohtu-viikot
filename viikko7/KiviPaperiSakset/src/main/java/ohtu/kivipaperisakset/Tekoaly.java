package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Map;

public class Tekoaly implements Pelaaja{

    private int siirto;
    private Map<Integer, String> siirrot;

    public Tekoaly() {
        siirto = 0;
        luoSiirrot();
    }
    
    private void luoSiirrot() {
        siirrot = new HashMap<Integer,String>();
        siirrot.put(0, "k");
        siirrot.put(1, "p");
        siirrot.put(2, "s");
    }

    @Override
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        System.out.println("Tietokone valitsi: " + siirrot.get(siirto));
        return siirrot.get(siirto);
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }

}
