package edu.pl.tjb.parametrized.junit.classic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AdderTest {

	private int first;
	private int second;
	private int result;
	private String message;
	private static final String OK = "Simple addition, should not be faulty.";
	
	@Parameters
	public static Collection <Object[]> data() { 
			Object[][] data = new Object[][] { {1,1,2, OK}, {1,2,3, OK}, {1,3,4, OK}, {3,3,6, OK}, {4,5,9, OK},
												{1,1,1, "bad result given on purpose"} };
			return Arrays.asList(data);
    }
    
	public AdderTest(int f, int s, int r, String msg) {
		this.first = f;
		this.second = s;
		this.result = r;
		this.message = msg;
	}
	
	@Test
	public void shouldAddAsExpected() {
		//given 
		Adder a = new Adder();
		int expected = result;
		
		// when
		int actual = a.add(first, second);
		
		// then
		assertEquals(message, expected, actual);
	}
	
}
