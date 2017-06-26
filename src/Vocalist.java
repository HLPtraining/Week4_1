
public class Vocalist extends Performer {
	
	private String key;
	private int volume = 0; //zero volume means vocalist does not say their volume when performing
	
	public Vocalist(int id, String key)
	{
		super(id);
		this.setKey(key);
	}

	public int getVolume()
	{
		return volume;
	}

	public void setVolume(int volume) throws Exception
	{
		if(volume >= 1 && volume <= 10)
		{
			this.volume = volume;
		}
		else
		{
			throw new IllegalArgumentException("Volume must be a value between 1 and 10");
		}
		
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key) 
	{
		this.key = key;
	}
	
	@Override
	public String perform()
	{
		if(this.volume == 0)
		{
			return "I sing in the key of - " + this.getKey() + " - " + super.getID();
		}
		else 
		{
			return "I sing in the key of - " + this.getKey() + " - at the volume " + this.getVolume() + " - " + super.getID();
		}
		
	}
	

}
