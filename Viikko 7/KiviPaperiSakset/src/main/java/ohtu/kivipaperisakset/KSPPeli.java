
package ohtu.kivipaperisakset;

public abstract class KSPPeli {
    
    protected IO io;
    protected Tuomari tuomari;
    
    public KSPPeli(IO io) {
        this.io = io;
        this.tuomari = new Tuomari();
    }
    
    public abstract void pelaa();
    
    public static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    public void tulostaKiitokset(Tuomari tuomari) {
        io.println("");
        io.println("Kiitos!");
        io.println("" + tuomari);
    }
}
