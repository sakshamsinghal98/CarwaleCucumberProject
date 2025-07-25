package page.objects;

import java.util.List;

import pages.base.BasePage;

public class ToyotaCarPage extends BasePage {

	List<List<String>> nameAndPriceList;

	public String getCarTitle() {
		return getText("toyotaCarTitle_XPATH");
	}

	public void exportCarNameAndPrice() {
		nameAndPriceList = getCarNameAndPrice("allCarNames_CSS", "allCarPrices_CSS");
		exportToExcel(nameAndPriceList);
	}

}
