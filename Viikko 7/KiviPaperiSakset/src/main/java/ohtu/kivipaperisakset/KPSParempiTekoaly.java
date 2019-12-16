package ohtu.kivipaperisakset;


// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends TekoalyPeli{


    public KPSParempiTekoaly(IO io, TekoalyIF tekoaly) {
        super(io, tekoaly);
    }
//
//    @Override
//    public void pelaa() {
//        TekoalyParannettu tekoaly = new TekoalyParannettu(20);
//
//        io.print("Ensimmäisen pelaajan siirto: ");
//        String ekanSiirto = io.nextLine();
//        String tokanSiirto;
//
//
//        tokanSiirto = tekoaly.annaSiirto();
//        io.println("Tietokone valitsi: " + tokanSiirto);
//
//
//        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
//            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
//            io.println("" + tuomari);
//            io.println("");
//
//            io.print("Ensimmäisen pelaajan siirto: ");
//            ekanSiirto = io.nextLine();
//
//            tokanSiirto = tekoaly.annaSiirto();
//            io.println("Tietokone valitsi: " + tokanSiirto);
//            tekoaly.asetaSiirto(ekanSiirto);
//
//        }
//
//          tulostaKiitokset(tuomari);
//
//    }

}
