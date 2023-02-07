package es.unileon.prg1.wordle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class WordTest {
    private Word palabra;
    private Word palabraS;

    @Before
    public void setUp() throws Exception
    {   
        String palabra = "calabaza";
        this.palabra=new Word(palabra);
    }

    

    @Test
	public void compareTest() throws Exception{
        this.palabra = new Word("vale");
        
        this.palabraS = new Word("hola");
        this.palabra.compare(palabraS);
        assertEquals("VALE", this.palabra.toString());
        assertEquals("[44m [37;1mV [0m[43;1m [37;1mA [0m[42;1m [37;1mL [0m[44m [37;1mE [0m", this.palabra.toStringColor());

	}
    
    @Test(expected = WordleException.class)
    public void getLetterTest() throws WordleException{
    	Word palabra = new Word("calabaza");
    	palabra.getLetter(10);
    }
    @Test
	public void esCorrectoTest() throws Exception{
		this.palabra = new Word("hola");
		assertFalse(palabra.correctWord());
		Word palabra = new Word("hola");
		this.palabra.compare(palabra);

	}


    @Test
    public void testToString(){
        String wordToSTring=this.palabra.toString();
        Letter c=new Letter('C');
        c.setColor(Colors.NONE);
        assertEquals(c.getLetter(), 'C');
    }
    
}
