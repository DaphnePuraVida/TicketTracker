package nl.daphnepuravida;

import java.io.IOException;
import java.util.Scanner;

class TijdTracker {

	public static void main(String args[]) throws IOException, InterruptedException {

		TicketStempel ticket1 = new TicketStempel();

		System.out.println();
		ticket1.tijdStempelStart(System.currentTimeMillis());
		// Hier start de tijdmeting
		System.out.println();

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Voer het ticketnummer in (Alleen hele nummers):");
		ticket1.setTicketNummer(keyboard.nextInt());
		System.out.println("Wie is de behandelaar(voer naam in):");
		Scanner keyboard2 = new Scanner(System.in);
		String userName = keyboard2.nextLine();
		ticket1.setBehandelaar(userName);
		System.out.println();

		// Hier eindigt de meting
		ticket1.tijdStempelEind(System.currentTimeMillis());
		System.out.println();

		// Een samenvatting van de gegevens
		System.out.println("Samenvatting:");
		System.out.println();
		System.out.println("Het ticketnummer is:" + ticket1.getTicketNummer());
		System.out.println("Opgepakt door: " + ticket1.getBehandelaar());
		System.out.println("Gerapporteerde tijd in minuten: " + ticket1.getTimeSpent());
		System.out.println();

		// Hier worden de gegevens weggeschreven naar een textbestand
		//./time.txt zorgt dat het in de directory vanuit waar het programma gedraaid wordt
		//een bestand komt
		WriteFile writeToFile = new WriteFile("./time.txt", true);
		writeToFile.writeToFile(ticket1);

	}
}
