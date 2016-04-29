/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;


public class Nollaa implements Komento{
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;
    private int syote;
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
         this.sovellus = sovellus;
         this.tuloskentta = tuloskentta;
         this.syotekentta = syotekentta;
     }

    @Override
    public void suorita() {
        this.edellinen = Integer.parseInt(tuloskentta.getText());
        sovellus.nollaa();
        tuloskentta.setText(Integer.toString(sovellus.tulos()));
        syotekentta.setText("");
    }

    @Override
    public void peru() {
        tuloskentta.setText(Integer.toString(edellinen));
        sovellus.plus(edellinen);
    }
    
}
