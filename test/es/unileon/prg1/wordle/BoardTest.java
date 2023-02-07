package es.unileon.prg1.wordle;

//paquete añadido

//importacion de los paquetes de junit


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BoardTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Board board;

    @Before
    public void setUp() throws WordleException {
        this.board = new Board(7, 7);
    }


    @Test
    public void testisWin() throws WordleException{
    	
    	Board palabra = new Board(4, 1);
    	assertFalse(palabra.isWin());
        palabra.add("hola");
        Word word = new Word("hola");
        palabra.paintLast(word);
        assertEquals(true, palabra.isWin());
    }

    @Test(expected = WordleException.class)
    public void testPaintException() throws WordleException {
    	Word palabra = new Word(3);
    	
    	board.paintLast(palabra);
    }
    @Test
    public void testReturnIntentos(){
        
        assertEquals(7,this.board.returnTries());
    }

    @Test
    public void testIsDefeat() throws WordleException {
        Board palabra = new Board(4, 1);
        palabra.add("hola");
        assertEquals(true, palabra.isDefeat());
    }


    @Test(expected = WordleException.class)
    public void testAdd() throws WordleException{
        Word randomWord = new Word("Word");
        Board boardActual = new Board(4, 1);
        boardActual.add("papá");
        boardActual.add("word");
    }

    @Test
    public void testToString() throws WordleException{
        assertEquals("       \n"
        		+ "       \n"
        		+ "       \n"
        		+ "       \n"
        		+ "       \n"
        		+ "       \n"
        		+ "       \n", this.board.toString());
    	Word palabra = new Word("holamun");
    	this.board.add("holamun");
    	assertEquals("HOLAMUN\n"
        		+ "       \n"
        		+ "       \n"
        		+ "       \n"
        		+ "       \n"
        		+ "       \n"
        		+ "       \n", this.board.toString());    
    	}
    
    @Test
    public void testToStringColor() throws WordleException{
        assertEquals("[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
        		+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
        		+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
        		+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
        		+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
        		+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
        		+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
        		+ "", this.board.toStringColor());
    	this.board.add("holamun");
    	assertEquals("[44m [37;1mH [0m[44m [37;1mO [0m[44m [37;1mL [0m[44m [37;1mA [0m[44m [37;1mM [0m[44m [37;1mU [0m[44m [37;1mN [0m\n"
    			+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
    			+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
    			+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
    			+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
    			+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
    			+ "[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m[44m [37;1m  [0m\n"
    			+ "", this.board.toStringColor());    
    	}



}
