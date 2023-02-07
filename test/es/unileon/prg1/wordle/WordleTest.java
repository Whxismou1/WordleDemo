package es.unileon.prg1.wordle;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordleTest {
    private Wordle wordle;

    @Before
    public void setUp() throws Exception {
        this.wordle = new Wordle("etc/smallDictionary.txt", 7, 5);
    }

    @Test
    public void testGetTries() {
        assertEquals(5, this.wordle.getTries());
    }

    @Test
    public void testReturnTries() {
        assertEquals(5, wordle.returnTries());
    }

   



   


    @Test
    public void testIsWin() throws WordleException {
        assertFalse(wordle.isWin());
    }

    @Test
    public void testIsDefeat() throws WordleException {
        assertFalse(wordle.isDefeat());
    }    

	@Test
	public void testAdd() throws WordleException {
		String palabra = "FEBRERO";
		this.wordle.isAdd(palabra);
		this.wordle.paint();
	}

	
	@Test(expected=WordleException.class)
	public void testPaint() throws WordleException {
		this.wordle.paint();
	}
	
	@Test(expected=WordleException.class)
	public void testAddException() throws WordleException {
		this.wordle.isAdd("AAASAD");
	}
	
    @Test
    public void testCorrectWordDictionary() {
        assertTrue(wordle.correctWordDictionary("Octubre"));
    }

    @Test
    public void testToString() throws WordleException {
        Alphabet alphabet = new Alphabet();
        String secret = this.wordle.getWordSecret();
        assertTrue(wordle.toString().contains("\n//////\n"
        		+ "WORDLE" ));
    }

}
