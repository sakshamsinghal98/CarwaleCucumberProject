package page.objects;

import pages.base.BasePage;

public class HomePage extends BasePage {

	public void mouseOverNewCars() {
		mouseOver("newCarsMenu_XPATH");
	}

	public NewCarPage clickNewCars() {
		click("findNewCars_XPATH");
		return new NewCarPage();
	}

	public void clickAndEnter(String value) {
		click("searchCar_XPATH");
		type("searchCar_XPATH", value);
	}

	public searchedCarPage clickOnSearchedCriteria() {
		click("under5Lakh_XPATH");
		return new searchedCarPage();
	}

	public void verifyFooterColor() {
		veriyColorCoding("footer_XPATH", "#002b51");
	}

}
