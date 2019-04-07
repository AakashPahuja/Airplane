public class Seat {
	
	protected String passengerName;
	protected boolean seatStatus; //true = seat is taken, false = seat is empty
	
	/**
	 * Constructor of Seat
	 */
	public Seat()
	{
		passengerName = null;
		seatStatus = false;
	}
	
	/**
	 * Assigns a passenger name to the seat
	 * 
	 * @param name of the passenger
	 * @return true if successful, false if seat is already taken
	 */
	public boolean addPassenger(String name)
	{
		if(seatStatus)
		{
			
			return false;
		}
		else
		{
			passengerName = name;
			seatStatus = true;
			return true;
		}
	}
	
	
	/**
	 * 
	 * @return passenger name
	 */
	public String returnPassengerName()
	{
		return passengerName;
	}
}



