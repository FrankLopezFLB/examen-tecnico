package com.proyectobase.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class Utility extends BrowserDriver {
    Logger logger = Logger.getLogger(getClass().getName());

    public static void implicitWait(int tiempoEnSegundos) throws InterruptedException {
        try {
            Thread.sleep (tiempoEnSegundos * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitElement(WebElement element, int timeOnSeconds) {
        return (new WebDriverWait(driver, Duration.ofSeconds(timeOnSeconds))).until(ExpectedConditions.visibilityOf(element));
    }

    public void generarEvidencia(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "evidencia");
    }

    /*Metodo para imprimir en consola*/
    public void print(String texto) {
        logger.info(texto);
    }
}
