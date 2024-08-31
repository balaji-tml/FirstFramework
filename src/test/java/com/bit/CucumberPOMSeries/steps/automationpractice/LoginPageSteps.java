package com.bit.CucumberPOMSeries.steps.automationpractice;

import com.bit.CucumberPOMSeries.factory.DriverFactory;
import com.bit.CucumberPOMSeries.pages.AccountPage;
import com.bit.CucumberPOMSeries.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;

public class LoginPageSteps {

//	WebDriver driver=DriverFactory.getDriver();
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage = new AccountPage(DriverFactory.getDriver());
    private static String actualLoginPageTitle,actualAccountPageTitle;

	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("In scenario1 - step1");
        DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
//        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the login page")
	public void user_gets_the_title_of_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("In scenario1 - step2");
		actualLoginPageTitle = loginPage.getLoginPageTitle();
	}

	@Then("login page title should be {string}")
	public void login_page_title_should_be(String expectedLoginPageTitle) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("In scenario1 - step3");
        actualLoginPageTitle = loginPage.getLoginPageTitle();
		Assertions.assertTrue(actualLoginPageTitle.contains(expectedLoginPageTitle));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("In scenario2 - step2");
		Assertions.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("In scenario3 - step2");
		loginPage.enterUserName("tester@email.com");
	}

	@When("user enters password {string}")
	public void user_enters_password(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("In scenario3 - step3");
		loginPage.enterPassword("tester@best");
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("In scenario3 - step4");
		loginPage.clickOnSignIn();
	}

	@Then("user gets the title of the home page")
	public void user_gets_the_title_of_the_home_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("In scenario3 - step5");
		actualAccountPageTitle = accountPage.getAccountsPageTitle();
	}

	@Then("home page title should be {string}")
	public void home_page_title_should_be(String expectedAccountPageTitle) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("In scenario3 - step6");
		Assertions.assertTrue(actualAccountPageTitle.contains(expectedAccountPageTitle));
	}




}
