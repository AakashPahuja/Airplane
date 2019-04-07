
public class Airplane {
		
		private FirstClassSeat[][][] firstClass = new FirstClassSeat[5][2][2];
		private EconomySeat[][][] economy = new EconomySeat[30][2][3];
		
		
		/** 
		 * Constructor of Airplane.
		 * Airplane aggregates arrays of FirstClassSeat and EconomySeatObjects
		 */
		public Airplane()
		{
			for(int rows = 0; rows < 5;rows++)
			{
				for(int cols = 0; cols < 2; cols++)
				{
					for(int locations = 0; locations < 2; locations ++)
					{
						firstClass[rows][cols][locations] = new FirstClassSeat(rows,cols,locations);
					}
				}
			}
			for(int rows = 0; rows < 30;rows++)
			{
				for(int cols = 0; cols < 2; cols++)
				{
					for(int locations = 0; locations < 3; locations ++)
					{
						economy[rows][cols][locations] = new EconomySeat(rows,cols,locations);
					}
				}
			}	
		}
		
		
		/**
		 * Displays the seating arrangement of the Airplane on the console.
		 * A seat is taken if it contains a name.
		 * A seat is empty if it displays Empty.
		 */
		public void displayAirplane()
		{			
			System.out.println(" \t\t\tA\tB\t\t\tC\tD\n");
			for(int rows = 0; rows < 5;rows++)
			{

				System.out.print(rows+1+"\t\t");
				
				for(int cols = 0; cols < 2; cols++)
				{
													
						if(cols == 0)
						{
							System.out.print("\t"+firstClass[rows][cols][1].returnPassengerName());
							System.out.print("\t"+firstClass[rows][cols][0].returnPassengerName());
						}
						else
						{
							System.out.print("\t"+firstClass[rows][cols][0].returnPassengerName());
							System.out.print("\t"+firstClass[rows][cols][1].returnPassengerName());
						}
						System.out.print("\t\t");
				}
				System.out.println();
			}
			
			System.out.println("\n \t\tA\tB\tC\t\t\tD\tE\tF\n");
			for(int rows = 0; rows < 30 ;rows++)
			{
				System.out.print(rows+6+"\t");
				
				for(int cols = 0; cols < 2; cols++)
				{
													
						if(cols == 0)
						{
							System.out.print("\t"+economy[rows][cols][2].returnPassengerName());
							System.out.print("\t"+economy[rows][cols][1].returnPassengerName());
							System.out.print("\t"+economy[rows][cols][0].returnPassengerName());
						}
						else
						{
							System.out.print("\t"+economy[rows][cols][0].returnPassengerName());
							System.out.print("\t"+economy[rows][cols][1].returnPassengerName());
							System.out.print("\t"+economy[rows][cols][2].returnPassengerName());
						}
						System.out.print("\t\t");
				}
				System.out.println();
			}
			System.out.println();	
		}

		/**
		 * public Wrapper function that calls private Airplane methods. <p>
		 * Determines to add passengers either to First Class (by calling addPassFirstClass(...))
		 * or to Economy (by calling addPassFirstClass(...))
		 * 
		 * @param seatingType text field of "First Class" or "Economy"
		 * @param numPassengers the integer number of passengers to be added
		 * @param namesPassengers the string array of the passengers' names
		 * @param preference the seat preference of the passengers 
		 */
		public void addPassengers(String seatingType, int numPassengers, String[] namesPassengers, String preference)
		{
			if(seatingType.equalsIgnoreCase("First Class"))
			{
				addPassFirstClass(numPassengers, namesPassengers, preference);
			}
			else if(seatingType.equalsIgnoreCase("Economy"))
			{
				addPassEconomy(numPassengers, namesPassengers, preference);		
			}
			else
			{
				System.out.println("No passengers added.");
			}
		}
		
