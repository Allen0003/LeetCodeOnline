package One2Twenty;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestL013 {
	L013_E l013;

	@Before
	public void createClass() {
		l013 = new L013_E();
	}

	@Test
	public void test() {
		assertTrue(l013.romanToInt("C") == 100);
	}

	@Test
	public void test2() {
		assertTrue(l013.romanToInt("L") == 50);
	}

	@Test
	public void test3() {
		assertTrue(l013.romanToInt("XL") == 40);
	}

	@Test
	public void test4() {
		assertTrue(l013.romanToInt("CXV") == 115);
	}

	@Test
	public void test5() {
		assertTrue(l013.romanToInt("") == 0);
	}

	@Test
	public void test6() {
		assertTrue(l013.romanToInt("III") == 3);
	}

	@Test
	public void test7() {
		assertTrue(l013.romanToInt("XXIV") == 24);
	}

	@Test
	public void test8() {
		assertTrue(l013.romanToInt("XXXVIII") == 38);
	}

}
