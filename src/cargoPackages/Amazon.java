package cargoPackages;

public class Amazon extends EcommerceCargoPackage<Integer>{

	
	public Amazon(String type, int weight, int width, int height, int length, String EcommerceSiteName,
			Integer cargoCode) {
		super(type, weight, width, height, length, EcommerceSiteName, cargoCode);
	}


	@Override
	public Integer dailyLimit() {
		int dailyLimit = 5;
		return dailyLimit;
	}

}
