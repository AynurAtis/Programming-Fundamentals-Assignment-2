package cargoPackages;

import java.io.IOException;
import java.util.ArrayList;

public class CreatingObjects {
	
	static int acceptedStatus ;
	static int notAcceptedStatus;
	
	public static void ControllingSenderID(String SenderID)
	{
		if(SenderID.length() != 11) // Normal Cargo Code checks
		{
			throw new IDNotCorrectionException("Sender ID is not 11 digits"); // Exception message
		}
	}
	
	public static void ControllingCargoCode(String CargoCode, String EcommerceName) 
	{
		boolean LetterFound = false;
		if(EcommerceName.equals("Trendyol"))
		{
			if(CargoCode.length() != 8) // Checks the digits of cargo code
			{
				throw new CargoCodeNotCorrectException("Cargo Code for Trendyol must be 8 digit"); // Exception message
			}
			else
			{
				// This block does whether cargo code is numeric
				for(char ch: CargoCode.toCharArray()) 
				{
					if(Character.isLetter(ch))
					{
						LetterFound = true;
					}
				}
				if(LetterFound)
				{
					throw new CargoCodeNotCorrectException("Cargo Code for Trendyol must be numeric"); // If it is not numeric returns exception message
				}
					
			}
			LetterFound = false;
		}
		
		else if(EcommerceName.equals("Amazon"))
		{
			if(CargoCode.length() != 7) // Checks the digits of cargo code
			{
				throw new CargoCodeNotCorrectException("Cargo Code for Amazon must be 7 digit"); 
			}
			else
			{
				// This block does whether cargo code is numeric
				for(char ch: CargoCode.toCharArray())
				{
					if(Character.isLetter(ch))
					{
						LetterFound = true;
					}
				}
				if(LetterFound)
				{
					throw new CargoCodeNotCorrectException("argo Code for Amazon must be numeric");
				}
					
			}
		}
		else if (EcommerceName.equals("Hepsiburada"))
		{
			if(CargoCode.length() != 8) // Checks the length of cargo Code
			{
				throw new CargoCodeNotCorrectException("Cargo Code length for HepsiBuarada must be 8 characters!!!");
			}
		}
		else if (EcommerceName.equals("N11"))
		{
			if(CargoCode.length() != 7) // Checks the length of cargo Code
			{
				throw new CargoCodeNotCorrectException("Cargo Code length for N11 must be 7 characters!!!");
			}
		}
		
	}
	
	public static ArrayList<NormalCargoPackage> returnNormalCargoObjects() throws IOException{
		
		ArrayList<NormalCargoPackage> NormalCargoPackagesObjects = new ArrayList<NormalCargoPackage>();
		String[][] normalCargo = FileIO.NormalCargoItems(); // This array holds Normal Cargo Items
		ArrayList<Integer> cargoCodes = new ArrayList<Integer>();
		Integer cargoCode = 0;
		boolean flag = false;
		
		for(int i=0; i<normalCargo.length; i++)
		{
			while(true) {
				cargoCode = NormalCargoPackage.generatecargoCode(); // Create a cargo code as a random
				// If the cargo code exist, it creates new one
				for(Integer c: cargoCodes)
				{
					if(c == cargoCode)
					{
						flag = true;
					}
				}
				if(!flag)
				{
					break;
				}
				else
				{
					cargoCode = NormalCargoPackage.generatecargoCode(); // creates new one
				}
			}
			cargoCodes.add(NormalCargoPackage.generatecargoCode()); // This array holds all cargo code that is created as a random
			try {
				ControllingSenderID(normalCargo[i][1]); // Checks senderID exception
				
				// Creates all Normal type Objects
				NormalCargoPackage normalCargoObject = new NormalCargoPackage(Long.parseLong(normalCargo[i][1]), normalCargo[i][2],
						normalCargo[i][3], normalCargo[i][4], normalCargo[i][0], Integer.parseInt(normalCargo[i][5]),
						Integer.parseInt(normalCargo[i][6]), Integer.parseInt(normalCargo[i][7]),
								Integer.parseInt(normalCargo[i][8]), cargoCode);
				
				NormalCargoPackagesObjects.add(normalCargoObject);
				acceptedStatus++;
				normalCargoObject.printScreen(i+1); // Print screen
			}
			catch(IDNotCorrectionException e)
			{
				System.out.println(e); // Exception message
			}
			
			
		}
		return NormalCargoPackagesObjects;
	}
	
