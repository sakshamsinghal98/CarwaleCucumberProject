package page.objects;

import pages.base.BasePage;

public class BMWCarPage extends BasePage {

	public String getCarTitle() {
		return getText("bmwCarTitle_XPATH");
	}

}
