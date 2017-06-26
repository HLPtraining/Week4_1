import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PerformerTest {
	
	private Performer performer;
	
	@Before
	public void setUp() throws Exception
	{
		performer = new Performer(123);
	}

	@Test
	public void getIDTest()
	{
		int id = 123;	
		assertEquals(id, performer.getID());	
	}
	
	@Test
	public void performTest()
	{
		String performance = "123 - performer";
		assertEquals(performance, performer.perform());
	}

}
