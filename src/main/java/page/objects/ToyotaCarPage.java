package page.objects;

import pages.base.BasePage;

public class ToyotaCarPage extends BasePage {

	public String getCarTitle() {
		return getText("toyotaCarTitle_XPATH");
	}

}
