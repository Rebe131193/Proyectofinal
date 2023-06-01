package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQASelectMenuPage extends BasePage {


    public DemoQASelectMenuPage(WebDriver _webDriver) {
        super(_webDriver);
    }

    private WebElement setListaColores(){
        return webDriver.findElement(By.id("oldSelectMenu"));

    }
    public WebElement getListaColores(){
        return setListaColores();
    }
}
