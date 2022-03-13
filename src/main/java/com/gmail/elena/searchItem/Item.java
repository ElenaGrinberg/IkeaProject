package com.gmail.elena.searchItem;

public class Item {

    private String amount;
    private String product;
    private String price;
    private int number;
    private String myCity;
    private String location;

    public Item(){
    }

    public String getProduct(){
        return product;
    }
    public String setProduct(String produce){
        return this.product = produce;
    }
    public String getPrice(){
        return price;
    }
    public String setPrice(String price){
        return this.price = price;
    }
    public String getAmount(){
        return amount;
    }
    public String setAmount(String amount){
        return this.amount = amount;
    }
    public int getNumber(){
        return number;
    }
    public int setNumber(int number){
        return this.number = number;
    }
    public String getMyCity() {
        return myCity;
    }
    public void setMyCity(String city) {
        this.myCity = city;
    }
    public String getCountry() {
        return location;
    }
    public void setCountry(String location) {
        this.location = location;
    }

}
