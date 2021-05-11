package cargoPackages;

import java.util.Date;

public abstract class CargoPackages<T> implements ICargoPackages{
	
	private final String type;
	
	public T getCargoCode() {  // generic cargoCode getter method
		return cargoCode;
	}


	private final int weight;
	private final int width;
	private final int height;
	private final int length;
	private final T cargoCode;
	
	// Constructor
	public CargoPackages(String type, int weight, int width, int height, int length, T cargoCode) {
		this.type = type;
		this.weight = weight;
		this.width = width;
		this.height = height;
		this.length = length;
		this.cargoCode = cargoCode;
	}
	
	public enum DaysOfWeek{
		MONDAY ,
		TUESDAY ,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY;	
	}
	
	// Calculation of predicted delivery day
	public static DaysOfWeek PredictedDeliveryDay() {
		Date systemDate = new Date();
		int Intday = systemDate.getDay(); // Return the day as an integer for example; if Intday is 1 return Monday
		DaysOfWeek predictedDeliveryDay = null;
		DaysOfWeek[] days = DaysOfWeek.values();
		int index =0;
		if(Intday == 0) // If day is Sunday, do not accept cargo package
		{
			return predictedDeliveryDay;
		}
		else
		{
			index = (Intday + 1) % 6; // calculation of delivery day index in DaysOfWeek
			predictedDeliveryDay = days[index]; // Delivery day in DaysOfWeek
		}
		return predictedDeliveryDay;
		
		}
	
	//Getter methods
	
	public String getType() {
		return type;
	}


	public int getWeight() {
		return weight;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}


	public int getLength() {
		return length;
	}

	
}
