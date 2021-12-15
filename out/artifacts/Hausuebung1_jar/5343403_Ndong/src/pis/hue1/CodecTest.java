package pis.hue1;

import org.junit.Test;

import static org.junit.Assert.*;

/*
Instruktionen:

1.  Der folgende Testfall muss von ihrem Programm bestanden werden.
2.  Sie dürfen den Testfall nicht abändern/anpassen.
3.  Sie muessen das JUnit Framework ggf. in ihr Projekt einbinden.
4.  Alle Plagiate werden abgelehnt und die Autoren können somit nicht an der Klausur teilnehmen.

Achtung!  Dieser Test ist nicht vollstaendig und dient lediglich als Anhaltspunkt einer korrekten Abgabe.
          In erster Linie stellt der Test eine korrekte Abgabestruktur sicher.

Viel Spaß und Erfolg beim Programmieren ;)
*/

public class CodecTest {

    Codec codec_1 = new Wuerfel("THM");
    Codec codec_2 = new Wuerfel("Mittelhessen");
    Codec codec_3 = new Caesar();

    @Test
    public void testKodiereWuerfel() {
        assertEquals("rza  me rhoeTiu r yn1471?a gikptvwrsna edcBe,2580Fnjtmoltealt xqruhar 369!", codec_1.kodiere("Franz jagt im komplett verwahrlosten Taxi quer durch Bayern, 12345678910!?"));
        assertEquals(" ridtr ntelao7r5a3eypBohziaaF !m kcmurT?n0t9e1s8l6r1v,trh4w2e au  nx  gejq", codec_2.kodiere("rza  me rhoeTiu r yn1471?a gikptvwrsna edcBe,2580Fnjtmoltealt xqruhar 369!"));

        codec_1.setzeLosung("Schwarzwald");
        codec_2.setzeLosung("Schwenningen");

        assertEquals("rneregnfirsrtdeulnsptnveoedtmeeregteaefntnfuei", codec_1.kodiere("eintreffendersendungverspaetetneuerterminfolgt"));
        assertEquals("ndeeelmtsvtrngieedffprugnennsefiteereertoarutn", codec_2.kodiere("rneregnfirsrtdeulnsptnveoedtmeeregteaefntnfuei"));
    }

    @Test
    public void testDekodiereWuerfel() {
        codec_1.setzeLosung("Schwarzwald");
        codec_2.setzeLosung("Schwenningen");

        assertEquals("eintreffendersendungverspaetetneuerterminfolgt", codec_1.dekodiere("rneregnfirsrtdeulnsptnveoedtmeeregteaefntnfuei"));
        assertEquals("rneregnfirsrtdeulnsptnveoedtmeeregteaefntnfuei", codec_2.dekodiere("ndeeelmtsvtrngieedffprugnennsefiteereertoarutn"));

        codec_1.setzeLosung("THM");
        codec_2.setzeLosung("Mittelhessen");

        assertEquals("Franz jagt im komplett verwahrlosten Taxi quer durch Bayern, 12345678910!?", codec_1.dekodiere("rza  me rhoeTiu r yn1471?a gikptvwrsna edcBe,2580Fnjtmoltealt xqruhar 369!"));
        assertEquals("rza  me rhoeTiu r yn1471?a gikptvwrsna edcBe,2580Fnjtmoltealt xqruhar 369!", codec_2.dekodiere(" ridtr ntelao7r5a3eypBohziaaF !m kcmurT?n0t9e1s8l6r1v,trh4w2e au  nx  gejq"));
    }

    @Test
    public void testGibLosung() {
        assertEquals("THM", codec_1.gibLosung());
        assertEquals("Mittelhessen", codec_2.gibLosung());
        codec_1.setzeLosung("Schwarzwald");
        codec_2.setzeLosung("Schwenningen");
        assertEquals("Schwarzwald", codec_1.gibLosung());
        assertEquals("Schwenningen", codec_2.gibLosung());
    }

    @Test
    public void testKodiereCeasar() {
        codec_3.setzeLosung("Schwarzwald");
        assertEquals("ptyecpqqpyopcdpyofyrgpcdalpepeypfpcepcxtyqzwre", codec_3.kodiere("eintreffendersendungverspaetetneuerterminfolgt"));
    }

    @Test
    public void testDekodiereCaesar() {
        codec_3.setzeLosung("Mittelhessen");
        assertEquals("Franz jagt im komplett verwahrlosten Taxi quer durch Bayern, 12345678910!?", codec_3.dekodiere("Rdmzl vmsf uy waybxqff hqdimtdxaefqz Fmju cgqd pgdot Nmkqdz, 12345678910!?"));

    }

    @Test
    public void testGibLosungCaesar() {
        codec_3.setzeLosung("Mittelhessen");
        assertEquals("Mittelhessen", codec_3.gibLosung());
        codec_3.setzeLosung("Schwarzwald");
        assertEquals("Schwarzwald", codec_3.gibLosung());
    }

}