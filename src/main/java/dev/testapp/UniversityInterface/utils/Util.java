package dev.testapp.UniversityInterface.utils;

public class Util {

    public static int wordNum(String[] words, String s){
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(s)) return i;

        }
        return -1;
    }
}
