import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class VocalistTest {
	private Vocalist vocalist;
	
	@Before
	public void setUp() throws Exception 
	{
		vocalist = new Vocalist(123, "G#");
	}

	@Test
	public void setKeyTest() 
	{
		String key = "Gm";
		vocalist.setKey(key);
		assertEquals(key, vocalist.getKey());
	}

	@Test
	public void getKeyTest()
	{
		Vocalist vocalist = new Vocalist(123, "C#");
		assertEquals("C#", vocalist.getKey());
	}
	
	@Test
	public void performTest() throws Exception
	{
		Vocalist vocalist = new Vocalist(123, "Am");
		String performance = "I sing in the key of - Am - 123";
		assertEquals(performance, vocalist.perform());
		
		
		vocalist.setVolume(4);
		
		performance = "I sing in the key of - Am - at the volume 4 - 123";
		assertEquals(performance, vocalist.perform());
		
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void setVolumeTestException() throws Exception
	{	
		int volume = 11;
		vocalist.setVolume(volume);	
		
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void setVolumeTestException2() throws Exception
	{	
		int volume = -1;
		try
		{
			vocalist.setVolume(volume);	
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void setVolumeTestException3() throws Exception
	{	
		int volume = 0;
		vocalist.setVolume(volume);	
						
	}
	
	@Test
	public void setVolumeTestPos() throws Exception
	{	
		vocalist.setVolume(10);	
		vocalist.setVolume(5);
				
	}
}
