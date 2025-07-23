package page.objects;

import pages.base.BasePage;

public class NewCarPage extends BasePage {

	public KiaCarPage goToKia() {
		click("kia_LINKTEXT");
		return new KiaCarPage();
	}

	public BMWCarPage goToBMW() {
		click("bmw_LINKTEXT");

		return new BMWCarPage();
	}

	public ToyotaCarPage goToToyota() {
		click("toyota_LINKTEXT");
		return new ToyotaCarPage();
	}

	public HyundaiCarPage goToHyundai() {
		click("hyundai_LINKTEXT");

		return new HyundaiCarPage();
	}
}
