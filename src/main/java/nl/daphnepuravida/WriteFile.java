package nl.daphnepuravida;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class WriteFile {

	private String path;
	private boolean append_to_file = false;

	public WriteFile(String file_path) {
		path = file_path;
	}

	public WriteFile(String file_path, boolean append_value) {
		path = file_path;
		append_to_file = append_value;
	}

	public void writeToFile(TicketStempel stempel) throws IOException {

		FileWriter write = new FileWriter(path, append_to_file);
		PrintWriter print_line = new PrintWriter(write);

		// Een samenvatting van de gegevens
		print_line.printf("%s" + "%n", "Samenvatting:");
				
		print_line.printf("%s" + "%n", "Het ticketnummer is:" + stempel.getTicketNummer());
		print_line.printf("%s" + "%n", "Opgepakt door: " + stempel.getBehandelaar());
		print_line.printf("%s" + "%n", "Gerapporteerde tijd in minuten: " + stempel.getTimeSpent());
	
		print_line.println(" ");
		print_line.close();
	}
}
