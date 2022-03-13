package com.gmail.elena.fileManage;
import com.gmail.elena.searchItem.Item;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileManager {

    private static final String SEARCH_RESULT_TXT = "SearchResult.txt";
    private static final String SAVED_INFO = "forSearching.txt";
    //    private static final Logger logger = LogManager.getLogger(FileManager.class);
    public static Date date;
    public static ArrayList<String> savedData = new ArrayList<>();

    public static String getData() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        date = new Date(System.currentTimeMillis());
        return formatter.format(date);

    }

    public static void addLineToSearchResultFile(Item myItem) {
        File file = new File(SEARCH_RESULT_TXT);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fileWriter = new FileWriter(SEARCH_RESULT_TXT, true);

            fileWriter.append("Today is ").append(getData()).append(".  There are ").append(myItem.getAmount()).append(" unit ").append(" of ").append("produce number ").append(myItem.getProduct()).append(" in the IKEA of ").append(myItem.getMyCity()).append(". The item's price is ").append(myItem.getPrice()).append("\n");
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println("Today is " + getData() + ".  There are " + myItem.getAmount() + " unit " + " of " + "produce number " + myItem.getProduct() + " in the IKEA of " + myItem.getMyCity() + ". The item's price is " + myItem.getPrice() +
                "\n");
    }

    public static void readFromFile(Item myItem) throws IOException {
        FileReader fr = new FileReader(SAVED_INFO);
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            savedData.add(scan.nextLine());
        }
        fr.close();
        myItem.setCountry(savedData.get(0));
        myItem.setMyCity(savedData.get(1));
        myItem.setProduct(savedData.get(2));
    }
}
