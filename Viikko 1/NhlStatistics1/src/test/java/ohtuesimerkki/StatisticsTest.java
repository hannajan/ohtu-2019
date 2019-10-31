package ohtuesimerkki;

import java.util.List;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;
    ArrayList<Player> lista;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
        lista = new ArrayList<>();
    }
    
    @Test
    public void tulostaaParhaanPelaajan() {
        lista.add(new Player("Gretzky", "EDM", 35, 89));
        String paras = lista.toString();
        
        assertEquals(paras, stats.topScorers(1).toString());
        
    }
    
    @Test
    public void pelaajaHakuToimii() {
        lista.add(stats.search("emen"));
        String pelaaja = lista.get(0).toString();
        
        String oikea = "Semenko              EDM  4 + 12 = 16";
        
        assertEquals(oikea, pelaaja);
    }
    
    @Test
    public void palauttaaNullKunEiLoydyPelaajaa() {
        lista.add(stats.search("Haisuli"));
        
        assertEquals(null, lista.get(0));
    }
    
    @Test
    public void joukkueenPelaajienHakuToimii() {
        lista.add(new Player("Semenko", "EDM", 4, 12));
        lista.add(new Player("Kurri", "EDM", 37, 53));
        lista.add(new Player("Gretzky", "EDM", 35, 89));
        
        assertEquals(lista.toString(), stats.team("EDM").toString());
    }
}
