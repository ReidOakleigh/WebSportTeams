

import java.util.List;
import java.util.Scanner;

import controller.SportsTeamHelper;
import model.SportsTeam;

/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Feb 13, 2021
 */
public class StartProgram {
 
		static Scanner in = new Scanner(System.in);
		static SportsTeamHelper sth = new SportsTeamHelper();

		private static void addTeam() {
			System.out.print("Enter a city: ");
			String city = in.nextLine();
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter a sport: ");
			String sport = in.nextLine();
			SportsTeam toAdd = new SportsTeam(city, name, sport);
			sth.insertTeam(toAdd);
			System.out.println("Added " + toAdd);
		}

		private static void deleteTeam() {
			System.out.print("Enter the city to delete: ");
			String city = in.nextLine();
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			SportsTeam toDelete = new SportsTeam(city, name, "");
			toDelete = sth.deleteTeam(toDelete);
			System.out.println("Deleted " + toDelete);
		}

		private static void editTeam() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by city");
			System.out.println("2 : Search by name");
			int searchBy = getInt();
			in.nextLine();
			List<SportsTeam> foundnames = null;
			if (searchBy == 1) {
				System.out.print("Enter the city name: ");
				String city = in.nextLine();
				foundnames = sth.searchForTeamByCity(city);
				
			} else {
				System.out.print("Enter the name: ");
				String name = in.nextLine();
				foundnames = sth.searchForTeamByName(name);
			}

			if (!foundnames.isEmpty()) {
				System.out.println("Found Results.");
				for (SportsTeam l : foundnames) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				SportsTeam toEdit = sth.searchForTeamById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getCity());
				System.out.println("1 : Update city");
				System.out.println("2 : Update name");
				System.out.println("3 : Update sport");
				int update = getInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New city: ");
					String newCity = in.nextLine();
					toEdit.setCity(newCity);
				} else if (update == 2) {
					System.out.print("New name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 3) {
					System.out.print("New sport: ");
					String newSport = in.nextLine();
					toEdit.setSport(newSport);					
				}

				sth.updateTeam(toEdit);
				System.out.println("Changed " + toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}
		
		public static int getInt() {
			int i;
			while (true) {
				System.out.print(">");
				char c = in.next().charAt(0);
				if (Character.isDigit(c)) {
					i = c - '0';
					break;
				}
			}
			return i;
		}

		public static void main(String[] args) {
			runMenu();
		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome sports team list! ---");
			while (goAgain) {
				System.out.println("*  Select an team:");
				System.out.println("*  1 -- Add an team");
				System.out.println("*  2 -- Edit an team");
				System.out.println("*  3 -- Delete an team");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = getInt();
				in.nextLine();

				if (selection == 1) {
					addTeam();
				} else if (selection == 2) {
					editTeam();
				} else if (selection == 3) {
					deleteTeam();
				} else if (selection == 4) {
					viewTheList();
				} else {
					sth.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<SportsTeam> allTeams = sth.showAllTeams();
			allTeams.forEach(System.out::println);
		}

	}