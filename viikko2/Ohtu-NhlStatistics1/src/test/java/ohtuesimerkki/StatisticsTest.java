package ohtuesimerkki;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara
 */
public class StatisticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void etsiiOikeanPelaajan() {
        Player haettu = stats.search("Semenko");
        assertNotNull(haettu);
    }
    
    @Test
    public void etsiOlematonPelaaja() {
        Player haettu = stats.search("Sami");
        assertNull(haettu);
    }
    
    @Test
    public void etsiiJoukkoeenPelaajat() {
        List <Player> pelaajat = stats.team("EDM");
        
        assertEquals("Semenko", pelaajat.get(0).getName());
        assertEquals("Kurri", pelaajat.get(1).getName());
        assertEquals("Gretzky", pelaajat.get(2).getName());
    }
    
    @Test
    public void etsiiTopScorers() {
        List <Player> top = stats.topScorers(2);
        
       assertEquals("Gretzky", top.get(0).getName());
       assertEquals("Lemieux", top.get(1).getName()); 
    }
}
