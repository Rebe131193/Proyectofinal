package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQASteps extends BaseSteps{

    public DemoQASteps(WebDriver driver) {

        super(driver);
    }
   // public void abrirPaginaDemoQA(){
     //   webDriver.get("https://demoqa.com/text-box/");

    //    imprimir("Navegando en DemoQA");
  //  }
//    public boolean checkFullNameEmailIsDisplayed(){
//        WebElement fullName = webDriver.findElement(
//                By.cssSelector("input[type='text']")
//        );
//        imprimir("Full Name" + isCorrectlyDisplayedElement(fullName));
//        return isCorrectlyDisplayedElement(fullName);
//    }
//    public boolean checkEmailIsDisplayed(){
//        WebElement email = webDriver.findElement(
//                By.cssSelector("input[type='email']")
//        );
//        imprimir("Email: " + isCorrectlyDisplayedElement(email));
//        return isCorrectlyDisplayedElement(email);
//    }
//    public boolean checkCurrentAddressIsDisplayed(){
//        WebElement currentAddress = webDriver.findElement(
//                By.cssSelector("textarea[id='currentAddress']")
//        );
//        imprimir("Current Address: " + isCorrectlyDisplayedElement(currentAddress));
//        return isCorrectlyDisplayedElement(currentAddress);
//    }
//    public boolean permanentAddressIsDisplayed(){
//        WebElement permanentAddress = webDriver.findElement(
//                By.cssSelector("label[id='permanentAddress-label']")
//        );
//        imprimir("Permanent Address: " + isCorrectlyDisplayedElement(permanentAddress));
//        return isCorrectlyDisplayedElement(permanentAddress);
//    }

//    public boolean submitEnabled(){
//        WebElement submit = webDriver.findElement(
//                By.cssSelector("button[class='btn btn-primary']")
//        );
//        imprimir("Submit is enabled: " + isEnableElement(submit));
//        return isEnableElement(submit);
//    }

    public void fillForm(){
        WebElement sendFullName = webDriver.findElement(By.id("userName"));
        sendFullName.sendKeys("Yuri Ordaz");
        WebElement email = webDriver.findElement(By.id("userEmail"));
        email.sendKeys("yuri@gmail.com");
        WebElement currentAddress = webDriver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Av.Saturno #555");
        WebElement permanentAddress = webDriver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Calle Marte #888");
    }


    public void enviarFullName(String nombreCompleto){
        webDriver.findElement(By.id("userName")).sendKeys(nombreCompleto);
    }

    public void enviarEmail(String correoElectronico){
        webDriver.findElement(By.id("userEmail")).sendKeys(correoElectronico);
    }

    public void enviarCurrentAddress(String direccionActual){
        webDriver.findElement(By.id("currentAddress")).sendKeys(direccionActual);

    }

    public void enviarPermanentAddress(String direccionPermanente){
        webDriver.findElement(By.id("permanentAddress")).sendKeys(direccionPermanente);
    }

    public void clickSubmit(){
        WebElement botonSubmit = webDriver.findElement(By.cssSelector("button[id='submit']"));
        botonSubmit.click();
    }
}
