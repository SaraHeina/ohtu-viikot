package ohtu.kivipaperisakset;

// "Muistava tekoäly"
public class TekoalyParannettu implements Pelaaja {

    private String[] muisti;
    private int vapaaMuistiIndeksi;

    public TekoalyParannettu(int muistinKoko) {
        muisti = new String[muistinKoko];
        vapaaMuistiIndeksi = 0;
    }

    @Override
    public void asetaSiirto(String siirto) {
        if (vapaaMuistiIndeksi == muisti.length) {
            System.arraycopy(muisti, 1, muisti, 0, muisti.length - 1);
      //for(int i = 1; i < muisti.length; i++) {
            //muisti[i-1] = muisti[i];
            //}
            vapaaMuistiIndeksi--;
        }

        muisti[vapaaMuistiIndeksi] = siirto;
        vapaaMuistiIndeksi++;
    }

    @Override
    public String annaSiirto() {
        if (vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
            System.out.println("Tietokone valitsi: k");
            return "k";
        }

        String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];

        int k = 0;
        int p = 0;
        int s = 0;

        for (int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
            if (viimeisinSiirto.equals(muisti[i])) {
                String seuraava = muisti[i + 1];

                if ("k".equals(seuraava)) {
                    k++;
                } else if ("p".equals(seuraava)) {
                    p++;
                } else {
                    s++;
                }
            }
        }

    // Tehdään siirron valinta esimerkiksi seuraavasti;
        // - jos kiviä eniten, annetaan aina paperi
        // - jos papereita eniten, annetaan aina sakset
        // muulloin annetaan aina kivi
        if (k > p && k > s) {
            System.out.println("Tietokone valitsi: p");
            return "p";
        } else if (p > k && p > s) {
            System.out.println("Tietokone valitsi: s");
            return "s";
        } else {
            System.out.println("Tietokone valitsi: k");
            return "k";
        }

    // Tehokkaampiakin tapoja löytyy, mutta niistä lisää 
        // Johdatus Tekoälyyn kurssilla!
    }
}
