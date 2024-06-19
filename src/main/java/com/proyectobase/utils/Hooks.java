package com.proyectobase.utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeOptions;


public class Hooks {
    private  BrowserDriver driver;

    @Before
    public void setUp() {
        driver = new BrowserDriver();
    }
    @After
    public void tearDown() {
        driver.close();
    }

}
