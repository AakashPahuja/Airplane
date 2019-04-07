	import java.util.Scanner;
		import java.lang.NumberFormatException;

		public class AirplaneTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner in = new Scanner(System.in);
				boolean runProgram = true;
				int seatingType;
				int partySize;
				int seatPreference;
				String[] passengerNames = new String[3];
				
				
				Airplane a = new Airplane();
				
				System.out.println("Welcome to the Airplane Seating Program.");
				System.out.println("For First Class Seating, there are 5 rows of 4 seats each.");;
				System.out.println("For Economy Seating, there are 30 rows of 6 seats each.");		
				
				
				while(runProgram)
				{
					try
					{
						System.out.println("Enter 1 to add a passenger.");
						System.out.println("Enter 2 to display seating.");
						System.out.println("Enter 3 to exit.");
						
						int selection = Integer.parseInt(in.next());
						
						switch(selection)
						{
							case 1:
							{
								System.out.println("First Class has a maxiumum party size of 2.");
								System.out.println("Economy has a maxiumum party size of 3.");
								
								System.out.println("Please enter 1 for First Class, 2 for Economy, or 0 to go back.");
								seatingType = Integer.parseInt(in.next());
								
								if(seatingType == 1)
								{
									System.out.println("Please enter your party size: ");
									partySize = Integer.parseInt(in.next());
									
									if(partySize == 1 || partySize == 2)
									{
										for(int i = 0; i < partySize; i++)
										{
											System.out.println("Enter the name for passenger "+(i+1)+": ");
											passengerNames[i] = in.next();
										}
										
										System.out.println("Please enter 1 for aisle seat or 2 for window seat: ");
										seatPreference = Integer.parseInt(in.next());
										
										if(seatPreference == 1)
										{
											a.addPassengers("First Class", partySize, passengerNames, "Aisle");
										}
										else if(seatPreference == 2)
										{
											a.addPassengers("First Class", partySize, passengerNames, "Window");
										}
										else
										{
											System.out.println("Invalid seating preference.");
										}
									}
									else
									{
										System.out.println("Invalid party size.");
									}
					
								}
								else if(seatingType == 2)
								{
									
									System.out.println("Please enter your party size: ");
									partySize = Integer.parseInt(in.next());
									
									if(partySize == 1 || partySize == 2 || partySize == 3)
									{
										for(int i = 0; i < partySize; i++)
										{
											System.out.println("Enter the name for passenger "+(i+1)+": ");
											passengerNames[i] = in.next();
										}
										
										System.out.println("Please enter 1 for aisle seat, 2 for center seat, or 3 for window seat: ");
										seatPreference = Integer.parseInt(in.next());
										
										if(seatPreference == 1)
										{
											a.addPassengers("Economy",partySize, passengerNames, "Aisle");
										}
										else if(seatPreference == 2)
										{
											a.addPassengers("Economy",partySize, passengerNames, "Center");
										}
										else if(seatPreference == 3)
										{
											a.addPassengers("Economy",partySize, passengerNames, "Window");
										}
										else
										{
											System.out.println("Invalid seating preference.");
										}
									}
									else
									{
										System.out.println("Invalid party size.");
									}			
								}
								else if(seatingType == 0)
								{
									System.out.println("Going back...");
								}
								else
								{
									System.out.println("Invalid input.");
								}	
								break;	
							}
							case 2:
							{
								System.out.println("Displaying airplane seating.");
								a.displayAirplane();
								break;
							}
							case 3:
							{
								runProgram = a.exitProgram();
								break;
							}
							default:
							{
								System.out.println("Invalid input. Please enter 1, 2, or 3.");
							}
						}
					}
					catch(NumberFormatException e)
					{
						System.out.println("Invalid input. Please try again.");
					}	
				}	
				
			System.out.println("Thank you for coming.");
			in.close();
				
			}
		
		

	}


