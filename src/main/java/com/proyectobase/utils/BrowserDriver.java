package com.proyectobase.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class BrowserDriver {
    public static WebDriver driver = new ChromeDriver();
    public ChromeOptions options;

    /*Metodo para abrir el navegador y la URL*/
    public void browserDriver() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/drivers/chromedriver.exe");
        driver.get("https://demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    public void close() {
        BrowserDriver.driver.close();
    }

    public void quit() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }
}
