package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.HomePage;
import page.objects.searchedCarPage;

public class SearchAndSortSteps {

	HomePage homepage = new HomePage();
	searchedCarPage searchedcarpage;

	@When("User clicks and enters the text {string} in the search box")
	public void user_clicks_and_enters_the_text_in_the_search_box(String searchCriteria) {
		homepage.clickAndEnter(searchCriteria);
	}

	@When("User clicks on the searched criteria")
	public void user_clicks_on_the_searched_criteria() {
		searchedcarpage = homepage.clickOnSearchedCriteria();
	}

	@When("User clicks on Sort dropdown and select sort using {string}")
	public void user_clicks_on_sort_dropdown_and_select_sort_using(String sortBy) {
		searchedcarpage.sortUsingDropDown(sortBy);
	}

	@Then("User will be able to sort the cars and verify the sorted cars based on the criteria")
	public void user_will_be_able_to_sort__the_cars_and_verify_the_sorted_cars_based_on_the_criteria() {
		searchedcarpage.verifySort();
	}

}
