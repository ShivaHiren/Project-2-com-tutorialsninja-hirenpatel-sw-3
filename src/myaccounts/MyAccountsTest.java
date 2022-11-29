package myaccounts;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    //Launching browser
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        if (option.equalsIgnoreCase("Register")) {
            clickOnElement(By.xpath("//li[@class='dropdown open']/ul/li[1]"));
        } else if (option.equalsIgnoreCase("Login")) {
            clickOnElement(By.xpath("//li[@class='dropdown open']/ul/li[2]"));
        }
    }


    @Test//1
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

//        1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

//        1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

//        1.3 Verify the text “Register Account”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Register Account')]"), "Register Account");
    }

    @Test//2
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
//    2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

//    2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

//    2.3 Verify the text “Returning Customer”.
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Returning Customer')]"), "Returning Customer");

    }

    @Test//3
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
//    3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

//    3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

//    3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Jhon");

//    3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Wick");

//    3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "Jhon207@gmail.com");

//    3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "0123456789");

//    3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Jhon");

//    3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "Jhon");

//    3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));

        //    3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));


//    3.11 Click on Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));


//    3.12 Verify the message “Your Account Has Been Created!”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"), "Your Account Has Been Created!");


//    3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

//    3.14 Click on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));

//    3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));
        //Thread.sleep(1000);

//    3.16 Verify the text “Account Logout”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");

//    3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));


    }

    @Test//4
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
//    4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

//    4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

//    4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "Jhon202@gmail.com");

//    4.4 Enter Last Name
        //sendTextToElement(By.xpath("//input[@id='input-password']"), "Wick");


//    4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Jhon");


//    4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));

//    4.7 Verify text “My Account”
        verifyTextFromElements(By.xpath("//h2[contains(text(),'My Account')]"),"My Account");

//    4.8 Click on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));

//    4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));
        //Thread.sleep(1000);

//    4.10 Verify the text “Account Logout”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");


//    4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }
    @After
    public void testDown() {
        closeBrowser();
    }

}
