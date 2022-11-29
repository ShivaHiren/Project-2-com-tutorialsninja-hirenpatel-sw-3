package laptopsandnotebooks;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    //Launching browser
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test//1
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

//        1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

//        1.2 Click on “Show All Laptops & Notebooks”
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

//        1.3 Select Sort By "Price (High > Low)"
        Select productOrder = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        productOrder.selectByIndex(4);

//        1.4 Verify the Product price will arrange in High to Low order.
        verifyTextFromElements(By.xpath("//div[contains(text(),'Showing 1 to 5 of 5 (1 Pages)')]"),"Showing 1 to 5 of 5 (1 Pages)");

    }
    @Test//2
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

//        2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

//        2.2 Click on “Show All Laptops & Notebooks”
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

//        2.3 Select Sort By "Price (High > Low)"
        Select productOrder = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        productOrder.selectByIndex(3);

//        2.4 Select Product “MacBook”
        mouseHoverToElementAndClick(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        //clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/h4[1]/a[1]"));

//        2.5 Verify the text “MacBook”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'MacBook')]"),"MacBook");

//        2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));


//        2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyTextFromElements(By.xpath("//a[contains(text(),'shopping cart')]"),"shopping cart");


//        2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

//        2.9 Verify the text "Shopping Cart"
        verifyTextFromElements(By.xpath("//h1[contains(text(),' (0.00kg)')]"),"Shopping Cart  (0.00kg)");


//        2.10 Verify the Product name "MacBook"
        verifyTextFromElements(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"MacBook");


//        2.11 Change Quantity "2"
        clearTheText(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");
        Thread.sleep(1500);


//        2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

//        2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyTextFromElements(By.xpath("//body/div[@id='checkout-cart']/div[1]"), "Success: You have modified your shopping cart!\n" +
                "×");

        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Currency')]"));
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));
        Thread.sleep(1000);

//        2.14 Verify the Total £737.45£737.45
        verifyTextFromElements(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"),"$1,204.00");

//        2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

//        2.16 Verify the text “Checkout”
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Checkout')]"),"Checkout");
        Thread.sleep(1000);

//        2.17 Verify the Text “New Customer”
        verifyTextFromElements(By.xpath("//h2[contains(text(),'New Customer')]"),"New Customer");

//        2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));

//        2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

//        2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Jhon");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Wick");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "jhon@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"0123456789");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"1 London road");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"LL10LL");
        clickOnElement(By.xpath("//option[contains(text(),'United Kingdom')]"));
        clickOnElement(By.xpath("//option[contains(text(),'Greater London')]"));




//        2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

//        2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]\n"),"Can I have delivery before 3PM");

//        2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));

//        2.24 Click on “Continue” button
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]\n"));

//        2.25 Verify the message “Warning: Payment method required!
        verifyTextFromElements(By.xpath("//div[@id='collapse-payment-method']"),"Warning: No Payment options are available. Please contact us for assistance!\n" +
                "Add Comments About Your Order\n" +
                "I have read and agree to the Terms & Conditions  ");


    }
    @After
    public void testDown() {
        closeBrowser();
    }
}