		/**
		 * private method called by public addPassengers(...) <p>
		 * Adds passengers to First Class seating according to the inputs
		 * 
		 * @param numPassengers the integer number of passengers to be added
		 * @param namesPassengers the string array of passenger's names
		 * @param preference the seat preference of the passengers
		 */
		private void addPassFirstClass(int numPassengers, String[] namesPassengers, String preference)
		{
			int row = 0;
			int column = 0;
			
			boolean continueLoop = true;
			
			System.out.println("Attempting to place your party in first class...");
			
			if(numPassengers == 1)
			{
				if(preference.equalsIgnoreCase("Aisle"))
				{
					while (row < 5 && continueLoop)
					{
						column = 0;
						while(column < 2 && continueLoop)
						{
							if(firstClass[row][column][0].returnSeatStatus())
							{
								//seat taken
							}
							else
							{
								firstClass[row][column][0].addPassenger(namesPassengers[0]);
								continueLoop = false;
								System.out.println("Your party has been placed in the following seats: ");
								System.out.println(firstClass[row][column][0].returnSeatNumber());
							}
							column++;
						}
						row++;
					}
				}
				else //preference == window
				{
					while (row < 5 && continueLoop)
					{
						column = 0;
						while(column < 2 && continueLoop)
						{
							if(firstClass[row][column][1].returnSeatStatus())
							{
								//seat taken
							}
							else
							{
								firstClass[row][column][1].addPassenger(namesPassengers[0]);
								continueLoop = false;
								System.out.println("Your party has been placed in the following seats: ");
								System.out.println(firstClass[row][column][1].returnSeatNumber());
							}
							column++;
						}
						row++;
					}				
				}	
			}
			else //passengers == 2
			{
				while (row < 5 && continueLoop)
				{
					column = 0;
					while(column < 2 && continueLoop)
					{
						if(firstClass[row][column][0].seatStatus || firstClass[row][column][1].seatStatus)
						{
							//seats taken
						}
						else
						{
							firstClass[row][column][0].addPassenger(namesPassengers[0]);
							firstClass[row][column][1].addPassenger(namesPassengers[1]);
							continueLoop = false;
							System.out.println("Your party has been placed in the following seats: ");
							System.out.println(firstClass[row][column][0].returnSeatNumber());
							System.out.println(firstClass[row][column][1].returnSeatNumber());
						}
						column++;
					}
					row++;
				}
			}
			
			if(continueLoop)
			{
				System.out.println("We are unable to seat your party on the plane. Please try again.");
			}		
		}

