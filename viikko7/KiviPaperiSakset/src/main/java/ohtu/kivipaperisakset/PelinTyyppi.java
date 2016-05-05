
package ohtu.kivipaperisakset;

/**
 *
 * @author Sara
 */
public class PelinTyyppi {
   private IO io;
   
   public PelinTyyppi(IO io) {
       this.io = io;
   }
   
   public KPSPeli kaksinPeli(String nimi1, String nimi2) {
       return new KPSPeli(this.io, new Ihminen(this.io, nimi1), new Ihminen(this.io, nimi2));
   }
   
   public KPSPeli yksinPeliHelppo(String nimi) {
       return new KPSPeli(this.io, new Ihminen(this.io, nimi), new Tekoaly());
   }
   
   public KPSPeli yksinPeliVaikea(String nimi) {
       return new KPSPeli(this.io, new Ihminen(this.io, nimi), new TekoalyParannettu(20));
   }
}
