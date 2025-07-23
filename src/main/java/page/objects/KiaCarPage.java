package page.objects;

import pages.base.BasePage;

public class KiaCarPage extends BasePage {
	public String getCarTitle() {
		return getText("kiaCarTitle_XPATH");
	}
}
