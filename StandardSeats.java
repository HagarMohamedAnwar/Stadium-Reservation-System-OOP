import java.io.Serializable;

public class StandardSeats extends Seats implements Serializable{
	private static final long serialVersionUID = 6296069555978695918L;
	private double price = 0;

	public StandardSeats(char block, int row, int seatNumber) {
		super(block, row, seatNumber);
		calPrice();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	//calculate price for standard category according to the block
	public void calPrice() {
		switch (super.getBlock()) {
		case 'A':
		case 'B':
			price += 50;
			break;
		case 'C':
		case 'D':
			price += 30;
			break;
		}
		switch (super.getRow()) {
		case 1:
			price += 30;
			break;
		case 2:
			price += 20;
			break;
		}
	}
	public String toString()
	{
		//will print the parent class toString(seats)
		return super.toString() + "  Price: " + price + "€";
	}
}