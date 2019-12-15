package ohtu.kivipaperisakset;

public class Pelitehdas {

    private IO io;

    public Pelitehdas(IO io) {
        this.io = io;
    }

    public KSPPeli luo(String vastaus) {

        if (vastaus.endsWith("a")) {
            tulostaPeliohjeet();
            return new KPSPelaajaVsPelaaja(io);
        } else if (vastaus.endsWith("b")) {
            tulostaPeliohjeet();
            return new KPSTekoaly(io);
        } else if (vastaus.endsWith("c")) {
            tulostaPeliohjeet();
            return new KPSParempiTekoaly(io);
        }
        return null;

    }

    public void suorita() {
        while (true) {
            tulostaValikkoMerkkijono();

            String vastaus = io.nextLine();

            KSPPeli peli = luo(vastaus);
            if (peli == null) {
                break;
            } else {
                peli.pelaa();
            }
        }
    }

    private void tulostaPeliohjeet() {
        io.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    }

    private void tulostaValikkoMerkkijono() {
        io.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
    }

}
