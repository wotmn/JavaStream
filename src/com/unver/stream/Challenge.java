package com.unver.stream;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class Challenge {
    public static void main(String[] args) {
        System.out.println(Challenge.getString(asList(3,44))); // isEqualTo("o3,e44");
        System.out.println(Challenge.getString(singletonList(3))); // isEqualTo("o3");
    }

    public static String getString(List<Integer> list) {

        return list.stream()
                .map(i -> {
                    String s = "";
                    if (i % 2 == 0){
                        s += "e" + i;
                    } else{
                        s += "o" + i;
                    }
                    return s;
                })
                .collect(Collectors.joining(","));
    }

}
