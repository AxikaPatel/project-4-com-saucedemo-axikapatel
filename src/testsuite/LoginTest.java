package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest
{
    String baseURL = "https://www.saucedemo.com/";

    @Before
    public void setup()
    {
        openBrowser(baseURL);

    }

    @Test
    public void userSholdLoginSuccessfullyWithValid()
    {
        //Enter username
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys(("standard_user"));

        //Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        String expectedMessage ="Products";

        //Verify the text “PRODUCTS”
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage()
    {
        //Enter username
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");

        //Enter password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        
        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualnumber = number.size();
        int expectednumber = 6;

        //checking actual and expected result
        Assert.assertEquals("6 product not displayed", expectednumber, actualnumber);

    }


    @After
    public void teardown()
    {
       // closeBrowser();
    }

}
