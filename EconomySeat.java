
public class EconomySeat extends Seat {

	private int rowNumber;
	private int columnNumber;
	private int locationToAisle; // 0 = aisle, 1 = center, 2 = window
	
	/**
	 * Constructor of EconomySeat
	 * Inherits from Seat
	 * 
	 * @param row 
 	 * @param col
	 * @param location from the aisle
	 */
	public EconomySeat(int row, int col, int location)
	{
		super();
		rowNumber = row;
		columnNumber = col;
		locationToAisle = location;
	}
	
	/**
	 * @return passenger name assigned to seat or "Empty" if seat is not taken
	 */
	public String returnPassengerName()
	{
		if(super.seatStatus)
		{
			return super.returnPassengerName();
		}
		else
		{
			return "Empty";
		}
	}
	
	
	/**
	 * Calls super class, Seat, to return the seat status
	 * 
	 * @return true = seat is taken, false = seat is empty
	 */
	public boolean returnSeatStatus()
	{
		return super.seatStatus;
	}
	
	/**
	 * Calls super class, assigns a passenger name to EconomySeat
	 * @return true if successful, false if seat is already taken
	 */
	public boolean addPassenger(String name)
	{
		return super.addPassenger(name);
	}
	
	/**
	 * @return String of seat number
	 */
	public String returnSeatNumber()
	{
		String seat;
		
		if(columnNumber == 0)
		{
			if(locationToAisle == 2)
			{
				seat = "A";
			}
			else if(locationToAisle == 1)
			{
				seat = "B";
			}
			else
			{
				seat = "C";
			}
		}
		else
		{
			if(locationToAisle == 2)
			{
				seat = "F";
			}
			else if(locationToAisle == 1)
			{
				seat = "E";
			}
			else
			{
				seat = "D";
			}
		}
		
		String seatNumber = (rowNumber+6)+""+seat;
		return seatNumber; //add 6 to rownumber because there are 5 rows of first class seats
	}
}
