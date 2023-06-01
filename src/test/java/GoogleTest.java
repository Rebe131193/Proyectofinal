import Steps.GoogleSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{
   private WebDriver safariDriver = getWebDriver();
   private GoogleSteps googleSteps = new GoogleSteps(safariDriver);
    private  String baseURL;

    private static final String KEY = "webdriver.pagina_web.url";


    @BeforeClass(description = "Antes de empezar", groups = {"Fumadores"})
    public void beforeClass(ITestContext context) {
        baseURL = context.getCurrentXmlTest().getParameter(KEY);
        System.out.println("webdriver.pagina_web.url = " + baseURL);
        Reporter.log("Antes de iniciar URL: " + baseURL);
        googleSteps.abrirPaginaGoogle(baseURL);

    }

    @AfterClass(description = "Terminamos la prueba", alwaysRun = true)
    public void terminamos(){
        googleSteps.terminarPrueba();
        Reporter.log("Terminamos la prueba.", false);
    }

   public void empezar(){
       Reporter.log("Antes2 de iniciar URL: " + baseURL);
       safariDriver.get(baseURL);
       //safariDriver.navigate().to("http://www.imss.gob.mx");
       //safariDriver.quit();
   }




    public void visible(String element, boolean visible){
        boolean modal = googleSteps.modalVisible(element);


        if(visible == true){
            Assert.assertTrue(modal, "Modal Abierto.");
            Reporter.log("Modal Abierto.");
        } else {
            Assert.assertFalse(modal, "Modal cerrado.");
            Reporter.log("Modal cerrado.");
        }





    }

    @Test(description = "Prueba About Page", groups = {"Fumadores"}, priority = 1)
    public  void aboutPage(ITestContext context) throws InterruptedException {
        Reporter.log("Ejecutando la prueba de ir a la página About.");

        googleSteps.clickElemento("//*[@id=\"navbarExample\"]/ul/li[3]/a");
        Thread.sleep(500);

        visible("//*[@id=\"videoModal\"]", true);
        googleSteps.clickElemento("//*[@id=\"example-video\"]/button");
        Thread.sleep(1000);

        googleSteps.clickElemento("//*[@id=\"videoModal\"]/div/div/div[3]/button");
        Thread.sleep(500);
        visible("//*[@id=\"videoModal\"]", false);
    }


    @Test(description = "Prueba3", groups = {"Fumadores"}, priority = 2)
    public  void formularioContacto(ITestContext context) throws InterruptedException {
        String correo = context.getCurrentXmlTest().getParameter("webdriver.contacto.correo");
        String nombre = context.getCurrentXmlTest().getParameter("webdriver.contacto.nombre");
        String mensaje = context.getCurrentXmlTest().getParameter("webdriver.contacto.mensaje");
        String alerta = context.getCurrentXmlTest().getParameter("webdriver.contacto.alerta");

        Reporter.log("Valor de variable correo: " + correo);
        Reporter.log("Valor de variable nombre: " + nombre);
        Reporter.log("Valor de variable mensaje: " + mensaje);
        Reporter.log("Valor de variable alerta: " + alerta);
        Reporter.log("Ejecutando la prueba de envio de formulario de contacto.");


        //loginSteps.finalizarWebDriver();
        googleSteps.clickElemento("//*[@id=\"navbarExample\"]/ul/li[2]/a");
        Thread.sleep(500);
        googleSteps.rellenarFormulario(correo, "recipient-email");
        googleSteps.rellenarFormulario(nombre, "recipient-name");
        googleSteps.rellenarFormulario(mensaje, "message-text");

        googleSteps.clickElemento("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]");
        Thread.sleep(500);

        visible("//*[@id=\"exampleModal\"]", false);

        googleSteps.clickElemento("//*[@id=\"navbarExample\"]/ul/li[2]/a");
        Thread.sleep(500);
        Reporter.log("Modal abierto.");
        googleSteps.clickElemento("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");
        //driver2.quit();


        String mensajeAlerta = googleSteps.validarAlerta();

        Assert.assertEquals(mensajeAlerta, alerta);

        //WebDriverControlador.navigate().to("https://www.facebook.com");

        //googleSteps.enviarBusquedaEnGoogle("Selenium");

    }

    @Test(description = "Prueba Registro", groups = {"Fumadores"}, priority = 3)
    public  void registro(ITestContext context) throws InterruptedException {
        Reporter.log("Ejecutando la prueba de registro de usuario.");
        String usuario = context.getCurrentXmlTest().getParameter("webdriver.login.login.usuario");
        String contra = context.getCurrentXmlTest().getParameter("webdriver.login.login.contra");
        String alertaOK = context.getCurrentXmlTest().getParameter("webdriver.login.registro.mensaje.ok");
        String alertaError = context.getCurrentXmlTest().getParameter("webdriver.login.registro.mensaje.error");
        String alertaExiste = context.getCurrentXmlTest().getParameter("webdriver.login.registro.mensaje.existe");

        Reporter.log("Valor de variable usuario: " + usuario);
        Reporter.log("Valor de variable contra: " + contra);
        Reporter.log("Ejecutando la prueba de envio de formulario de registro.");
        Thread.sleep(500);
        googleSteps.clickElemento("//*[@id=\"signin2\"]");
        Thread.sleep(500);
        visible("//*[@id=\"signInModal\"]", true);
        Thread.sleep(500);

        googleSteps.rellenarFormulario(usuario, "sign-username");
        googleSteps.rellenarFormulario(contra, "sign-password");

        googleSteps.clickElemento("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]");
        Thread.sleep(500);
        visible("//*[@id=\"signInModal\"]", false);

        googleSteps.clickElemento("//*[@id=\"signin2\"]");
        Thread.sleep(500);
        Reporter.log("Modal abierto.");


        if(googleSteps.obtenerTexto("sign-username") != null && googleSteps.obtenerTexto("sign-password") != null && googleSteps.obtenerTexto("sign-password") != googleSteps.obtenerTexto("sign-username") ) {
            googleSteps.clickElemento("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
        } else {
            Thread.sleep(500);
            String mensajeAlerta = googleSteps.validarAlerta();

            // Assert.assertEquals(mensajeAlerta, alertaError);
            Assert.assertEquals(mensajeAlerta, alertaError);
        }

        Thread.sleep(500);
        String mensajeAlerta = googleSteps.validarAlerta();

        if(mensajeAlerta != alertaOK){
            Assert.assertEquals(mensajeAlerta, alertaExiste);
        } else {
            Assert.assertEquals(mensajeAlerta, alertaOK);
        }


        Thread.sleep(500);
        googleSteps.clickElemento("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]");
        Thread.sleep(500);



       // Assert.assertEquals(mensajeAlerta, alertaError);




       // Assert.assertEquals(mensajeAlerta, alertaOK);



    }

    @Test(description = "Prueba Login", groups = {"Fumadores"}, priority = 4)
    public  void login(ITestContext context) throws InterruptedException {
        Reporter.log("Ejecutando la prueba de login de usuario.");
        String usuario = context.getCurrentXmlTest().getParameter("webdriver.login.login.usuario");
        String contra = context.getCurrentXmlTest().getParameter("webdriver.login.login.contra");
        String alertaError = context.getCurrentXmlTest().getParameter("webdriver.login.login.mensaje.error");
        String alertaExiste = context.getCurrentXmlTest().getParameter("webdriver.login.login.mensaje.existe");

        Reporter.log("Valor de variable usuario: " + usuario);
        Reporter.log("Valor de variable contra: " + contra);
        Reporter.log("Ejecutando la prueba de envio de formulario de login.");
        Thread.sleep(500);
        googleSteps.clickElemento("//*[@id=\"login2\"]");
        Thread.sleep(500);
        visible("//*[@id=\"logInModal\"]", true);
        Thread.sleep(500);

        googleSteps.rellenarFormulario(usuario, "loginusername");
        googleSteps.rellenarFormulario(contra, "loginpassword");

        googleSteps.clickElemento("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]");
        Thread.sleep(500);
        visible("//*[@id=\"logInModal\"]", false);

        googleSteps.clickElemento("//*[@id=\"login2\"]");
        Thread.sleep(500);
        Reporter.log("Modal abierto.");


        if(googleSteps.obtenerTexto("loginusername") != null && googleSteps.obtenerTexto("loginpassword") != null ) {
            googleSteps.clickElemento("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
        } else {
            Thread.sleep(500);
            String mensajeAlerta = googleSteps.validarAlerta();

            // Assert.assertEquals(mensajeAlerta, alertaError);
            Assert.assertEquals(mensajeAlerta, alertaError);
        }


        Thread.sleep(500);

        String mensajeAlerta = googleSteps.validarAlerta();
        Thread.sleep(500);

        if(mensajeAlerta == alertaError){
            System.out.println("MODALLALLALALA" + mensajeAlerta);
            Thread.sleep(500);
            //visible("//*[@id=\"logout2\"]", true);
            Reporter.log("Logueo exitoso");
        } else {
            System.out.println("-----------" + mensajeAlerta);
            System.out.println("-----------" + alertaError);
            Reporter.log(mensajeAlerta);

        }

        // Assert.assertEquals(mensajeAlerta, alertaError);




        // Assert.assertEquals(mensajeAlerta, alertaOK);



    }
}
