package com.proyectobase.stepdefinition;

import com.proyectobase.pages.LoginPage;
import com.proyectobase.utils.BrowserDriver;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;

public class LoginStepDefinition {
    BrowserDriver browserDriver = new BrowserDriver();
    LoginPage loginPage = new LoginPage(BrowserDriver.driver);

    @Dado("^que el usuario ingresa al aplicativo$")
    public void ingresarAlAplicativo() throws Exception {
        browserDriver.browserDriver();
        loginPage.ingresarAlAplicativo();
    }
    @Cuando("^el \"([^\"]*)\" ingresa en el modal de Login$")
    public void ingresarElUsuario(String user) throws InterruptedException {
        loginPage.ingresaElUsuario(user);
    }
    @Y("^ingresa la contrasena \"([^\"]*)\" en el modal de Login$")
    public void ingresarElPassword(String pass) throws InterruptedException {
        loginPage.ingresarElPassword(pass);
    }
    @Entonces("^se motrara \"([^\"]*)\" en el menu$")
    public void validarLogin(String mensaje) throws InterruptedException {
       Assert.assertTrue( loginPage.validarLogin(mensaje));
       browserDriver.quit();
    }
}
