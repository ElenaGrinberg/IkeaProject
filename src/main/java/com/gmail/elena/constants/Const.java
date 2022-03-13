package com.gmail.elena.constants;

public class Const {

    //open local shop Site
    public static final String IKEA_INTERNATIONAL_URL = "https://www.ikea.com/";
    public static final String POLICY_TEXT_PATH = "//p[@id = 'onetrust-policy-text']";
    public static final String ACCEPT_COOKIES = "//div[@class='banner-actions-container']//button[@id='onetrust-accept-btn-handler']";
    public static final String CHOOSING_COUNTRY_ARROW = "//span[@class ='chevron svelte-1tofppr']";
    public static final String FIND_ONLINE_STORE = "//input[@placeholder = 'Find online store']";
    public static final String RESULT_SEARCH_LOCATION = "//button[@class = 'option svelte-1tofppr']";
    public static final String GO_SHOPPING_LINK = "//span[text() = 'Go shopping']";
    public static final String FIND_PRODUCT = "//input[@class = 'search-field__input']";
    public static final String FIND_FIELD_WITH_INPUT = "//input[@class ='search-field__input search-field__input--has-input']";


    //work with result of search request
    public static final String FOUND_ITEM = "//div[@class ='pip-compact-price-package__price-wrapper']";
    public static final String AMOUNT_ITEMS_FOUND_PATH = "//span[@class='navigation-item__link-count']";

    //Close Hi Message
    public static final String HI_MESSAGE_PATH = "//p[@class = 'hnf-toast__text']";
    public static final String CLOSE_HI_MESSAGE_PATH = "//span[@class='hnf-btn__inner hnf-btn__inner--icon-tertiary-inverse hnf-btn--xsmall']";


    //Data of item
    public static final String CITIES_PATCH = "//div[@class ='range-revamp-change-store__store-info']";
    public static final String PRICE_XPATH = "//div[@class ='pip-pip-price-package__main-price']";

    //    public static final String PRICE_XPATH = "//span[@class='range-revamp-price__integer']";
//    public static final String PRICE_XPATH = "//div[@class='range-revamp-pip-price-package__main-price']";
    public static final String PRICE_DECiMAL_XPATH = "//span[@class='range-revamp-price__decimals']";
    public static final String CHEK_AVAILABILITY_LINK = "//a[@class ='pip-stockcheck__available-for-delivery-link pip-link']";
    public static final String CHANGE_STORE_INPUT = "//input[@id ='change-store-input']";
    public static final String RADIO_SELECTED_SHOP = "//input[@name ='radioname']";
    public static final String BUTTON_ACCEPT_CHOICE = "//button[@class = 'pip-btn pip-btn--primary']";
    public static final String AMOUNT_ITEMS_PATH = "//span[@class ='pip-store-info__quantity--bold']";
    public static final String STATUS_DOT = "//span[@class='pip-status__dot']";


    //constant of color background
    public static final String RED = "#e00751";

}
