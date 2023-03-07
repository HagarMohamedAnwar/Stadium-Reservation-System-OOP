public class Stadium {
	private String stadiumName;
	private String stadiumAddress;
	public Stadium()
	{
		stadiumName = "Anfield";
		stadiumAddress = "Anfield Rd, Anfield, Liverpool L4 0TH, UK";
	}
	public Stadium(String stadiumName,String stadiumAddress)
	{
		this.stadiumName = stadiumName;
		this.stadiumAddress = stadiumAddress;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void getStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getStadiumAddress() {
		return stadiumAddress;
	}
	public void setStadiumAddress(String stadiumAddress) {
		this.stadiumAddress = stadiumAddress;
	}
	@Override
	public String toString()
	{
		return "Stadium: " + stadiumName + "\tAddress: " + stadiumAddress;
	}
}