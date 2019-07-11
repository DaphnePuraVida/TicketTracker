# TicketTracker
Eindopdracht NCOI

import java.util.Date;
import java.sql.Timestamp;
import java.util.Scanner;
import java.io.*;


class TijdStempel{

    private long startTime;
    private long endTime;
    private int  ticketNumber;
    private String behandelaar;
    
    public void setBehandelaar(String behandelaar){
        this.behandelaar = behandelaar;
    }
    
    public String getBehandelaar(){
        return behandelaar;
    }
    
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    
    public int getTicketNumber(){
        return ticketNumber;
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
    
    public void writeToFile(TijdStempel stempel) throws IOException {
        
        
        FileWriter write = new FileWriter( path , append_to_file);
        PrintWriter print_line = new PrintWriter( write );
        
        print_line.printf( "%s" + "%n" , "Ticket nummer: " + stempel.getTicketNumber());
     print_line.printf( "%s" + "%n" , "behandelaar: " + stempel.getBehandelaar());
     print_line.printf( "%s" + "%n" , "tijd in minuten: " + stempel.getTimeSpent());
   
        print_line.close();
    }
}


class TijdTracker{
    
public static void main(String args[])throws IOException, InterruptedException {
        
    
        TijdStempel ticket1 = new TijdStempel();
        
        ticket1.tijdStempelStart(System.currentTimeMillis());
         
        Scanner keyboard = new Scanner(System.in);

        System.out.println( "Voer het ticketnummer in (Alleen hele nummers):");
        ticket1.setTicketNumber(keyboard.nextInt());
        System.out.println("Wie is de behandelaar(voer naam in):");
        Scanner keyboard2 = new Scanner(System.in);
        String userName=keyboard2.nextLine();
        ticket1.setBehandelaar(userName);
        System.out.println();
                     
        ticket1.tijdStempelEind(System.currentTimeMillis());
        System.out.println("Het ticketnummer is:" + ticket1.getTicketNumber());
        System.out.println("Opgepakt door: " + ticket1.getBehandelaar());
        System.out.println("Gerapporteerde tijd in minuten: " + ticket1.getTimeSpent());

        WriteFile writeToFile = new WriteFile("C:\\Users\\Laptop\\Desktop\\time.txt", true);
        writeToFile.writeToFile(ticket1);
        
     }
  
}
