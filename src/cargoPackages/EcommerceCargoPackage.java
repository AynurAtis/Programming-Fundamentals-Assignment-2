package cargoPackages;

public abstract class EcommerceCargoPackage<T> extends CargoPackages<T> implements IEcommerceCargoPackage {
	
	private final String EcommerceSiteName;
	
	private String status;
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	//Constructor
	public EcommerceCargoPackage(String type, int weight, int width, int height, int length, String EcommerceSiteName, T cargoCode) {
		super(type, weight, width, height, length, cargoCode);
		this.EcommerceSiteName = EcommerceSiteName;
		
	}
	
	// Calculation of Size
	public int CalculateSize() {
		double desi = (this.getHeight() * this.getLength() * this.getWidth()) / 3000;
		int size = Math.max((int)desi, this.getWeight());
		return size;
		
	}

	public String getEcommerceSiteName() {
		return EcommerceSiteName;
	}


	// Print method
	public void printScreen(int i) {
		
		System.out.println(i + " " + this.EcommerceSiteName + " " + this.getCargoCode() + " " + 
				this.status + " " + CalculateSize() + " " + PredictedDeliveryDay());
	}
	
}
