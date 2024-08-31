package com.bit.CucumberPOMSeries.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

        private final By accountSection = By.cssSelector("div#center_column span");
//    private final By accountSection = By.cssSelector("//*[@id='center_column']/div/div/ul/li/a/span");
//    private final By accountSection = By.cssSelector("//*[@class='myaccount-link-list']/li/a/span");
//    private final By accountSection = By.cssSelector("//*[@class='myaccount-link-list']/li/a/span");

    public String getAccountsPageTitle()
    {
        return driver.getTitle();
    }

    public List<String> getAccountsSectionList()
    {
        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements(accountSection);
        for(WebElement elm:accountsHeaderList)
        {
            String text = elm.getText();
            System.out.println("Account section header list item: "+text);
            accountsList.add(text);
        }
        return accountsList;
    }

}