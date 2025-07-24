package page.objects;

import pages.base.BasePage;

public class searchedCarPage extends BasePage {

	public void sortUsingDropDown(String sortBy) {
		selectDropDown("selectSortBy_XPATH", sortBy);

	}

	public void verifySort() {
		verifyDescendingSort("priceListOfCars_CSS");
	}
}
