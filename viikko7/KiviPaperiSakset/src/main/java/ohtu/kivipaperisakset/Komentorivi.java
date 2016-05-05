
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author Sara
 */
public class Komentorivi implements IO{
    private final Scanner lukija;
    
    public Komentorivi() {
        this.lukija = new Scanner(System.in);
    }

    @Override
    public void tulosta(String tuloste) {
        System.out.print(tuloste);
    }

    @Override
    public String lue() {
        return this.lukija.nextLine();
    }
    
}
