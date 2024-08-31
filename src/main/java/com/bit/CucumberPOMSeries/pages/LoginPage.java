package com.bit.CucumberPOMSeries.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailIdTextBox = By.id("email");
    private By passwordTextBox = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
//    private By forgotPasswordLink = By.linkText("Forgot your password");
    private By forgotPasswordLink = By.linkText("Forgot your password?");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist()
    {
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public void enterUserName(String userName)
    {
        driver.findElement(emailIdTextBox).sendKeys(userName);
    }

    public void enterPassword(String password)
    {
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickOnSignIn()
    {
        driver.findElement(signInButton).click();
    }

    public AccountPage doLogin(String user,String pwd)
    {
        driver.findElement(emailIdTextBox).sendKeys(user);
        driver.findElement(passwordTextBox).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountPage(driver);
    }
}
