package com.gmail.elena.utilits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SharedDriver {

    static Logger log = LogManager.getLogger(SharedDriver.class);
    static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
//            options.addArguments("--headless");
            options.addArguments("window-size=1920,1080");
            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            log.info("Driver was closed");
            webDriver = null;
        }
    }
}
