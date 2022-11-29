package desktops;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    //Launching browser
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test//1
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

//        1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

//        1.2 Click on “Show All Desktops”
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Show All Desktops')]"));

//        1.3 Select Sort By position "Name: Z to A"
        Select productOrder = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        productOrder.selectByIndex(2);
        Thread.sleep(1000);

//        1.4 Verify the Product will arrange in Descending order.
        verifyTextFromElements(By.xpath("//p[contains(text(),'Example of category description text')]"), "Example of category description text");
    }

    @Test//2
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
//    2.1 Mouse hover on Desktops Tab. and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

//    2.2 Click on “Show All Desktops”
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Show All Desktops')]"));

//    2.3 Select Sort By position "Name: A to Z"
        Select productOrder = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        productOrder.selectByIndex(1);

//    2.4 Select product “HP LP3065”
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));

//    2.5 Verify the Text "HP LP3065"
        verifyTextFromElements(By.xpath("//h1[contains(text(),'HP LP3065')]"), "HP LP3065");

//    2.6 Select Delivery Date "2022-11-30"
        clearTheText(By.xpath("//input[@id='input-option225']"));
        sendTextToElement(By.xpath("//input[@id='input-option225']"),"2022-11-30");


//    2.7.Enter Qty "1” using Select class.
        clearTheText(By.xpath("//input[@id='input-quantity']"));
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");
        //mouseHoverToElementAndClick(By.xpath("//button[@id='button']"));

//    2.8 Click on “Add to Cart” button
       // clickOnElement(By.xpath("//button[@id='button']"));
        clickOnElement(By.xpath("//button[@id='button-cart']"));

//    2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        //verifyTextFromElements(By.xpath("//a[contains(text(),'shopping cart')]"),"shopping cart");

//    2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));


//    2.11 Verify the text "Shopping Cart"
        verifyTextFromElements(By.xpath("//a[contains(text(),'Shopping Cart')]"),"Shopping Cart");


//    2.12 Verify the Product name "HP LP3065"
        verifyTextFromElements(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"HP LP3065");

//    2.13 Verify the Delivery Date "2022-11-30"
        verifyTextFromElements(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]"),"Delivery Date: 2022-11-30");

//    2.14 Verify the Model "Product21"
        verifyTextFromElements(By.xpath("//td[contains(text(),'Product 21')]"),"Product 21");

//    2.15 Verify the Todat "£74.73"//button[@id='button']
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Currency')]"));
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));
        Thread.sleep(1000);
        verifyTextFromElements(By.xpath("//tbody/tr[1]/td[6]"),"£74.73");

    }
//
    @After
    public void testDown() {
        closeBrowser();
    }

}