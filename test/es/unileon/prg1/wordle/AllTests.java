package es.unileon.prg1.wordle;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BoardTest.class, SourceTest.class, LetterTest.class,
		WordleTest.class, WordTest.class, DictionaryTest.class, AlphabetTest.class })
public class AllTests {

}
