import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class DancerTest {
	
	private Dancer dancer;

	@Before
	public void setUp() throws Exception
	{
		dancer = new Dancer(123, "Ballet");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setUp2Exception() throws Exception
	{
		dancer = new Dancer(123, "");
	}

	@Test
	public void performTest() 
	{
		String performance = "Ballet - 123 - dancer";
		assertEquals(performance, dancer.perform());
	}
	
	@Test
	public void getIdTest()
	{
		int id = 123;
		
		assertEquals(id, dancer.getID());
	}
	
	@Test
	public void getDanceStyleTest()
	{
		String style = "Ballet";
		assertEquals(style, dancer.getDanceStyle());
	}
	
	@Test
	public void setDanceStyleTest() throws Exception
	{
		String style = "Tap Dance";
		dancer.setDanceStyle(style);
		assertEquals(style, dancer.getDanceStyle());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setDanceStyleTestException() throws Exception
	{
		String style = "Extreme Tap Dancing from the year 2001";
		dancer.setDanceStyle(style);
	}

}
