package stepDefinitions;

import base.Testbase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionsforApparatuspage  extends Testbase{

	@Given("Launch the browser and navigate to application")
	public void launch_the_browser_and_navigate_to_application() {
		
		Testbase.Launchapplication("On");
	}

	@Given("Navigate to apparatus page")
	public void navigate_to_apparatus_page() {
		
		System.out.println("Navigate to apparatus page");

	}

	@Given("click add apparatus button")
	public void click_add_apparatus_button() {

		System.out.println("click add apparatus button");

		
	}

	@Given("Provide the required value for apparatus")
	public void provide_the_required_value_for_apparatus() {

	}

	@When("I click save button")
	public void i_click_save_button() {

	}

	@Then("I validate the records created or not")
	public void i_validate_the_records_created_or_not() {

	}

}
