package com.example.aemacc13.integerbaseconverter;

/**
 * Created by aemacc13 on 9/7/2016.
 */
public class BaseConversion {
    public static int check(String num, String initialBase, String newBase){
        try {
            Integer number= Integer.parseInt(num);
        } catch (NumberFormatException integerException) {
            return 1;
        }
        try {
            Integer initial= Integer.parseInt(initialBase);
        } catch (NumberFormatException integerException) {
            return 2;
        }
        try {
            Integer newB= Integer.parseInt(newBase);
        } catch (NumberFormatException integerException) {
            return 3;
        }return 0;
    }

    public static String convert(String num, String initialBase, String newBase){
        Integer initial= Integer.parseInt(initialBase);
        Integer newB= Integer.parseInt(newBase);
        return Integer.toString(Integer.parseInt(num,initial), newB);
    }

}
