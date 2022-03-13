package com.gmail.elena.searchItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.List;

import static com.gmail.elena.constants.Const.*;
import static com.gmail.elena.searchItem.DriverFunctions.getValuesByXpath;

public class Page {

    public static final Logger logger = LogManager.getLogger(Page.class);
    private WebDriver webDriver;

    public Page() {

    }

    public void navigateToStartPage() {
        DriverFunctions.navigateToPageByURL(IKEA_INTERNATIONAL_URL);
        acceptCookies();
    }


    public void selectCountry(String county) {
        DriverFunctions.clickElementByXpath(CHOOSING_COUNTRY_ARROW);
        DriverFunctions.sendTextByXpath(FIND_ONLINE_STORE, county);
        DriverFunctions.clickElementByXpath(RESULT_SEARCH_LOCATION);
        DriverFunctions.clickElementByXpath(GO_SHOPPING_LINK);
    }

    public void acceptCookies() {
        if (DriverFunctions.isElementDisplayed(POLICY_TEXT_PATH)) {
            DriverFunctions.clickElementByXpath(ACCEPT_COOKIES);
        }
    }

    public static void findItemByNumber(Item myItem) {
        int number = 0;
        String product = myItem.getProduct();
        if (DriverFunctions.isElementExist(FIND_PRODUCT)) {
            DriverFunctions.sendTextByXpath(FIND_PRODUCT, product);
        }
        DriverFunctions.sendEnterKey(FIND_FIELD_WITH_INPUT);
        closeHiMessage();
        String foundItems = DriverFunctions.getTextByXpath(AMOUNT_ITEMS_FOUND_PATH);
        try {
            number = Integer.parseInt(foundItems);

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        myItem.setNumber(number);
    }

    public static void closeHiMessage() {
        if (DriverFunctions.isElementDisplayed(HI_MESSAGE_PATH)) {
            logger.info("Hi message is appearing");
            DriverFunctions.clickElementByXpath(CLOSE_HI_MESSAGE_PATH);
        }
    }

    public static String getStatusDot() {
        String dotColor;
        dotColor = DriverFunctions.findElementByXpath(STATUS_DOT).getCssValue("background-color");
        Color color = Color.fromString(dotColor);
        return color.asHex();
    }

    public void getItemPrice(Item myItem) {
        myItem.setPrice(DriverFunctions.getTextByXpath(PRICE_XPATH));
        DriverFunctions.clickElementByXpath(CHEK_AVAILABILITY_LINK);
    }

    public List<String> getCitiesList() {
        List<WebElement> cities = getValuesByXpath(CITIES_PATCH);
        List<String> citiesNames = new ArrayList<>();
        for (WebElement city : cities) {
            citiesNames.add(city.getText());
        }
        return citiesNames;
    }

    public void navigateToCity(Item myItem) {
        DriverFunctions.sendTextByXpath(CHANGE_STORE_INPUT, myItem.getMyCity());
        DriverFunctions.clickElementByXpath(RADIO_SELECTED_SHOP);
    }

    public void getItemAmount(Item myItem) {
        if (!getStatusDot().equals(RED)) {
            DriverFunctions.clickElementByXpath(BUTTON_ACCEPT_CHOICE);
            myItem.setAmount(DriverFunctions.getTextByXpath(AMOUNT_ITEMS_PATH));
        }
    }
}
