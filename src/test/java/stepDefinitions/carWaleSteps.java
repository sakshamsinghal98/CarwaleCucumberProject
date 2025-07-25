package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.BMWCarPage;
import page.objects.HomePage;
import page.objects.HyundaiCarPage;
import page.objects.KiaCarPage;
import page.objects.NewCarPage;
import page.objects.ToyotaCarPage;
import utils.SeleniumDriver;

public class carWaleSteps {

	HomePage homepage = new HomePage();
	NewCarPage newcar;
	ToyotaCarPage toyotacar;
	BMWCarPage bmwcar;
	KiaCarPage kiacar;
	HyundaiCarPage hyundaicar;

	@Given("User navigates to carwale")
	public void user_navigates_to_carwale() {
		SeleniumDriver.openWebsite(SeleniumDriver.config.getProperty("testsiteurl"));
	}

	@When("User hovers over the new cars")
	public void user_hovers_over_the_new_cars() {
		homepage.mouseOverNewCars();
	}

	@When("User clicks on FindNewCars")
	public void user_clicks_on_find_new_cars() {
		newcar = homepage.clickNewCars();
	}

	@Then("User clicks on {string} car")
	public void user_clicks_on_car(String carName) {
		if (carName.equalsIgnoreCase("toyota")) {
			toyotacar = newcar.goToToyota();
		}

		else if (carName.equalsIgnoreCase("hyundai")) {
			hyundaicar = newcar.goToHyundai();
		}

		else if (carName.equalsIgnoreCase("kia")) {
			kiacar = newcar.goToKia();
		}

		else if (carName.equalsIgnoreCase("bmw")) {
			bmwcar = newcar.goToBMW();
		}
	}

	@Then("User validates the car title as {string} cars")
	public void user_validates_the_car_title_as_cars(String carName) {
		if (carName.equalsIgnoreCase("toyota")) {
			Assert.assertEquals(toyotacar.getCarTitle(), "Toyota Cars");
		}

		else if (carName.equalsIgnoreCase("hyundai")) {
			Assert.assertEquals(hyundaicar.getCarTitle(), "Hyundai Cars");
		}

		else if (carName.equalsIgnoreCase("kia")) {
			Assert.assertEquals(kiacar.getCarTitle(), "Kia Cars");
		}

		else if (carName.equalsIgnoreCase("bmw")) {
			Assert.assertEquals(bmwcar.getCarTitle(), "BMW Cars");
		}
	}

	@When("User should be able to validate and view all the images on that page")
	public void user_should_be_able_to_validate_and_view_all_the_images_on_that_page() {
		homepage.verifyIfImagesAreGettingDisplayedOrNot();
	}

	@Then("User should be able to verify the color coding of footer")
	public void user_should_be_able_to_verify_the_color_coding_of_footer() {
		homepage.verifyFooterColor();
	}

}
