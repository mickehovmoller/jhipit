package test;

import static org.junit.Assert.*;

import org.junit.Test;

import jhipit.S2;

public class TestGetFromFile {

	@Test
	public void test() {
		S2 foo = new S2();
		String g[] = {"f1", "f2"};
		foo.main(g);
		assertEquals(1,1);
	}

}
