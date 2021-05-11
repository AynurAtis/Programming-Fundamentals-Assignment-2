package cargoPackages;

public class HepsiBurada extends EcommerceCargoPackage<String>{
	
	
	public HepsiBurada(String type, int weight, int width, int height, int length, String EcommerceSiteName,
			String cargoCode) {
		super(type, weight, width, height, length, EcommerceSiteName, cargoCode);

	}

	@Override
	public Integer dailyLimit() {
		int dailyLimit = 7;
		return dailyLimit;
	}

}