	public static ArrayList<Trendyol> returnTrendyolCargoObjects() throws IOException{
		
		ArrayList<Trendyol> TrendyolCargoPackagesObjects = new ArrayList<Trendyol>();
		
		String[][] EcommerceCargo = FileIO.EcommerceCargoItems(); // This array holds Ecommerce Cargo Items
		for(int i=0; i<EcommerceCargo.length; i++)
			{
			if(EcommerceCargo[i][1].equals("Trendyol"))
			{
				try {
					ControllingCargoCode(EcommerceCargo[i][2], EcommerceCargo[i][1]); // Checks cargo code exception
					
					// Creates all objects that Site name is Trendyol
				Trendyol ecommerceCargoObject = new Trendyol(EcommerceCargo[i][0], 
						Integer.parseInt(EcommerceCargo[i][3]), Integer.parseInt(EcommerceCargo[i][4]),
						Integer.parseInt(EcommerceCargo[i][6]), Integer.parseInt(EcommerceCargo[i][5]),
						EcommerceCargo[i][1], Integer.parseInt(EcommerceCargo[i][2]));
				
				if(ecommerceCargoObject.dailyLimit() > TrendyolCargoPackagesObjects.size())
				{
					ecommerceCargoObject.setStatus("Accepted"); // If number of cargo packages do not pass the dailyLimit set status Accepted
					acceptedStatus++; // increases accepted Status
				}
				else
				{
					ecommerceCargoObject.setStatus("Not Accepted"); // If number of cargo packages pass the dailyLimit set status Accepted
					notAcceptedStatus ++; //increases not accepted Status
				}
				TrendyolCargoPackagesObjects.add(ecommerceCargoObject);
				}
				catch(CargoCodeNotCorrectException e)
				{
					System.out.println(e);	// exception message
				}
			}
		}

		return TrendyolCargoPackagesObjects;
	}
	public static ArrayList<Amazon> returnAmazonCargoObjects() throws IOException{
		
		ArrayList<Amazon> AmazonCargoPackagesObjects = new ArrayList<Amazon>();
		
		String[][] EcommerceCargo = FileIO.EcommerceCargoItems(); // This array holds Ecommerce Cargo Items
		for(int i=0; i<EcommerceCargo.length; i++)
			{
			if(EcommerceCargo[i][1].equals("Amazon"))
			{
				try {
					ControllingCargoCode(EcommerceCargo[i][2], EcommerceCargo[i][1]); // Checks cargo code exception
					
					// Creates all objects that Site name is Amazon
				Amazon ecommerceCargoObject = new Amazon(EcommerceCargo[i][0], 
						Integer.parseInt(EcommerceCargo[i][3]), Integer.parseInt(EcommerceCargo[i][4]),
						Integer.parseInt(EcommerceCargo[i][6]), Integer.parseInt(EcommerceCargo[i][5]),
						EcommerceCargo[i][1], Integer.parseInt(EcommerceCargo[i][2]));
				
				if(ecommerceCargoObject.dailyLimit() > AmazonCargoPackagesObjects.size())
				{
					ecommerceCargoObject.setStatus("Accepted"); // If number of cargo packages do not pass the dailyLimit set status Accepted
					acceptedStatus++; // increases accepted Status
				}
				else
				{
					ecommerceCargoObject.setStatus("Not Accepted"); // If number of cargo packages pass the dailyLimit set status Accepted
					notAcceptedStatus++; // increases not accepted Status
				}
				AmazonCargoPackagesObjects.add(ecommerceCargoObject);
				}
				catch(CargoCodeNotCorrectException e)
				{
					System.out.println(e);
				}
			}
		}
		return AmazonCargoPackagesObjects;
	}
	
