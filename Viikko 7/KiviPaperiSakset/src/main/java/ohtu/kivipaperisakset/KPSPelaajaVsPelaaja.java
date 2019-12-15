package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KSPPeli {

    //private static final Scanner scanner = new Scanner(System.in);

    public KPSPelaajaVsPelaaja(IO io) {
        super(io);
    }

    @Override
    public void pelaa() {

        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.nextLine();
        io.print("Toisen pelaajan siirto: ");
        String tokanSiirto = io.nextLine();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.println("" + tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.nextLine();
            
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = io.nextLine();
        }

        tulostaKiitokset(tuomari);
    }

}