import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Matches extends Stadium implements Comparable<Matches>, Serializable {
	private static final long serialVersionUID = 6296069555978695918L;
	private String homeTeam = "Liverpool", awayTeam, league;
	private Date matchDate;
	//every match has its seats
	private ArrayList<Seats> seats = new ArrayList<Seats>();
	//every match has its fans
	private ArrayList<Fans> fans = new ArrayList<Fans>();

	//creates a match to be announced later
	public Matches() {
		awayTeam = "TBD";
		league = "TBD";
	}

	public Matches(String awayTeam, String league, Date matchDate) {
		super();
		this.awayTeam = awayTeam;
		this.league = league;
		this.matchDate = matchDate;
	}
	//checks if a specific seat is taken or not
	public boolean seatTaken(Seats s) {
		return seats.contains(s);
	}
	//reserve a specific seat
	public void reserveSeat(Seats s) {
		seats.add(s);
	}
	public void unReserveSeat(Seats s)
	{
		seats.remove(s);
	}
	public int compareTo(Matches m) {
		return this.matchDate.compareTo(m.matchDate);
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public Date getMatchDate() {
		return matchDate;
	}
	//TODO remove or not
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public String toString() {
		return super.toString() + "\n\t\t" + homeTeam + " VS " + awayTeam + "\n\t\t" + league + "\n\t\t" + matchDate + "\n\n";
	}
}