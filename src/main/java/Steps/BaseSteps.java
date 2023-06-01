package Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseSteps {
    public WebDriver webDriver;

    public BaseSteps(WebDriver driver){
        this.webDriver=driver;

    }

    public String getTituloPagina(){
        return webDriver.getTitle();
    }


}