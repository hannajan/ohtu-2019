package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        joukko = new int[KAPASITEETTI];
        alkioidenLkm = 0;
        kasvatuskoko = KAPASITEETTI;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti ei saa olla negatiivinen");
        }
        joukko = new int[kapasiteetti];
        alkioidenLkm = 0;
        kasvatuskoko = kapasiteetti;

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti ei saa olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei saa olla negatiivinen");
        }
        joukko = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluuJoukkoon(luku)) {
            joukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == joukko.length) {
                kasvataJoukonKapasiteettia();
            }
            return true;
        }
        return false;
    }

    private void kasvataJoukonKapasiteettia() {
        int[] joukkoKopio = new int[joukko.length];
        kopioiTaulukko(joukko, joukkoKopio);
        joukko = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(joukkoKopio, joukko);
    }

    public boolean kuuluuJoukkoon(int luku) {       
        for (int i = 0; i < alkioidenLkm; i++) {
            if(joukko[i] == luku) return true;
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                kohta = i; //luku löytyi taulukon kohdasta i
                break;
            }
        }
        if (kohta != -1) {
            siirraLoputLuvut(kohta);
            return true;
        }
        return false;
    }

    private void siirraLoputLuvut(int kohta) {
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            joukko[j] = joukko[j + 1];
        }
        alkioidenLkm--;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int getAlkioidenMaara() {
        return alkioidenLkm;
    }
    
    public int getAlkio(int index) {
        return joukko[index];
    }
    

    @Override
    public String toString() {
        String merkkijono = "{";
        for(int i = 0; i < alkioidenLkm - 1; i++) {
            merkkijono += joukko[i] + ", ";
        }
        if(alkioidenLkm > 0) {
            merkkijono += joukko[alkioidenLkm - 1];
        }
        merkkijono += "}";
        return merkkijono;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko(a.alkioidenLkm + b.alkioidenLkm);
        for (int i = 0; i < a.getAlkioidenMaara(); i++) {
            yhdiste.lisaa(a.getAlkio(i));
        }
        for (int i = 0; i < b.getAlkioidenMaara(); i++) {
            yhdiste.lisaa(b.getAlkio(i));
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        for (int i = 0; i < a.getAlkioidenMaara(); i++) {
            int alkio = a.getAlkio(i);
            if (b.kuuluuJoukkoon(alkio)) {
                leikkaus.lisaa(alkio);
            }
            
        }
        return leikkaus;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        IntJoukko leikkaus = leikkaus(a, b);
        for (int i = 0; i < a.getAlkioidenMaara(); i++) {
            int alkio = a.getAlkio(i);
            if(!leikkaus.kuuluuJoukkoon(alkio)) {
                erotus.lisaa(alkio);
            }
        }
        return erotus;
    }

}
