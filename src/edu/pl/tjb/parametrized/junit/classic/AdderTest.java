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
	
	@Parameters
	public static Collection <Object[]> data() { 
			Object[][] data = new Object[][] { {1,1,2}, {1,2,3}, {1,3,4}, {3,3,6}, {4,5,9},
												{1,1,1} };
			return Arrays.asList(data);
    }
    
	public AdderTest(int f, int s, int r) {
		this.first = f;
		this.second = s;
		this.result = r;
	}
	
	@Test
	public void test() {
		//given 
		Adder a = new Adder();
		int expected = result;
		
		// when
		int actual = a.add(first, second);
		
		// then
		assertEquals(expected, actual);
	}
	
}
