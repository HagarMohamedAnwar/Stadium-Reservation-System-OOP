import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Fans extends People implements Serializable {
	private static final long serialVersionUID = 6296069555978695918L;
	// each fan has his array of tickets
	private ArrayList<Tickets> tickets = new ArrayList<Tickets>();
	private int fanNumber;
	static int numberOfFans = 1;

	public Fans(String username, String password, String email) {
		super(username, password, email);
		fanNumber = numberOfFans;
		numberOfFans++;
	}

	public void setFanNumber(int fanNumber) {
		this.fanNumber = fanNumber;
	}

	public void setTickets(ArrayList<Tickets> tickets) {
		this.tickets = tickets;
	}

	public Fans(String username, String password) {
		super(username, password);
	}

	// return array of tickets
	public ArrayList<Tickets> getTickets() {
		return tickets;
	}

	// deletes a ticket from the ticket by the fan array
	public void deleteTicket(int choice) {
		while (choice > tickets.size()) {
			System.out.println("Ticket number isnt in the list, try again");
			choice = Integer.valueOf(scanMethod());
		}
		tickets.remove(choice);
	}

	// prints all the tickets in a good form
	public void printTickets() {
		if(tickets.size() == 0)
			System.out.println("None\n");
		for (int i = 0; i < tickets.size(); i++) {
			System.out.println((i + 1) + "-" + tickets.get(i));
		}
	}

	// sorts fan's tickets
	public void sortTickets() {
		Collections.sort(tickets);
	}

	public int getFanNumber() {
		return fanNumber;
	}

	public void setUserNumber(int fanNumber) {
		this.fanNumber = fanNumber;
	}
	//add ticket to the tickets arraylist
	public void addTicket(Tickets ticket) {
		tickets.add(ticket);
	}

	public String toString() {
		return super.toString() + "\nFan Number: " + fanNumber;
	}
}