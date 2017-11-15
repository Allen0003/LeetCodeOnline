package One2Twenty;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestL009 {
	L009_E l009;

	@Before
	public void createClass() {
		l009 = new L009_E();
	}

	@Test
	public void test() {
		assertFalse(new L009_E().isPalindrome(001100));
	}

	@Test
	public void test2() {
		assertFalse(new L009_E().isPalindrome(1100));
	}

	@Test
	public void test3() {
		assertTrue(new L009_E().isPalindrome(1001));
	}

	@Test
	public void test4() {
		assertTrue(new L009_E().isPalindrome(1));
	}

	@Test
	public void test5() {
		assertTrue(new L009_E().isPalindrome(2));
	}

	@Test
	public void test6() {
		assertFalse(new L009_E().isPalindrome(-2));
	}

}