		/**
		 * private method called by public addPassengers(...) <p>
		 * Adds passengers to Economy seating according to the inputs
		 * 
		 * @param numPassengers the integer number of passengers to be added
		 * @param namesPassengers the string array of passenger's names
		 * @param preference the seat preference of the passengers
		 */
		private void addPassEconomy(int numPassengers, String[] namesPassengers, String preference) //need to finish 2 and 3
		{
			int row = 0;
			int column = 0;
			
			boolean continueLoop = true;
			
			System.out.println("Attempting to place your party in economy...");
			
			if(numPassengers == 1)
			{
				if(preference.equalsIgnoreCase("Aisle"))
				{
					while (row < 30 && continueLoop)
					{
						column = 0;
						while(column < 2 && continueLoop)
						{
							if(economy[row][column][0].returnSeatStatus())
							{
								//seat taken
							}
							else
							{
								economy[row][column][0].addPassenger(namesPassengers[0]);
								continueLoop = false;
								System.out.println("Your party has been placed in the following seats: ");
								System.out.println(economy[row][column][0].returnSeatNumber());
							}
							column++;
						}
						row++;
					}
				}
				else if(preference.equalsIgnoreCase("Center"))
				{
					while (row < 30 && continueLoop)
					{
						column = 0;
						while(column < 2 && continueLoop)
						{
							if(economy[row][column][1].returnSeatStatus())
							{
								//seat taken
							}
							else
							{
								economy[row][column][1].addPassenger(namesPassengers[0]);
								continueLoop = false;
								System.out.println("Your party has been placed in the following seats: ");
								System.out.println(economy[row][column][1].returnSeatNumber());
							}
							column++;
						}
						row++;
					}				
				}				
				else //preference == window
				{
					while (row < 30 && continueLoop)
					{
						column = 0;
						while(column < 2 && continueLoop)
						{
							if(economy[row][column][2].returnSeatStatus())
							{
								//seat taken
							}
							else
							{
								economy[row][column][2].addPassenger(namesPassengers[0]);
								continueLoop = false;
								System.out.println("Your party has been placed in the following seats: ");
								System.out.println(economy[row][column][2].returnSeatNumber());
							}
							column++;
						}
						row++;
					}				
				}	
			}
			else if(numPassengers == 2) 
			{
				if(preference.equalsIgnoreCase("Aisle"))
				{
					while (row < 30 && continueLoop)
					{
						column = 0;
						while(column < 2 && continueLoop)
						{
							if(economy[row][column][0].returnSeatStatus() || economy[row][column][1].returnSeatStatus())
							{
								//seat taken
							}
							else
							{
								economy[row][column][0].addPassenger(namesPassengers[0]);
								economy[row][column][1].addPassenger(namesPassengers[1]);
								continueLoop = false;
								System.out.println("Your party has been placed in the following seats: ");
								System.out.println(economy[row][column][0].returnSeatNumber());
								System.out.println(economy[row][column][1].returnSeatNumber());
							}
							column++;
						}
						row++;
					}
				}
				else if(preference.equalsIgnoreCase("Window"))
				{
					while (row < 30 && continueLoop)
					{
						column = 0;
						while(column < 2 && continueLoop)
						{
							if(economy[row][column][2].returnSeatStatus() || economy[row][column][1].returnSeatStatus())
							{
								//seat taken
							}
							else
							{
								economy[row][column][2].addPassenger(namesPassengers[0]);
								economy[row][column][1].addPassenger(namesPassengers[1]);
								continueLoop = false;
								System.out.println("Your party has been placed in the following seats: ");
								System.out.println(economy[row][column][1].returnSeatNumber());
								System.out.println(economy[row][column][2].returnSeatNumber());
							}
							column++;
						}
						row++;
					}
				}
				else //preference == middle
				{
					while (row < 30 && continueLoop)
					{
						column = 0;
						while(column < 2 && continueLoop)
						{
							if(economy[row][column][0].returnSeatStatus() || economy[row][column][1].returnSeatStatus())
							{
								//aisle and middle possibly taken, now test window and middle
								if(economy[row][column][2].returnSeatStatus() || economy[row][column][1].returnSeatStatus())
								{
										//middle and window taken
								}
								else
								{
									economy[row][column][2].addPassenger(namesPassengers[0]);
									economy[row][column][1].addPassenger(namesPassengers[1]);
									continueLoop = false;
									System.out.println("Your party has been placed in the following seats: ");
									System.out.println(economy[row][column][1].returnSeatNumber());
									System.out.println(economy[row][column][2].returnSeatNumber());
								}
							}
							else
							{
								economy[row][column][0].addPassenger(namesPassengers[0]);
								economy[row][column][1].addPassenger(namesPassengers[1]);
								continueLoop = false;
								System.out.println("Your party has been placed in the following seats: ");
								System.out.println(economy[row][column][0].returnSeatNumber());
								System.out.println(economy[row][column][1].returnSeatNumber());
							}
							column++;
						}
						row++;
					}
				}
			}
			else //passengers == 3
			{
				while (row < 30 && continueLoop)
				{
					column = 0;
					while(column < 2 && continueLoop)
					{
						if(economy[row][column][0].returnSeatStatus() || economy[row][column][2].returnSeatStatus() || economy[row][column][2].returnSeatStatus())
						{
							//seat taken
						}
						else
						{
							economy[row][column][0].addPassenger(namesPassengers[0]);
							economy[row][column][1].addPassenger(namesPassengers[1]);
							economy[row][column][2].addPassenger(namesPassengers[2]);
							continueLoop = false;
							System.out.println("Your party has been placed in the following seats: ");
							System.out.println(economy[row][column][0].returnSeatNumber());
							System.out.println(economy[row][column][1].returnSeatNumber());
							System.out.println(economy[row][column][2].returnSeatNumber());
						}
						column++;
					}
					row++;
				}
			}
			if(continueLoop)
			{
				System.out.println("We are unable to seat your party on the plane. Please try again.");
			}		
		}

		
		/**
		 * Returns a false value, indicating that the program will end.
		 * 
		 * @return false
		 */
		public boolean exitProgram()
		{
			System.out.println("You are now exitting the program.");
			return false;
		}

	}
		
		
		
		


