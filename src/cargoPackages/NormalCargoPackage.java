package cargoPackages;
import java.util.Random;

public class NormalCargoPackage extends CargoPackages<Integer> implements INormalCargoPackage{


	private final long senderId;
	private final String senderName;
	private final String recipientName;
	private final String recipientAddress;
	
	public static Integer generatecargoCode()
	{
		// Creates the random cargo Code for normal Type
		Random rnd = new Random();
		int Low = 1000000;
		int High = 9999999;
		Integer randomCargoCode = rnd.nextInt(High - Low) + Low;
		return randomCargoCode;
	}
	
	//constructor
	public NormalCargoPackage(long senderId, String senderName, String recipientName, String recipientAddress, String type, int weight, int width, int height, int length, Integer cargoCode) {
		super(type, weight, width, height, length, generatecargoCode());
		this.senderId = senderId;
		this.senderName = senderName;
		this.recipientName = recipientName;
		this.recipientAddress = recipientAddress;
	}

	 // getter methods
	public long getSenderId() {
		return senderId;
	}


	public String getSenderName() {
		return senderName;
	}


	public String getRecipientName() {
		return recipientName;
	}


	public String getRecipientAddress() {
		return recipientAddress;
	}



	@Override
	public void discount() {
	}

	
	// Calculates Price
	@Override
	public double[] CalculatePrice() {
		double desi = (this.getHeight() * this.getLength() * this.getWidth()) / 3000;
		int size = Math.max((int)desi, this.getWeight());
		double price = 18.5 + 3 * size;
		double[] sizeAndPriceArray = new double[2]; // We hold size and price in an array to use in printScreen method
		sizeAndPriceArray[0] = size; 
		sizeAndPriceArray [1] = price;
		return sizeAndPriceArray;
		
	}

	// Print screen
	@Override
	public void printScreen(int i) {

		System.out.println(i + " " + generatecargoCode() + " " + this.senderId + " " + this.senderName + 
				" " + this.recipientName + " " + this.recipientAddress + " " + (int)CalculatePrice()[0] + 
				" " + CalculatePrice()[1] + " " + PredictedDeliveryDay());
	}




	
}
