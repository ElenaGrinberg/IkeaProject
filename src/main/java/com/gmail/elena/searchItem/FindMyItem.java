package com.gmail.elena.searchItem;

import com.gmail.elena.fileManage.FileManager;
import com.gmail.elena.utilits.SharedDriver;

import java.io.IOException;

import static com.gmail.elena.constants.Const.FOUND_ITEM;
import static com.gmail.elena.searchItem.UserInteraction.inputCatalogNumber;
import static com.gmail.elena.searchItem.UserInteraction.inputManualOrAutomaticChoice;

public class FindMyItem {

    // USER CHOICE
    static final int MANUAL_INPUT = 1;
    static final int SAVED_DATA = 2;


    public static void findItemInIkea() {
        Item myItem = new Item();
//        WebDriver webDriver = SharedDriver.getWebDriver();
        Page page = new Page();
        DriverFunctions fun = new DriverFunctions();
        int dataSource = inputManualOrAutomaticChoice();
        page.navigateToStartPage();

        switch (dataSource) {
            case MANUAL_INPUT:
                page.selectCountry(UserInteraction.inputCounty());
                page.acceptCookies();
                myItem.setProduct(inputCatalogNumber());
                page.findItemByNumber(myItem);
                if (myItem.getNumber() > 1) {
                    UserInteraction.printMultipleProductMessage(myItem);
                } else if (myItem.getNumber() == 0) {
                    UserInteraction.printProductNotFoundMessage(myItem);
                    FileManager.addLineToSearchResultFile(myItem);
                } else {
                    fun.clickElementByXpath(FOUND_ITEM);
                    page.getItemPrice(myItem);
                    myItem.setMyCity(UserInteraction.inputCity(page.getCitiesList()));
                    page.navigateToCity(myItem);
                    page.getItemAmount(myItem);
                    UserInteraction.printProductAmountMessage(myItem);
                    UserInteraction.printPrice(myItem);
                    FileManager.addLineToSearchResultFile(myItem);
                }
                break;

            case SAVED_DATA:
                try {
                    FileManager.readFromFile(myItem);
                } catch (IOException e) {
                    e.printStackTrace();
                    UserInteraction.printErrorReadingFromFileMessage();
                    break;
                }
                page.selectCountry(myItem.getCountry());
                page.acceptCookies();
                page.findItemByNumber(myItem);
                if (myItem.getNumber() == 0) {
                    FileManager.addLineToSearchResultFile(myItem);
                } else {
                    fun.clickElementByXpath(FOUND_ITEM);
                    page.getItemPrice(myItem);
                    page.navigateToCity(myItem);
                    page.getItemAmount(myItem);
                    FileManager.addLineToSearchResultFile(myItem);
                }
                break;
        }
        SharedDriver.quitDriver();
    }
    public static void autoSearch(){
        Item myItem = new Item();
//        WebDriver webDriver = SharedDriver.getWebDriver();
        Page page = new Page();
        DriverFunctions fun = new DriverFunctions();
        page.navigateToStartPage();
        try {
           FileManager.readFromFile(myItem);
        } catch (IOException e) {
            e.printStackTrace();
            UserInteraction.printErrorReadingFromFileMessage();

        }
        page.selectCountry(myItem.getCountry());
        page.acceptCookies();
        page.findItemByNumber(myItem);
        if (myItem.getNumber() == 0) {
            FileManager.addLineToSearchResultFile(myItem);
        } else {
            fun.clickElementByXpath(FOUND_ITEM);
            page.getItemPrice(myItem);
            page.navigateToCity(myItem);
            page.getItemAmount(myItem);
            FileManager.addLineToSearchResultFile(myItem);
            SharedDriver.quitDriver();
        }

    }


}
