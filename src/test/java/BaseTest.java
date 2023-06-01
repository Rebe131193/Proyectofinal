import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.util.List;


public class BaseTest {
    private WebDriver webDriver;
    private SafariDriver driver;
    private ChromeDriver driverChrome;

    private SafariOptions opciones;
    public SafariDriver getWebDriver(){
        System.setProperty("webdriver.safari.driver",  "/usr/bin/safaridriver");
            SafariOptions opciones = new SafariOptions();
            //opciones.setAutomaticInspection(true);
            opciones.setUseTechnologyPreview(true);
            driver = new SafariDriver(opciones);
            return driver;
    }

    public void PruebaDos(){
        driver = new SafariDriver();
        driver.get("http://www.google.com");

// Click on the search text box and send value
        WebElement prueba = driver.findElement(By.cssSelector("textarea[name='q']"));

        prueba.sendKeys("Por que amo tanto a mi esposa?");

// Click on the search button

        WebElement pruebasss = driver.findElement(By.xpath("#botstuff > div > div:nth-child(2) > table > tbody > tr > td:nth-child(6) > a"));
        pruebasss.click();
//        List<WebElement> elemento = driver.findElements(By.cssSelector("tr[jsname='TeSSVd']"));
  //      elemento.get(0).click();

                //click();


// Close the Browser
//        driver.close();

    }




}