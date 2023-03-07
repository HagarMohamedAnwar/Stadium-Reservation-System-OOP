import java.io.Serializable;
import java.util.Objects;

public abstract class Seats implements Comparable<Seats>,Serializable {

	private char block;
	private int row, seatNumber;
	private int reservedSeats;
	private String seatPosition;
	
	public Seats(char block, int row, int seatNumber) {
		this.block = block;
		this.row = row;
		this.seatNumber = seatNumber;
		seatPosition = block + Integer.toString(row) + Integer.toString(seatNumber);
	}
	//these 2 methods used to use contains method to know whether array of seats has a specific seat
	@Override
	public int hashCode() {
		return Objects.hash(block, reservedSeats, row, seatNumber, seatPosition);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seats other = (Seats) obj;
		return block == other.block && reservedSeats == other.reservedSeats && row == other.row
				&& seatNumber == other.seatNumber && Objects.equals(seatPosition, other.seatPosition);
	}

	public char getBlock() {

		return block;
	}

	public void setBlock(char block) {
		this.block = block;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public String getSeatPosition() {
		return seatPosition;
	}

	public void setSeatPosition(String seatPosition) {
		this.seatPosition = seatPosition;
	}

	//comparing seats according to the seat position like B21 or B22 (Collections.sort())
	public int compareTo(Seats s) {
		return this.seatPosition.compareTo(s.seatPosition);
	}
	

	@Override
	public String toString() {
		return "Block: " + block + "\tRow: " + row + "\tSeat number: " + seatNumber;
	}
	//all child classes must have this method (abstraction)
	public abstract void calPrice();
}