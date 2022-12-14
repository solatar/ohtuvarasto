package ohtu.ohtuvarasto;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ohtu.ohtuvarasto.Varasto;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
        double saatuMaara = varasto.otaVarastosta(2);
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiLisätäNegatiivista() {
        varasto.lisaaVarastoon(-10);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void eiVoiOttaaNegatiivista() {
        varasto.otaVarastosta(-3);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }    
    
    
    @Test
    public void alkusaldonVoiAsettaa() {
        varasto = new Varasto(10, 8);
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void alkusaldoPositiivinen() {
        varasto = new Varasto(10, -8);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test 
    public void saldoEiMeneMiinukselle() {
        varasto = new Varasto(10, 4);
        varasto.otaVarastosta(5);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void tilavuusPositiivinen() {
        varasto = new Varasto(-3);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void tilavuusPositiivinen2() {
        varasto = new Varasto(-5, 0);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void alkusaldoEiYlitäTilavuutta() {
        varasto = new Varasto(5, 6);
        assertEquals(5, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void saldoEiYlitätilavuutta() {
        varasto.lisaaVarastoon(11);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void annetaanMaxSaldonVerran() {
        varasto = new Varasto(10, 5);
        double saatuMaara = varasto.otaVarastosta(7);
        assertEquals(5, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void merkkijonoesitysOikein() {        
        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }
}