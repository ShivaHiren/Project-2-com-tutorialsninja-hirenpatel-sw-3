package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;


public class TopMenuTest extends Utility {

//    public void selectMenu(String menu) {
//        WebElement click = driver.findElement(By.xpath(""));
//        click.sendKeys(menu);
//    }

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    //Launching browser
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test//1
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
//        1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

//        1.2 call selectMenu method and pass the menu = “Show All Desktops”
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //selectMenu("Show All Desktops");

//        1.3 Verify the text ‘Desktops’
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Desktops')]"), "Desktops");
    }

    @Test//2
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

//        2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

//        2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

//        2.3 Verify the text ‘Laptops & Notebooks’
        verifyTextFromElements(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"),"");

    }

    @Test//3
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

//        3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));

//        3.2 call selectMenu method and pass the menu = “Show All Components”
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'Show All Components')]"));

//        3.3 Verify the text ‘Components’
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Components')]"),"Components");
    }

    @After
    public void testDown() {
        closeBrowser();
    }
}

