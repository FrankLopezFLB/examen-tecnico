package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserDriver;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BrowserDriver {
    @FindBy(id = "nava")
    WebElement title;
    @FindBy(id = "login2")
    static WebElement lblLogIn;
    @FindBy(id = "loginusername")
    WebElement txtUserName;
    @FindBy(id = "loginpassword")
    WebElement txtPassword;
    @FindBy(id = "nameofuser")
    WebElement lblMensaje;
    @FindBy(className = "btn-primary")
    List<WebElement> btnLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void ingresarAlAplicativo() throws Exception {
        print("ingrese al aplicativo");
        implicitWait(5);
        lblLogIn.click();
        print("se hizo click");
    }
    public void ingresaElUsuario(String usuario) throws InterruptedException {
        waitElement(txtUserName,15);
        txtUserName.sendKeys(usuario);
        implicitWait(2);
    }

    public void ingresarElPassword(String pass) throws InterruptedException {
        waitElement(txtPassword,15);
        txtPassword.sendKeys(pass);
        implicitWait(2);
        btnLogin.get(2).click();
        implicitWait(2);
    }

    public boolean validarLogin(String mensaje)throws InterruptedException {
        return mensaje.equalsIgnoreCase(lblMensaje.getText());
    }
    public static void print(String texto){
        System.out.println(texto);
    }
    /*Metodos utilitarios*/
    public static void implicitWait(int tiempoEnSegundos) throws InterruptedException {
        try {
            Thread.sleep((long) (tiempoEnSegundos * 1000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static WebElement waitElement(WebElement element, int timeOnSeconds){
        return (WebElement) (new WebDriverWait(driver, Duration.ofSeconds(timeOnSeconds))).until(ExpectedConditions.visibilityOf(element));
    }

}
