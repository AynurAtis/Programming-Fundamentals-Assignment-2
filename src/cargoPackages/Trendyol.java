package cargoPackages;

public class Trendyol extends EcommerceCargoPackage<Integer>{

	
	public Trendyol(String type, int weight, int width, int height, int length, String EcommerceSiteName,
			Integer cargoCode) {
		super(type, weight, width, height, length, EcommerceSiteName, cargoCode);
	}


	@Override
	public Integer dailyLimit() {
		int dailylimit = 9;
		return dailylimit;
	}

}
