public class FirstClassSeat extends Seat {

	private int rowNumber;
	private int columnNumber;
	private int locationToAisle; // 0 = aisle, 1 = window
	
	/**
	 * Constructor of FirstClassSeat
	 * Inherits from Seat
	 * 
	 * @param row 
 	 * @param col
	 * @param location from the aisle
	 */
	public FirstClassSeat(int row, int col, int location)
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
	 * Calls super class, assigns a passenger name to FirstClassSeat
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
			if(locationToAisle == 1)
			{
				seat = "A";
			}
			else
			{
				seat = "B";
			}
		}
		else
		{
			if(locationToAisle == 1)
			{
				seat = "D";
			}
			else
			{
				seat = "C";
			}
		}
		String seatNumber = (rowNumber+1)+""+seat;
		return seatNumber;
	}
	
}


