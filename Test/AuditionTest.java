import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AuditionTest {
	
	private Audition audition;

	@Before
	public void setUp() throws Exception 
	{
		audition = new Audition();
	}

	@Test
	public void testAudition() throws Exception
	{
		System.out.println("The Auditons are Starting!//////////////////////////////////////");
		audition.addPerformer(123);	
		audition.addVocalist(154, "G#");
		audition.addDancer(458, "Ballet");			
		audition.addPerformer(145);
		audition.addDancer(20, "Hip Hop");		
		audition.addPerformer(888);	
		audition.addPerformer(654);	
		audition.startShow();
		System.out.println("The Auditions have ended!/////////////////////////////////////////");
	
		System.out.println("The Auditons are Starting!//////////////////////////////////////");
		audition.requestSetVocalistVolume(6);
		audition.startShow();
		System.out.println("The Auditions have ended!/////////////////////////////////////////");
	}

	@Test
	public void testAddPerformerPos()
	{
		audition.addPerformer(123);
		int size = 1;
		assertEquals(size, audition.getSize());
		audition.addPerformer(594);	
		audition.addPerformer(594);	
		audition.addPerformer(594);
		size = 4;
		assertEquals(size, audition.getSize());	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddPerformerException()
	{
		audition.addPerformer(123);
		audition.addPerformer(294);	
		audition.addPerformer(494);	
		audition.addPerformer(593);
		audition.addPerformer(794);
	}

	@Test
	public void testAddDancer() 
	{
		audition.addDancer(458, "Ballet");
		int size = 1;
		assertEquals(size, audition.getSize());
		audition.addDancer(479, "Hip Hop");
		size = 2;
		assertEquals(size, audition.getSize());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddDancerException()
	{
		audition.addDancer(458, "Ballet");
		audition.addDancer(479, "Hip Hop");
		audition.addDancer(362, "Hip Hop");
	}

	@Test
	public void testAddVocalist() 
	{
		audition.addVocalist(154, "G#");
		int size = 1;
		assertEquals(size, audition.getSize());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddVocalistException() 
	{
		audition.addVocalist(154, "G#");
		int size = 1;
		assertEquals(size, audition.getSize());
		audition.addVocalist(197, "C#");
	}
	
	

	@Test
	public void testStartShowPos() 
	{
		//audition.startShow();
		String show = "123 - performer\nI sing in the key of - G# - 154\nBallet - 458 - dancer\n145 - performer\nHip Hop - 20 - dancer\n888 - performer\n654 - performer";
		audition.addPerformer(123);	
		audition.addVocalist(154, "G#");
		audition.addDancer(458, "Ballet");			
		audition.addPerformer(145);
		audition.addDancer(20, "Hip Hop");		
		audition.addPerformer(888);	
		audition.addPerformer(654);	
		audition.startShow();
		assertEquals(show, audition.getShowOutput());
		
		
		audition.requestSetVocalistVolume(6);
		show = "123 - performer\nI sing in the key of - G# - at the volume 6 - 154\nBallet - 458 - dancer\n145 - performer\nHip Hop - 20 - dancer\n888 - performer\n654 - performer";
		audition.startShow();
		assertEquals(show, audition.getShowOutput());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testStartShowPosException()
	{
		audition.addPerformer(123);		
		audition.startShow();
	}

	@Test
	public void testCountMember() 
	{
		audition.addPerformer(123);		
		audition.addVocalist(154, "G#");
		audition.addDancer(458, "Ballet");	
		assertEquals(1,audition.getPerformerCount());
		assertEquals(1,audition.getDancerCount());
		assertEquals(1,audition.getVocalistCount());
		
		audition.addPerformer(145);
		audition.addDancer(20, "Hip Hop");	
		assertEquals(2,audition.getPerformerCount());
		assertEquals(2,audition.getDancerCount());	
		
		audition.addPerformer(145);	
		assertEquals(3,audition.getPerformerCount());
		audition.addPerformer(145);	
		assertEquals(4,audition.getPerformerCount());	
	}
	
	@Test
	public void testGetDancerCount() 
	{
		audition.addDancer(458, "Ballet");	
		audition.addDancer(458, "Tap Dancing");	
		int count = 2;
		assertEquals(count, audition.getDancerCount());
	}
	
	@Test
	public void testGetVocalistCount() 
	{
		audition.addVocalist(154, "G#");	
		int count = 1;
		assertEquals(count, audition.getVocalistCount());
	}

	@Test
	public void testGetPerformerCount() 
	{
		audition.addPerformer(123);
		int count = 1;
		assertEquals(count, audition.getPerformerCount());
		audition.addPerformer(124);
		count++;
		assertEquals(count, audition.getPerformerCount());
		audition.addPerformer(125);
		count++;
		assertEquals(count, audition.getPerformerCount());
		audition.addPerformer(126);
		count++;
		assertEquals(count, audition.getPerformerCount());
	}

}
