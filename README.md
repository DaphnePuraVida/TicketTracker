# TicketTracker
Eindopdracht NCOI

import java.sql.Timestamp;
import java.util.Scanner;
import java.io.*;


class TicketStempel{

    private long startTime;
    private long endTime;
    private int ticketNummer;
    private String behandelaar;
    private int kanaalTicket;
    int getKanaalTicket;
   
    
    public void setBehandelaar(String behandelaar){
        this.behandelaar = behandelaar;
    }
    
    public String getBehandelaar(){
        return behandelaar;
    }
    
    public void setTicketNummer(int ticketNummer) {
        this.ticketNummer = ticketNummer;
    }
    
    public int getTicketNummer(){
        return ticketNummer;
    }
    
    public void setKanaalTicket(int kanaalTicket){
        this.kanaalTicket = kanaalTicket;
    }
    
    public int getKanaalTicket(){
        return kanaalTicket;
    }
        
    public void tijdStempelStart(long startTime){
        this.startTime = startTime;
        Timestamp startTijd = new Timestamp(startTime);
        System.out.println("Starttijd ticket is: " + startTijd);
    }
 
    public void tijdStempelEind(long endTime){
        this.endTime = endTime;
        Timestamp eindTijd = new Timestamp(endTime);
        long timeSpent = this.endTime - startTime;
        System.out.println("Eindtijd ticket is: " + eindTijd);
        
    }
    
    public double getTimeSpent(){
        return (endTime - startTime) / 1000.0 / 60.0;
    }
    
    
}

class WriteFile{
    
    private String path;
    private boolean append_to_file = false;
    
    public WriteFile(String file_path) {
        path = file_path;
    }
    
    public WriteFile( String file_path , boolean append_value) {
        path = file_path;
        append_to_file = append_value;
    }
    
    public void writeToFile(TicketStempel stempel) throws IOException {
        
        
        FileWriter write = new FileWriter( path , append_to_file);
        PrintWriter print_line = new PrintWriter( write );
        
        print_line.printf( "%s" + "%n" , "Ticketnummer: " + stempel.getTicketNummer());
        print_line.printf( "%s" + "%n" , "Behandelaar: " + stempel.getBehandelaar());
        print_line.printf( "%s" + "%n" , "Kanaal: " + stempel.getKanaalTicket());
        print_line.printf( "%s" + "%n" , "Tijd in minuten: " + stempel.getTimeSpent());
        print_line.printf( "%s" + "%n" , "Cummulatieve tijd: "); //+ stempel.getTimeSpent());
        print_line.println(" ");
   
        print_line.close();
    }
}


class TijdTracker{
    
    public static void main(String args[])throws IOException, InterruptedException {
        
        int i=0;
        double totalTimeSpent = 0;
        while (i<999){
    
        TicketStempel ticket1 = new TicketStempel();
        
        System.out.println();
        ticket1.tijdStempelStart(System.currentTimeMillis());
        // Hier start de tijdmeting 
        System.out.println();
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println( "Voer het ticketnummer in (Alleen hele nummers):");
        ticket1.setTicketNummer(keyboard.nextInt());
        System.out.println("Wie is de behandelaar(voer naam in):");
        Scanner keyboard2 = new Scanner(System.in);
        String userName=keyboard2.nextLine();
        ticket1.setBehandelaar(userName);
        System.out.println( "Hoe is de ticket binnengekomen? ");
        System.out.println( "Kies 1 voor Mail, 2 voor Telefoon, 3 voor Software en 4 voor overig:");
        ticket1.setKanaalTicket(keyboard.nextInt());
        
        
        System.out.println();
        
        //Hier eindigt de meting
        ticket1.tijdStempelEind(System.currentTimeMillis());
        System.out.println();
        
        //Een samenvatting van de gegevens
        System.out.println("Samenvatting:");
        System.out.println();
        System.out.println("Het ticketnummer is:" + ticket1.getTicketNummer());
        System.out.println("Opgepakt door: " + ticket1.getBehandelaar());
        System.out.printf("Binnengekomen via: " + ticket1.getKanaalTicket());
             		
            switch(ticket1.getKanaalTicket()){
                case 1: 
                    System.out.println(" Mail ");
                    break;
                case 2: 
                    System.out.println(" Telefoon ");
                    break;
                case 3:
                    System.out.println(" Software ");
                    break;
                default:
                    System.out.println(" Overig");
                    break;
            }       
        
        double spent = ticket1.getTimeSpent()+ totalTimeSpent;
        System.out.println("Gerapporteerde tijd in minuten: " + ticket1.getTimeSpent());
        System.out.println("Totale tijd = "+ spent + " minuten");
        totalTimeSpent = spent;
      
        //Hier worden de gegevens weggeschreven naar een textbestand
        WriteFile writeToFile = new WriteFile("C:\\Users\\Laptop\\time.txt", true);
        writeToFile.writeToFile(ticket1);
        
        System.out.println( "Druk op enter om een nieuwe ticket te starten.");
        }
    }
}
