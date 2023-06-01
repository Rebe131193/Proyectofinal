package Steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class GoogleSteps extends BaseSteps {
    public GoogleSteps(WebDriver driver){
        super(driver);
    }

    public void abrirPaginaGoogle(String pagina){
        webDriver.get(pagina);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
    }

    public void clickElemento(String elemento){
        webDriver.findElement(By.xpath(elemento)).click();
    }


    public  String getUrlActual(){
       return webDriver.getCurrentUrl();
    }

    public String getTituloActual(){
        return  webDriver.getTitle();
    }

    public void terminarPrueba(){
        webDriver.quit();
    }

    public void enviarBusquedaEnGoogle(String busqueda ){
       // WebElement prueba = webDriver.findElement("$$(\"textarea[name='q']\")");

    }

    public void regresar(){
        webDriver.navigate().back();
    }
    public  void adelantar(){
        webDriver.navigate().forward();
    }
    public void refresh(){
        webDriver.navigate().refresh();
    }

    public boolean modalVisible(String elemento){
        WebElement visible = webDriver.findElement(By.xpath(elemento));//Selector por hijos (children or child)
        return visible.isDisplayed();

    }

    public String validarAlerta() throws InterruptedException {
        Alert alert = webDriver.switchTo().alert(); // switch to alert

        String alertMessage= webDriver.switchTo().alert().getText(); // capture alert message

        System.out.println(alertMessage); // Print Alert Message
        Thread.sleep(500);
        alert.accept();
        return alertMessage;
    }

    public String obtenerTexto(String elemento){
        return  webDriver.findElement(By.id(elemento)).getText();
    }
    public void rellenarFormulario(String texto, String elemento){
        WebElement element = webDriver.findElement(By.id(elemento));
        //
        System.out.println(element);

        System.out.println(texto);
        element.sendKeys(texto);
        //webDriver.findElement(By.id("recipient-email")).sendKeys("corerosls@jas.com");


    }


}