
public class Dancer extends Performer{
	
	private String danceStyle;
	public Dancer(int id, String danceStyle) throws Exception
	{
		super(id);
		if(danceStyle.length() > 0 && danceStyle.length() <= 20)
		{
			this.danceStyle = danceStyle;
		}
		else
		{
			throw new IllegalArgumentException("Length of dance style name must be greater than 0 and <= 20");
		}
	}
	
	public void setDanceStyle(String danceStyle) throws Exception
	{
		if(danceStyle.length() > 0 && danceStyle.length() <= 20)
		{
			this.danceStyle = danceStyle;
		}
		else
		{
			throw new IllegalArgumentException("Length of dance style name must be greater than 0 and <= 20");
		}
			
	}
	
	public String getDanceStyle()
	{
		return danceStyle;
	}
	
	@Override
	public String perform()
	{
		return this.danceStyle + " - " + super.getID() + " - dancer";
	}
}
