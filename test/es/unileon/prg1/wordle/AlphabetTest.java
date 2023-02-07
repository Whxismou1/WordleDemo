package es.unileon.prg1.wordle;

//paquete aÃ±adido

//importacion de los paquetes de junit


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AlphabetTest{

    private Alphabet teclado;

    @Before
    public void setUp(){

        this.teclado=new Alphabet();
    }


    @Test
    public void constructorTest(){

        assertTrue(teclado.toString().contains("ABCDEFGH\nIJKLMNOP\nQRSTUVWX"));

    }

    @Test
    public void compareTest() throws WordleException{

        this.teclado.compare("dcba");
        assertTrue(this.teclado.toStringColored().contains("[47;1m [30;1mA [0m[47;1m [30;1mB [0m[47;1m [30;1mC [0m[47;1m [30;1mD [0m[44m [37;1mE [0m[44m [37;1mF [0m[44m [37;1mG [0m[44m [37;1mH [0m\n"
        		+ "[44m [37;1mI [0m[44m [37;1mJ [0m[44m [37;1mK [0m[44m [37;1mL [0m[44m [37;1mM [0m[44m [37;1mN [0m[44m [37;1mO [0m[44m [37;1mP [0m\n"
        		+ "[44m [37;1mQ [0m[44m [37;1mR [0m[44m [37;1mS [0m[44m [37;1mT [0m[44m [37;1mU [0m[44m [37;1mV [0m[44m [37;1mW [0m[44m [37;1mX [0m\n"
        		+ "[44m [37;1mY [0m[44m [37;1mZ [0m[44m"));
        /*assertEquals(Letter.ANSI_WHITE_BG + "A" + Letter.ANSI_RESET + Letter.ANSI_WHITE_BG  + "B" + Letter.ANSI_RESET +
                Letter.ANSI_WHITE_BG + "C" + Letter.ANSI_RESET + Letter.ANSI_WHITE_BG  + "D" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "E" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "F" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "G" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "H" + Letter.ANSI_RESET + "\n" +
                Letter.ANSI_BLUE_BG + "I" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "J" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "K" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "L" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "M" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "N" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "O" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "P" + Letter.ANSI_RESET + "\n" +
                Letter.ANSI_BLUE_BG + "Q" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "R" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "S" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "T" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "U" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "V" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "W" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "X" + Letter.ANSI_RESET + "\n" +
                Letter.ANSI_BLUE_BG + "Y" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "Z" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "�" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "�" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "�" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "�" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "�" + Letter.ANSI_RESET + Letter.ANSI_BLUE_BG  + "�" + Letter.ANSI_RESET +
                Letter.ANSI_BLUE_BG + "�" + Letter.ANSI_RESET, this.teclado.toStringColored());*/
    }
}