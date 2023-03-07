import java.util.Date;
import java.util.Random;
public class Tickets extends Matches implements Comparable<Matches>{
    private Random r = new Random();
    private long minimumBarcode = 123456789012L;
    //every ticket has a seat on it
    private Seats seat;
    private String category;
    //makes a random bar code between a range
    private long barcode = minimumBarcode + ((long)(r.nextDouble()*30000)); //casting + generating random 12 digit numbers
    public Tickets(String awayTeam, String league, Date matchDate,Seats seat) {
        super(awayTeam, league, matchDate);
        this.seat = seat;
        setCategory();
    }
    //sets category based on block to be printed on ticket
    private void setCategory() {
    	if(seat.getBlock() == 'V')
        	category = "Vip";
        else category = "Standard";
	}
	public long getMinimumBarcode() {
        return minimumBarcode;
    }
    //return the ticket seat details
    public Seats getSeat()
    {
    	return seat;
    }
    public void setMinimumBarcode(long minimumBarcode) {
        this.minimumBarcode = minimumBarcode;
    }

    public long getBarcode() {
        return barcode;
    }
    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }
    //compareTo tickets according to its bar code(Collections.sort(tickets) will work if only this is present) 
    public int compareTo(Tickets t) {
    	if(this.barcode == t.barcode)
    		return 0;
    	else if(this.barcode > t.barcode)
    		return 1;
    	else return -1;
	}

    @Override
    public String toString() {
    	//tickets extends matches so will print match tostring then this details
    	//printing seat by itself will print the toString of the seat
        return  super.toString() + "\nBarcode: " + barcode + "\n" + category + "\t" + seat + "\n\n";
    }     
}