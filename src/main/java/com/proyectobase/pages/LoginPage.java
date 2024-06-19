package com.proyectobase.pages;

import com.proyectobase.utils.BrowserDriver;
import com.proyectobase.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;




public class LoginPage extends BrowserDriver {
    /*Selectores Page Factory*/
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

    /*Instancias*/
    Utility util = new Utility();


    public LoginPage(WebDriver driver) {
        BrowserDriver.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ingresarAlAplicativo() throws Exception {
        util.print("ingrese al aplicativo");
        util.implicitWait(5);
        lblLogIn.click();
    }

    public void ingresaElUsuario(String usuario) throws InterruptedException {
        util.waitElement(txtUserName, 15);
        txtUserName.sendKeys(usuario);
        util.implicitWait(2);
    }

    public void ingresarElPassword(String pass) throws InterruptedException {
        util.waitElement(txtPassword, 15);
        txtPassword.sendKeys(pass);
        util.implicitWait(2);
        btnLogin.get(2).click();
        util.implicitWait(2);
    }

    public boolean validarLogin(String mensaje) {
        return mensaje.equalsIgnoreCase(lblMensaje.getText());
    }




}
