package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Map;

public class Paaohjelma {

    private static final IO io = new Komentorivi();
    private static PelinTyyppi tyyppi;
    private static Map<String, KPSPeli> valinnat;

    public static void main(String[] args) {
        tyyppi = new PelinTyyppi(io);
        
        while (true) {
            String vastaus = valikko();
            luoValinnat();
            if (valinnat.containsKey(vastaus)) {
                KPSPeli peli = valinnat.get(vastaus);
                peli.pelaa();
            } else {
                break;
            }
        }

    }

    private static void luoValinnat() {
        valinnat = new HashMap<String, KPSPeli>();
        valinnat.put("a", tyyppi.kaksinPeli("yksi", "kaksi"));
        valinnat.put("b", tyyppi.yksinPeliHelppo("yksi"));
        valinnat.put("c", tyyppi.yksinPeliVaikea("yksi"));
    }

    private static String valikko() {
        io.tulosta("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan\n");
        return io.lue();
    }
}
