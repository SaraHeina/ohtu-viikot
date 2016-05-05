
package ohtu.kivipaperisakset;

public class Ihminen implements Pelaaja{
    
    private final IO io;
    private final String pelaajanNumero;

    public Ihminen(IO ioOlio, String numero) {
        this.io = ioOlio;
        this.pelaajanNumero = numero;
    }
    
    @Override
    public String annaSiirto() {
        io.tulosta("Pelaajan " + this.pelaajanNumero + " siirto: " );
        return io.lue();
    }

    @Override
    public void asetaSiirto(String siirto) {
    }
    
}
