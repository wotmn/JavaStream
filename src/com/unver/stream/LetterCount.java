package com.unver.stream;

import java.util.Arrays;

public class LetterCount {

    public static void main(String[] args) {
        getTotalNumberOfLettersOfNamesLongerThanFive("A", "b", "c");
    }

    //Array elemanlarını al => stream()
    //5ten uzun isimleri filtrele => filter()
    //Geri kalan listedeki tüm harflerin sayisini getir => mapToInt()
    //harf sayilarini topla => sum()
    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Arrays.stream(names).filter(name -> name.length() > 5).mapToInt(String::length).sum();
    }

}
