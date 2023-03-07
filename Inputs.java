import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Inputs {
	Scanner scan = new Scanner(System.in);

	public Inputs() {

	}

	//Done
	public int fansOrEmployee() {
		System.out.println("Welcome to the Anfield");
		System.out.println("1-Employees\n2-Fans");
		System.out.println("3-Quit the program");
		int choice = scan.nextInt();
		while (choice < 1 || choice > 3) {
			System.out.println("Wrong input try again");
			System.out.println("1-For Employees\n2-For Fans");
			System.out.println("3-Quit the program");
			choice = scan.nextInt();
		}
		return choice;
	}

	//Done
	public int checkEmployee(ArrayList<Employees> employee) {
		int index = -1;
		System.out.println("Type 'close' to return to main menu");
		while (index < 0) {
			System.out.print("Username: ");
			String username = scan.next();
			if (username.compareTo("close") == 0)
				break;
			System.out.print("Password: ");
			String password = scan.next();
			if (password.compareTo("close") == 0)
				break;
			if (employee.contains(new Employees(username, password))) {
				index = employee.indexOf(new Employees(username, password));
				break;
			} else
				System.out.println("Username or password are incorrect, please try again");
		}
		return index;
	}

	//Done
	public int checkFan(ArrayList<Fans> fans) {
		int index = -1;
		System.out.println("Type 'close' to return to main menu");
		while (index < 0) {
			System.out.print("Username: ");
			String username = scan.next();
			if (username.compareTo("close") == 0)
				break;
			System.out.print("Password: ");
			String password = scan.next();
			if (fans.contains(new Fans(username, password))) {
				index = fans.indexOf(new Fans(username, password));
				break;
			} else
				System.out.println("Username or password are incorrect, please try again");
		}
		return index;
	}

	//Done
	public int oldOrNewFan() {
		System.out.println("1-Login\n2-Signup");
		int choice = scan.nextInt();
		while (choice < 1 || choice > 2) {
			System.out.println("Wrong input try again");
			System.out.println("1-Login\n2-Signup");
			choice = scan.nextInt();
		}
		return choice;
	}
	//Done
	public int employeeChoice() {
		System.out.println("1-Add a match\n2-Edit a match\n3-Delete a match\n4-Show matches\n5-Change password\n6-Add employee\n7-Show profile details\n8-Loggout");
		int choice = scan.nextInt();
		while (choice < 1 || choice > 8) {
			System.out.println("Wrong input try again");
			System.out.println("1-Add a match\n2-Edit a match\n3-Delete a match\n4-Show matches\n5-Change password\n6-Add employee\n7-Show profile details\n8-Loggout");
			choice = scan.nextInt();
		}
		return choice;
	}
	//Done
	public int fanChoice() {
		System.out.println("1-Reserve a ticket\n2-Cancel a reservation\n3-Upcoming reservations\n4-Change password\n5-Show profile details\n6-Loggout");
		int choice = scan.nextInt();
		while (choice < 1 || choice > 6) {
			System.out.println("Wrong input try again");
			System.out.println("1-Reserve a ticket\n2-Cancel a reservation\n3-Upcoming reservations\n4-Change password\n5-Show profile details\n6-Loggout");
			choice = scan.nextInt();
		}
		return choice;
	}

	//Done
	public Matches addMatch() throws ParseException {
		scan.nextLine();
		System.out.println("Away Team: ");
		String awayTeam = scan.nextLine();
		System.out.println("League: ");
		String league = scan.nextLine();
		System.out.println("Date: ");
		String sDate = scan.nextLine();
		Date date = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(sDate);
		return new Matches(awayTeam, league, date);
	}

	//Done
	public void printMatches(ArrayList<Matches> matches) {
		for (int i = 0; i < matches.size(); i++) {
			System.out.println((i + 1) + "-" + matches.get(i));
		}
		System.out.println();
	}

	//Done
	public int matchWanted(ArrayList<Matches> matches) {
		printMatches(matches);
		int choice = scan.nextInt();
		while (choice < 1 || choice > matches.size()) {
			System.out.println("Wrong input try again");
			printMatches(matches);
			choice = scan.nextInt();
		}
		return choice - 1;
	}

	//TODO done half
	public void newEmployee(ArrayList<Employees> employee) {
		System.out.println("Please enter a username that starts with a letter");
		String username = scan.next();
		System.out.println("Please enter a password of length 8 or more");
		String password = scan.next();
		System.out.print("Email: ");
		String email = scan.next();
		employee.add(new Employees(username, password, email));
	}
	//Done
	public void newFan(ArrayList<Fans> fans) {
		System.out.println("Please enter a username that starts with a letter");
		String username = scan.next();
		System.out.println("Please enter a password of length 8 or more");
		String password = scan.next();
		System.out.print("Email: ");
		String email = scan.next();
		fans.add(new Fans(username, password, email));
	}

	//Done
	public int deleteMatchAndReservations(ArrayList<Matches> matches,ArrayList<Fans> fans) {
		printMatches(matches);
		System.out.println("Which match do you want to delete?");
		int choice = scan.nextInt();
		while (choice < 1 || choice > matches.size()) {
			System.out.println("Unavailable match, try again");
			choice = scan.nextInt();
		}
		choice--;
		for(Fans f:fans)
		{
			for(int i = 0;i < f.getTickets().size();i++)
			{
				if(matches.get(choice).getMatchDate().equals(f.getTickets().get(i).getMatchDate()))
				{
					f.getTickets().remove(i);
				}
			}
		}
		
		return choice;
	}
	//Done
	public int ticketChoice(ArrayList<Tickets> ticket, ArrayList<Matches> matches) {
		System.out.println("Enter the ticket you want to delete");
		int choice = scan.nextInt();
		while (choice < 1 || choice > ticket.size()) {
			System.out.println("Unavailable ticket, try again");
			choice = scan.nextInt();
		}
		choice--;
		
		for (int i = 0; i < matches.size(); i++) {
			if (ticket.get(choice).getMatchDate().equals(matches.get(i).getMatchDate())) {
				matches.get(i).unReserveSeat(ticket.get(choice).getSeat());
			}
		}
		return choice;
	}
	
	public void reserveTickets(ArrayList<Matches> matches, Fans fans) {
		printMatches(matches);
		//Get choice of match wanted
		int matchChoice = scan.nextInt();
		System.out.println(matches.size());
		while (matchChoice < 1 || matchChoice > matches.size()) {
			System.out.println("Wrong input try again");
			printMatches(matches);
			matchChoice = scan.nextInt();
		}
		matchChoice--;
		
		printAvailableSeats(matches.get(matchChoice));
		//Prices
		System.out.println("Standard Category: Block A,B: 50€ | Block C,D: 30€");
		System.out.println("Row 1: 30€ | Row 2: 20 | Row 3: 10€");
		System.out.println("VIP Category: Block V");
		System.out.println("Row 1: 180€ | Row 2: 150€");
		
		boolean done = false;
		while (done == false) {
			//check block choice
			System.out.print("Block: ");
			char block = scan.next().charAt(0);
			while ((block < 'A' || block > 'D') && block != 'V') {
				System.out.println("Block out of range");
				System.out.print("Block: ");
				block = scan.next().charAt(0);
			}
			//check row choice
			System.out.print("Row: ");
			int row = scan.nextInt();
			while (row < 1 || row > 2) {
				System.out.println("Row out of range");
				System.out.print("Row: ");
				row = scan.nextInt();
			}
			//check seat number choice
			System.out.print("Seat Number: ");
			int seatNumber = scan.nextInt();
			while (seatNumber < 1 || seatNumber > 9) {
				System.out.println("Seat out of range");
				System.out.print("Seat Number: ");
				seatNumber = scan.nextInt();
			}
			
			int payChoice;
			if (block == 'V') {
				//VIP seat reservation
				//check if seat taken or not
				if (matches.get(matchChoice).seatTaken(new VIPSeats(block, row, seatNumber)) == false) {
					System.out.println("Final price is: " + new VIPSeats(block, row, seatNumber).getPrice());
					System.out.println("Are you sure you want to continue?\n1-Yes\n2-No");
					payChoice = scan.nextInt();
					//gets pay choice yes or no
					while (payChoice < 1 && payChoice > 2) {
						System.out.println("Wrong input");
						payChoice = scan.nextInt();
					}
					//wants to pay
					if (payChoice == 1) {
						//reserve the seat in the match
						matches.get(matchChoice).reserveSeat(new VIPSeats(block, row, seatNumber));
						//adds a ticket for the fan with the same seat wanted
						fans.addTicket(new Tickets(matches.get(matchChoice).getAwayTeam(), matches.get(matchChoice).getLeague(),
								matches.get(matchChoice).getMatchDate(), new VIPSeats(block, row, seatNumber)));
						//done will go out of while loop meaning reservation is done
						done = true;
						break;
					} else
						//Doesn't want to pay
						break;
				} else
					//if seat is taken, it will say that the seat is taken and takes choice again
					System.out.println("Taken, please try another seat");
				//standard seats reservation
			} else if (block >= 'A' && block <= 'D')
				//checks if this seat is taken or not
				if (matches.get(matchChoice).seatTaken(new StandardSeats(block, row, seatNumber)) == false) {
					System.out.println("Final price is: " + new StandardSeats(block, row, seatNumber).getPrice());
					System.out.println("Are you sure you want to continue?\n1-Yes\n2-No");
					payChoice = scan.nextInt();
					//takes pay choice yes or no
					while (payChoice < 1 && payChoice > 2) {
						System.out.println("Wrong input");
						payChoice = scan.nextInt();
					}
					//pays
					if (payChoice == 1) {
						//reserves a seat in the match
						matches.get(matchChoice).reserveSeat(new StandardSeats(block, row, seatNumber));
						//reserves a ticket for the fan with the same seat
						fans.addTicket(new Tickets(matches.get(matchChoice).getAwayTeam(), matches.get(matchChoice).getLeague(),
								matches.get(matchChoice).getMatchDate(), new StandardSeats(block, row, seatNumber)));
						//reservation done
						done = true;
						break;
					} else
						break;
				} else
					//seat entered is false
					System.out.println("Taken, please try another seat");
		}
	}
	//TODO show standard and VIP separately
	public void printAvailableSeats(Matches match) {
		for (char block = 'A'; block < 'F'; block++) {
			for (int row = 2; row >= 1; row--) {
				if (block == 'E') {
					block = 'V';
				}
				for (int seatNumber = 1; seatNumber < 10; seatNumber++) {
					if (block == 'V') {
						if (match.seatTaken(new VIPSeats(block, row, seatNumber)) == false)
							System.out.print(block + Integer.toString(row) + Integer.toString(seatNumber) + "\t");
						else {
							System.out.print("Taken\t");
						}
					} else if (block != 'V') {
						if (match.seatTaken(new StandardSeats(block, row, seatNumber)) == false)
							System.out.print(block + Integer.toString(row) + Integer.toString(seatNumber) + "\t");
						else {
							System.out.print("Taken\t");
						}
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
