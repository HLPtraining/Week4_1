import java.util.ArrayList;
import java.util.Scanner;


public class Audition {
	
	private ArrayList<Performer> performers; //array of performers 
	private final int MAX_PERFORMERS = 4; 
	private final int MAX_DANCERS = 2; 
	private final int MAX_VOCALISTS = 1; 
	private final int AUDITION_MAX = 7; 
	private int performerCount = 0;  //used to keep track of performer types
	private int dancerCount = 0;
	private int vocalistCount = 0;
	private String showOutput = "";
	
	public Audition()
	{
		performers = new ArrayList<Performer>();
	}
	
	public void addPerformer(int id)
	{
		countMembers();
		if(performerCount < MAX_PERFORMERS)
		{
			performers.add(new Performer(id));
		}
		else
		{
			throw new IllegalArgumentException("You can not add any more performers");
		}
	}
	
	public void addDancer(int Id, String danceStyle)
	{
		countMembers();
		if(dancerCount < MAX_DANCERS)
		{
			
			try {
				performers.add(new Dancer(Id, danceStyle));
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			throw new IllegalArgumentException("You can not add any more performers");
		}
	}
	
	public void addVocalist(int Id, String key)
	{
		countMembers();
		if(vocalistCount < MAX_VOCALISTS)
		{
			performers.add(new Vocalist(Id, key));
		}
		else
		{
			throw new IllegalArgumentException("You can not add any more performers");
		}
		
	}
	
	public void startShow()
	{
		boolean start = true;
		this.showOutput = ""; //reset show output
		if(performers.size() == AUDITION_MAX)
		{
			for(Performer member: this.performers)
			{
				System.out.println(member.perform());	
				if(start == true)
				{
					this.showOutput = member.perform();
				}
				else
				{
					this.showOutput = this.showOutput + "\n" + member.perform();
				}
				start = false;
			}	
		}
		else
		{	
			throw new IllegalStateException("Auditions can not start, Insuficient performers");
			
		}
	}
	
	public String getShowOutput()
	{
		return this.showOutput;
	}
	
	public void countMembers()
	{
		int perfCount = 0;
		int vocCount = 0;
		int danCount = 0;
		
		for(Performer member: this.performers)
		{
			if(member instanceof Vocalist )
			{
				vocCount++;
			}
			else if(member instanceof Dancer)
			{
				danCount++;
			}
			else
			{
				perfCount++;
			}		
		}		
		this.vocalistCount = vocCount;
		this.dancerCount =  danCount;
		this.performerCount = perfCount;
	}
	
	public int getPerformerCount()
	{
		countMembers();
		return this.performerCount;
	}
	
	public int getDancerCount()
	{
		countMembers();
		return this.dancerCount;
	}
	
	public int getVocalistCount()
	{
		countMembers();
		return this.vocalistCount;
	}
	
	public int getSize()
	{
		return performers.size();
	}
	
	public void requestSetVocalistVolume(int volume)
	{
		for(Performer member: this.performers)
		{
			if(member instanceof Vocalist )
			{
				try 
				{
					((Vocalist) member).setVolume(volume);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}	
		}		
	}
}
