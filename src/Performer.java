import java.security.SecureRandom;


public class Performer {
	
	private final int id;
	
	public Performer(int id)
	{
		this.id = id;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String perform()
	{
		return this.id + " - performer";
	}
}
