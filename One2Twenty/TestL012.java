package One2Twenty;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestL012 {
	L012_M l012;

	@Before
	public void createClass() {
		l012 = new L012_M();
	}

	@Test
	public void test() {
		assertTrue(l012.intToRoman(100).equals("C"));
	}

	@Test
	public void test2() {
		assertTrue(l012.intToRoman(50).equals("L"));
	}

	@Test
	public void test3() {
		assertTrue(l012.intToRoman(40).equals("XL"));
	}

	@Test
	public void test4() {
		assertTrue(l012.intToRoman(115).equals("CXV"));
	}

	@Test
	public void test5() {
		assertTrue(l012.intToRoman(-1).equals(""));
	}

	@Test
	public void test6() {
		assertTrue(l012.intToRoman(3).equals("III"));
	}

	@Test
	public void test7() {
		assertTrue(l012.intToRoman(24).equals("XXIV"));
	}
	@Test
	public void test8() {
		assertTrue(l012.intToRoman(38).equals("XXXVIII"));
	}
	
}
