package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] taulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm = 0;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti tai kasvatuskoko ei voi olla negatiininen");//heitin vaan jotain :D
        }
        taulukko = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (onkoTaulukossa(luku)) {
            return false;
        }
        taulukko[alkioidenLkm] = luku;
        alkioidenLkm++;
        kasvataTaulukkoa();
        return true;
    }

    public boolean onkoTaulukossa(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                return true;
            }
        }
        return false;
    }

    public int etsiTaulukosta(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                return i;
            }
        }
        return -1;
    }

    private void kasvataTaulukkoa() {
        if (alkioidenLkm == taulukko.length) {
            int[] taulukkoOld = new int[taulukko.length];
            kopioiTaulukko(taulukko, taulukkoOld);
            taulukko = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, taulukko);
        }
    }

    public boolean poista(int luku) {
        int kohta = etsiTaulukosta(luku);
        if (kohta != -1) {
            siirraTaulukkoaPoistonTakia(kohta);
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private void siirraTaulukkoaPoistonTakia(int kohta) {
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            taulukko[j] = taulukko[j + 1];
            taulukko[j + 1] = 0;
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        }
        String tuotos = "{";
        tuotos += luetteleTaulukonLuvut();

        return tuotos + taulukko[alkioidenLkm - 1] + "}";
    }

    private String luetteleTaulukonLuvut() {
        String tuotos = "";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += taulukko[i];
            tuotos += ", ";
        }
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = taulukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        lisaaTaulukostaAlkiot(a.toIntArray(), yhdiste);
        lisaaTaulukostaAlkiot(b.toIntArray(), yhdiste);

        return yhdiste;
    }

    private static void lisaaTaulukostaAlkiot(int[] taulu, IntJoukko joukko) {
        for (int i = 0; i < taulu.length; i++) {
            joukko.lisaa(taulu[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        return lisaaKuuluvatAlkiotEhdolla(a, b, true);
    }

    private static IntJoukko lisaaKuuluvatAlkiotEhdolla(IntJoukko aJoukko, IntJoukko bJoukko, boolean ehto) {
        IntJoukko kuuluvat = new IntJoukko();
        for (int i = 0; i < aJoukko.alkioidenLkm; i++) {
            if (bJoukko.onkoTaulukossa(aJoukko.taulukko[i]) == ehto) {
                kuuluvat.lisaa(aJoukko.taulukko[i]);
            }
        }
        return kuuluvat;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        return lisaaKuuluvatAlkiotEhdolla(a, b, false);
    }

}
