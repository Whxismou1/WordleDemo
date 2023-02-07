package es.unileon.prg1.wordle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SourceTest {

	private Source small;
	private Source tiny;
	private Source bad;
	private Source full;

	@Before
	public void setUp() throws Exception {
		this.small = new Source("./etc/smallDictionary.txt");
		this.tiny = new Source("./etc/tinyDictionary.txt");
		this.bad = new Source("./etc/badDictionary.txt");
		this.full = new Source("./etc/fullDictionary.txt");
	}

	@Test
	public void testSource() {
//		assertEquals("enero\n"
//				+ "febrero\n"
//				+ "marzo\n"
//				+ "abril\n"
//				+ "mayo\n"
//				+ "junio\n"
//				+ "julio\n"
//				+ "agosto\n"
//				+ "septiembre\n"
//				+ "octubre\n"
//				+ "noviembre\n"
//				+ "diciembre\n"
//				, this.small.toString());
	}

	@Test
	public void testGetSize() {
		assertEquals(12, this.small.getSize());
		assertEquals(9, this.bad.getSize());
		assertEquals(108790, this.full.getSize());
	}

	@Test
	public void testFirst() {
		this.small.first();
//		assertEquals("enero", this.small.getNext());
	}

	@Test
	public void testGetNext() {
		this.small.first();
//		assertEquals("enero", this.small.getNext());
	}

	@Test
	public void testHasNext() {
		assertTrue(this.tiny.hasNext());
//		assertEquals("uno", this.tiny.getNext());
//		assertEquals("dos", this.tiny.getNext());
//		assertEquals("tres", this.tiny.getNext());
//		assertFalse(this.tiny.hasNext());
	}

	@Test
	public void testToString() {
//		assertEquals("enero\n"
//				+ "febrero\n"
//				+ "marzo\n"
//				+ "abril\n"
//				+ "mayo\n"
//				+ "junio\n"
//				+ "julio\n"
//				+ "agosto\n"
//				+ "septiembre\n"
//				+ "octubre\n"
//				+ "noviembre\n"
//				+ "diciembre\n"
//				, this.small.toString());
//		assertEquals("\n"
//				+ "uno\n"
//				+ "   dos   \n"
//				+ "		tres		\n"
//				+ "\n"
//				+ "		\n"
//				+ "		\n"
//				+ "fin\n"
//				+ "\n"
//				, this.bad.toString());
	}

}
