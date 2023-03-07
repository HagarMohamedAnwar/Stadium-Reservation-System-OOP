import java.io.Serializable;

public class Employees extends People implements Serializable{
	private static final long serialVersionUID = 6296069555978695918L;
	public Employees(String username, String password, String email)
	{
		super(username,password,email);
	}
	public Employees(String username, String password)
	{
		super(username,password);
	}
}