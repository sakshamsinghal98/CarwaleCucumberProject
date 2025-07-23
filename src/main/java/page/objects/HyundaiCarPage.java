package page.objects;

import pages.base.BasePage;

public class HyundaiCarPage extends BasePage {
	public String getCarTitle() {
		return getText("hyundaiCarTitle_XPATH");
	}
}
