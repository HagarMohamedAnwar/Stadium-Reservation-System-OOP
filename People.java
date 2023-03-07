import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class People implements Serializable, Comparable<People>{
	private static final long serialVersionUID = 6296069555978695918L;
	private String username, password, email;
	public People(String username, String password, String email) {
		setUsername(username);
		setPassword(password);
		this.email = email;
	}
	public People(String username,String password)
	{
		this.username = username;
		this.password = password;
	}
	//i made scan in a method because i get scanner serialization error
	public String scanMethod()
	{
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
	
	
	public String getUsername() {
		return username;
	}
	//sets username with constrains
	public void setUsername(String username) {
		while (username.charAt(0) >= '0' && username.charAt(0) <= '9') {
			System.out.println("Please enter a username that doesnt contain a number");
			username = scanMethod();
		}
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	//sets password with constrains
	public void setPassword(String password) {
		while (password.length() < 8) {
			System.out.println("Please enter a password larger than 8 characters");
			password = scanMethod();
		}
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//must be present to use method cotains to check if a fan account or employee account is present
	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	//Collections.sort according to the username
	public int compareTo(People people)
	{
		return this.username.compareTo(people.username);
	}
	public String toString()
	{
		return "Username: " + username + "\nEmail: " + email;
	}
}