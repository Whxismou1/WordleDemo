package es.unileon.prg1.wordle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DictionaryTest {
    private Dictionary dictionary1;
    private Dictionary dictionary2;


    @Before
    public void setUp() throws WordleException {
        String ruta1="etc/fullDictionary.txt";
        String ruta2="etc/smallDictionary.txt";
        dictionary1=new Dictionary(ruta1, 5);
        dictionary2=new Dictionary(ruta2, 4);
    }


    @Test
    public void testRandomWord() throws WordleException
    {
        assertTrue(this.dictionary1.randomWord().length()==5);
    }

    @Test
    public void testIsInDictionary()
    {
        boolean isIn=dictionary2.isInDictionary("MAYO");
        assertTrue(isIn);
        isIn=dictionary2.isInDictionary("Hola");
        assertFalse(isIn);
    }

}
