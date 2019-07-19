package nl.daphnepuravida;

import java.sql.Timestamp;

class TicketStempel {

	private long startTime;
	private long endTime;
	private int ticketNummer;
	private String behandelaar;

	public void setBehandelaar(String behandelaar) {
		this.behandelaar = behandelaar;
	}

	public String getBehandelaar() {
		return behandelaar;
	}

	public void setTicketNummer(int ticketNummer) {
		this.ticketNummer = ticketNummer;
	}

	public int getTicketNummer() {
		return ticketNummer;
	}

	public void tijdStempelStart(long startTime) {
		this.startTime = startTime;
		Timestamp startTijd = new Timestamp(startTime);
		System.out.println("Starttijd ticket is: " + startTijd);
	}

	public void tijdStempelEind(long endTime) {
		this.endTime = endTime;
		Timestamp eindTijd = new Timestamp(endTime);
		long timeSpent = this.endTime - startTime;
		System.out.println("Eindtijd ticket is: " + eindTijd);
	}

	public double getTimeSpent() {
		return (endTime - startTime) / 1000.0 / 60.0;
	}
}
