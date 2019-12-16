
package ohtu.kivipaperisakset;


public abstract class TekoalyPeli extends KSPPeli {
    
    TekoalyIF tekoaly;
    
    public TekoalyPeli(IO io, TekoalyIF tekoaly) {
        super(io);
        this.tekoaly = tekoaly;
    }
    
    public void pelaa() {

        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.nextLine();
        String tokanSiirto;

        tokanSiirto = tekoaly.annaSiirto();
        io.println("Tietokone valitsi: " + tokanSiirto);


        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.println("" + tuomari);
            io.println("");

            io.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.nextLine();

            tokanSiirto = tekoaly.annaSiirto();
            io.println("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);

        }

        tulostaKiitokset(tuomari);
    }

    
}
