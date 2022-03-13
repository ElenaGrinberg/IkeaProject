package com.gmail.elena.searchItem;

import com.gmail.elena.utilits.SharedDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DriverFunctions {

    public static final Logger logger = LogManager.getLogger(DriverFunctions.class);
    protected static WebDriver webDriver = SharedDriver.getWebDriver();
    protected static WebDriverWait wait1 = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    public static boolean isElementDisplayed(String xpath) {
        List<WebElement> webElementList = new ArrayList<>();
        try {
            webElementList = webDriver.findElements(By.xpath(xpath));

        } catch (Error e) {
            logger.info("Error find elements" + e);
            takeScreenshot("isVisible");
        }
        return webElementList.size() > 0;
    }

    public static boolean isElementExist(String xpath) {
        try {
            logger.info("Check element with xpath exists: " + xpath);
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public static void navigateToPageByURL(String pageURL) {
        webDriver.get(pageURL);
    }

    protected static void clickElementByXpath(String xpath) {
        logger.info("Clicking element with xpath :" + xpath);
        webDriver.findElement(By.xpath(xpath)).click();
    }

    protected static String getTextByXpath(String xpath) {
        return webDriver.findElement(By.xpath(xpath)).getText();
    }

    protected static WebElement findElementByXpath(String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }

    protected static List<WebElement> getValuesByXpath(String xpath) {
        return webDriver.findElements(By.xpath(xpath));
    }


    protected static void sendTextByXpath(String xpath, String key) {
        webDriver.findElement(By.xpath(xpath)).sendKeys(key);
    }

    protected static void sendEnterKey(String xpath) {
        webDriver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
    }

    public static void takeScreenshot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("takeScreenshot." + e);
        }
    }
}