	public static ArrayList<N11> returnN11CargoObjects() throws IOException{
		
		ArrayList<N11> N11CargoPackagesObjects = new ArrayList<N11>();
		String[][] EcommerceCargo = FileIO.EcommerceCargoItems();  // This array holds Ecommerce Cargo Items
		for(int i=0; i<EcommerceCargo.length; i++)
			{
			if(EcommerceCargo[i][1].equals("N11"))
			{
				try
				{
					ControllingCargoCode(EcommerceCargo[i][2], EcommerceCargo[i][1]); // Checks cargo code exception
					// Creates all objects that Site name is N11
				N11 ecommerceCargoObject = new N11(EcommerceCargo[i][0], 
						Integer.parseInt(EcommerceCargo[i][3]), Integer.parseInt(EcommerceCargo[i][4]),
						Integer.parseInt(EcommerceCargo[i][6]), Integer.parseInt(EcommerceCargo[i][5]),
						EcommerceCargo[i][1], EcommerceCargo[i][2]);
				if(ecommerceCargoObject.dailyLimit() > N11CargoPackagesObjects.size())
				{
					ecommerceCargoObject.setStatus("Accepted"); // If number of cargo packages do not pass the dailyLimit set status Accepted
					acceptedStatus ++; // increases accepted status
				}
				else
				{
					ecommerceCargoObject.setStatus("Not Accepted"); // If number of cargo packages pass the dailyLimit set status Not Accepted
					notAcceptedStatus++; // increases not accepted status
				}
				N11CargoPackagesObjects.add(ecommerceCargoObject);
			}	
				catch(CargoCodeNotCorrectException e)
				{
					System.out.println(e);
				}
			}
		}
		return N11CargoPackagesObjects;
	}
	
	public static ArrayList<HepsiBurada> returnHepsiBuradaCargoObjects() throws IOException{
		
		ArrayList<HepsiBurada> HepsiBuradaCargoPackagesObjects = new ArrayList<HepsiBurada>();
		String[][] EcommerceCargo = FileIO.EcommerceCargoItems(); // This array holds Ecommerce Cargo Items
		for(int i=0; i<EcommerceCargo.length; i++)
			{
			if(EcommerceCargo[i][1].equals("Hepsiburada"))
			{
				try {
					ControllingCargoCode(EcommerceCargo[i][2], EcommerceCargo[i][1]); // Checks cargo code exception
					// Creates all objects that Site name is Hepsiburada
				HepsiBurada ecommerceCargoObject = new HepsiBurada(EcommerceCargo[i][0], 
						Integer.parseInt(EcommerceCargo[i][3]), Integer.parseInt(EcommerceCargo[i][4]),
						Integer.parseInt(EcommerceCargo[i][6]), Integer.parseInt(EcommerceCargo[i][5]),
						EcommerceCargo[i][1], EcommerceCargo[i][2]);

				if(ecommerceCargoObject.dailyLimit() > HepsiBuradaCargoPackagesObjects.size())
				{
					ecommerceCargoObject.setStatus("Accepted"); // If number of cargo packages do not pass the dailyLimit set status Accepted
					acceptedStatus++; // increases accepted status
				}
				else
				{
					ecommerceCargoObject.setStatus("Not Accepted"); // If number of cargo packages pass the dailyLimit set status Not Accepted
					notAcceptedStatus++; // increases not accepted status
				}
				HepsiBuradaCargoPackagesObjects.add(ecommerceCargoObject);
			}
				catch(CargoCodeNotCorrectException e)
				{
					System.out.println(e);
				}
			}
		}
		return HepsiBuradaCargoPackagesObjects;
	}
	
	public static void PrintEcommerceObjects() throws IOException
	{
		// Prints all Ecommerce Objects
		int counter = 0;
		for(HepsiBurada h: returnHepsiBuradaCargoObjects())
		{
			counter++;
			h.printScreen(counter);
			
		}
		for(Trendyol t: returnTrendyolCargoObjects())
		{
			counter++;
			t.printScreen(counter);
			
		}
		for(Amazon a: returnAmazonCargoObjects())
		{
			counter++;
			a.printScreen(counter);
			
		}
		for(N11 n: returnN11CargoObjects())
		{
			counter++;
			n.printScreen(counter);
			
		}
			
		}

	
}
