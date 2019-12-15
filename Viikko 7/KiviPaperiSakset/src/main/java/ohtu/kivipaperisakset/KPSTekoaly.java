package ohtu.kivipaperisakset;

public class KPSTekoaly extends KSPPeli{

    public KPSTekoaly(IO io) {
        super(io);
    }

    @Override
    public void pelaa() {
        Tekoaly tekoaly = new Tekoaly();

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