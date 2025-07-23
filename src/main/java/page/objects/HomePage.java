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

}
