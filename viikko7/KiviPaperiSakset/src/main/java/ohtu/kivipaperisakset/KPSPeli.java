package ohtu.kivipaperisakset;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sara
 */
public class KPSPeli {

    protected IO io;
    protected Tuomari tuomari;
    protected Pelaaja pelaaja1;
    protected Pelaaja pelaaja2;
    private List<String> sallitutSiirrot;

    public KPSPeli(IO ioOlio, Pelaaja pelaajaYksi, Pelaaja pelaajaKaksi) {
        this.io = ioOlio;
        this.tuomari = new Tuomari();
        this.pelaaja1 = pelaajaYksi;
        this.pelaaja2 = pelaajaKaksi;
        luoSallitutSiirrot();
    }

    private void luoSallitutSiirrot() {
        sallitutSiirrot = new ArrayList<String>();
        sallitutSiirrot.add("k");
        sallitutSiirrot.add("s");
        sallitutSiirrot.add("p");
    }

    public void pelaa() {
        tulostaOhjeet();
        aloitaPeli();
        tulostaTulokset();
    }

    private boolean onkoSallittuSiirto(String siirto) {
        return sallitutSiirrot.contains(siirto);
    }

    private void tuomitse(String eka, String toka) {
        tuomari.kirjaaSiirto(eka, toka);
        io.tulosta(tuomari + "\n\n");
    }

    private void aloitaPeli() {
        String siirto1 = this.pelaaja1.annaSiirto();
        if (onkoSallittuSiirto(siirto1) == false) {
            return;
        }

        String siirto2 = this.pelaaja2.annaSiirto();

        while (onkoSallittuSiirto(siirto1) && onkoSallittuSiirto(siirto2)) {
            tuomitse(siirto1, siirto2);

            siirto1 = this.pelaaja1.annaSiirto();
            if (onkoSallittuSiirto(siirto1) == false) {
                break;
            }

            siirto2 = this.pelaaja2.annaSiirto();
            this.pelaaja2.asetaSiirto(siirto1);
        }
    }
    
    private void tulostaOhjeet() {
        io.tulosta("\nPeli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s\n\n");
    }
    
    private void tulostaTulokset() {
        io.tulosta("\nKiitos!\n" + tuomari + "\n");
    }
}
