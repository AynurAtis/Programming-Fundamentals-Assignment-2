package cargoPackages;

import java.io.IOException;
import java.util.ArrayList;

public class CargoPackagesApp {
	
	public static void main(String[] args) throws IOException {

		System.out.println("Welcome!");
		
		System.out.println("Here are the details:");
		
		System.out.println("Normal Cargo Packages:");
		
		System.out.println("No " + "Cargo_Code "+ "Sender_Id " + "Sender_Name " + "Recipient_Name " + 
				"Recipient_Address " + "Size " + "Price " + "Delivery_Day");
		
		CreatingObjects.returnNormalCargoObjects();
		
		System.out.println();
		
		System.out.println("E-commerce Cargo Packages:");
		
		System.out.println("No " + "Ecommerce_Site_Name " + "Cargo_Code " + "Status " + "Size " + "Delivery_Day");
		
		CreatingObjects.PrintEcommerceObjects();
		
		System.out.println();
		
		System.out.println("Number of Accepted Cargo: " + CreatingObjects.acceptedStatus);
		
		System.out.println("Number of Not Accepted Cargo: " + CreatingObjects.notAcceptedStatus);

	}

}