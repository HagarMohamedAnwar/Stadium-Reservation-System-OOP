import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.*;

public class User {
	public static void main(String[] args)
			throws FileNotFoundException, ParseException, IOException, ClassNotFoundException, EOFException {
		Scanner scan = new Scanner(System.in);
		File fansFile = new File("Fans.bin");
		File matchesFile = new File("Matches.bin");
		File employeesFile = new File("Employees.bin");
		ArrayList<Fans> fans = new ArrayList<Fans>();
		ArrayList<Employees> employees = new ArrayList<Employees>();
		ArrayList<Matches> matches = new ArrayList<Matches>();

		// employee files handling
		if (employeesFile.length() != 0) {
			ObjectInputStream inEmployees = new ObjectInputStream(new FileInputStream(employeesFile));
			employees = (ArrayList<Employees>) inEmployees.readObject();
			inEmployees.close();
		} else {
			ObjectOutputStream outEmployees = new ObjectOutputStream(new FileOutputStream(employeesFile));
			employees.add(new Employees("wael", "iloveoop", "coolaka@live.com"));
			outEmployees.writeObject(employees);
			outEmployees.close();
		}
		// fans files handling
		if (fansFile.length() != 0) {
			ObjectInputStream inFans = new ObjectInputStream(new FileInputStream(fansFile));
			fans = (ArrayList<Fans>) inFans.readObject();
			inFans.close();
		} else {
			ObjectOutputStream outFans = new ObjectOutputStream(new FileOutputStream(fansFile));
			fans.add(new Fans("dista", "ilovereal", "coolaka@live.com"));
			outFans.writeObject(fans);
			outFans.close();
		}
		// match files handling
		if (matchesFile.length() != 0) {
			ObjectInputStream inMatches = new ObjectInputStream(new FileInputStream(matchesFile));
			matches = (ArrayList<Matches>) inMatches.readObject();
			inMatches.close();
		} else {
			ObjectOutputStream outMatches = new ObjectOutputStream(new FileOutputStream(matchesFile));
			String sDate = "6/1/2022 04:30 PM";
			Date date = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(sDate);
			matches.add(new Matches("Arsenal","Premier LEague",date));
			outMatches.writeObject(matches);
			outMatches.close();
		}
		Inputs input = new Inputs();
		int choice;
		boolean closeProgram = false;
		while (closeProgram == false) {
			choice = input.fansOrEmployee();
			// Employee
			if (choice == 1) {
				int index = input.checkEmployee(employees);
				// existing employee
				while (index >= 0) {
					choice = input.employeeChoice();
					// add a match
					if (choice == 1) {
						matches.add(input.addMatch());
						Collections.sort(matches);
						ObjectOutputStream outMatches = new ObjectOutputStream(new FileOutputStream(matchesFile));
						outMatches.writeObject(matches);
						outMatches.close();
					}
					// edit matches
					else if (choice == 2) {
						matches.set(input.matchWanted(matches), input.addMatch());
						Collections.sort(matches);
						ObjectOutputStream outMatches = new ObjectOutputStream(new FileOutputStream(matchesFile));
						outMatches.writeObject(matches);
						outMatches.close();
					}
					// delete matches
					else if (choice == 3) {
						matches.remove(input.deleteMatchAndReservations(matches,fans));
						
						Collections.sort(matches);
						ObjectOutputStream outMatches = new ObjectOutputStream(new FileOutputStream(matchesFile));
						outMatches.writeObject(matches);
						outMatches.close();
						ObjectOutputStream outFans = new ObjectOutputStream(new FileOutputStream(fansFile));
						outFans.writeObject(fans);
						outFans.close();
					}
					// show matches
					else if (choice == 4) {
						input.printMatches(matches);
					}
					// change password
					else if (choice == 5) {
						System.out.println("Enter new password of 8 or more characters: ");
						employees.get(index).setPassword(scan.next());
						Collections.sort(employees);
						ObjectOutputStream outEmployees = new ObjectOutputStream(new FileOutputStream(employeesFile));
						outEmployees.writeObject(employees);
						outEmployees.close();
					}
					// add employee
					else if (choice == 6) {
						input.newEmployee(employees);
						Collections.sort(employees);
						ObjectOutputStream outEmployees = new ObjectOutputStream(new FileOutputStream(employeesFile));
						outEmployees.writeObject(employees);
						outEmployees.close();
					}
					// show profile details
					else if (choice == 7) {
						System.out.println(employees.get(index));
					}
					// logout
					else {
						index = -1;
					}
				}
			}
			// user
			else if (choice == 2) {
				choice = input.oldOrNewFan();
				if (choice == 1) {
					int index = input.checkFan(fans);
					while (index >= 0) {
						choice = input.fanChoice();
						// reserve a ticket
						if (choice == 1) {
							input.reserveTickets(matches, fans.get(index));
							fans.get(index).sortTickets();
							Collections.sort(fans);
							ObjectOutputStream outFans = new ObjectOutputStream(new FileOutputStream(fansFile));
							outFans.writeObject(fans);
							outFans.close();
							ObjectOutputStream outMatches = new ObjectOutputStream(new FileOutputStream(matchesFile));
							outMatches.writeObject(matches);
							outMatches.close();
						}
						// remove reserved ticket
						else if (choice == 2) {
							fans.get(index).printTickets();
							fans.get(index).deleteTicket(input.ticketChoice(fans.get(index).getTickets(), matches));
							ObjectOutputStream outFans = new ObjectOutputStream(new FileOutputStream(fansFile));
							outFans.writeObject(fans);
							outFans.close();
							ObjectOutputStream outMatches = new ObjectOutputStream(new FileOutputStream(matchesFile));
							outMatches.writeObject(matches);
							outMatches.close();
						}
						// show available tickets
						else if (choice == 3) {
							fans.get(index).printTickets();
						}
						// changes password
						else if (choice == 4) {
							System.out.println("Enter new password of 8 or more characters: ");
							fans.get(index).setPassword(scan.next());
							ObjectOutputStream outFans = new ObjectOutputStream(new FileOutputStream(fansFile));
							outFans.writeObject(fans);
							outFans.close();
						}
						// shows profile details
						else if (choice == 5) {
							System.out.println(fans.get(index));
						}
						// logout
						else {
							index = -1;
						}
					}
				}
				// new user
				else {
					input.newFan(fans);
					ObjectOutputStream outFans = new ObjectOutputStream(new FileOutputStream(fansFile));
					Collections.sort(fans);
					outFans.writeObject(fans);
					outFans.close();
				}
			}
			// quit
			else {
				closeProgram = true;
			}
		}
	}
}
