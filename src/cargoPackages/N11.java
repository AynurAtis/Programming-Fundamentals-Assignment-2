package cargoPackages;

public class N11 extends EcommerceCargoPackage<String>{


	public N11(String type, int weight, int width, int height, int length, String EcommerceSiteName, String cargoCode) {
		super(type, weight, width, height, length, EcommerceSiteName, cargoCode);
		
	}



	@Override
	public Integer dailyLimit() {
		int dailyLimit = 6;
		return dailyLimit;
	}

}
