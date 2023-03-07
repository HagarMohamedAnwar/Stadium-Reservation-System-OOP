import java.io.Serializable;

public class VIPSeats extends Seats implements Serializable {
	private static final long serialVersionUID = 6296069555978695918L;
	private double price = 0;

	public VIPSeats(char block, int row, int seatNumber) {
		super(block, row, seatNumber);
		calPrice();
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	//calculate price for VIP category
	public void calPrice() {
		switch (super.getRow()) {
		case 1:
			price += 180;
			break;
		case 2:
			price += 150;
			break;
		}
	}
	public String toString()
	{
		//prints seats (parent) toString then this
		return super.toString() + "  Price: " + price + "€";
	}
}