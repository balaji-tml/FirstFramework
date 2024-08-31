package com.bit.CucumberPOMSeries.steps.automationpractice;

import com.bit.CucumberPOMSeries.factory.DriverFactory;
import com.bit.CucumberPOMSeries.pages.AccountPage;
import com.bit.CucumberPOMSeries.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;
//import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class AccountsPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage;
    private String pageTitle;

    private List<String> expAccountSectionList,actAccountSectionList;

    private int actListCount;


    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credentialsTable) {
        String url = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
        List<Map<String,String>> credentials = credentialsTable.asMaps();
        String userName = credentials.get(0).get("username");
        String password = credentials.get(0).get("password");
        System.out.println("userName: "+userName);
        System.out.println("password: "+password);
        DriverFactory.getDriver().get(url);
        accountPage = loginPage.doLogin(userName,password);
    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        pageTitle = accountPage.getAccountsPageTitle();
        System.out.println("Page title: "+pageTitle);
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {

    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expPageTitle) {
        Assertions.assertTrue(pageTitle.contains(expPageTitle));
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionTable) {
        expAccountSectionList = sectionTable.asList();
        System.out.println("expAccountSectionList: "+expAccountSectionList);
        actAccountSectionList =  accountPage.getAccountsSectionList();
        System.out.println("actAccountSectionList: "+actAccountSectionList);
        Assertions.assertTrue(expAccountSectionList.containsAll(actAccountSectionList),"Account List is not correct");
//        Assertions.assertTrue(actAccountSectionList.containsAll(expAccountSectionList));
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expListCount) {
        actListCount = actAccountSectionList.size();
        Assertions.assertTrue(expListCount == actListCount);
    }
}
