package com.unver.optional;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class PhoneBookCrawler {

    private PhoneBook phoneBook;

    public PhoneBookCrawler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name){
        return phoneBook.findPhoneNumberByName(name).orElseThrow(() -> new IllegalArgumentException());
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
        StringBuilder result = new StringBuilder();
        phoneBook.findPhoneNumberByName(name).
                ifPresentOrElse(phoneNumber -> result.append(phoneNumber), //java11
                        () -> System.out.println(phoneBook.getPhoneBookEntries()));

        return result.toString();
    }

    //JAVA 11
    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber){

        Optional<String> phoneNumberOptional = phoneBook.findPhoneNumberByName(name);
        Optional<String> nameOptional = phoneBook.findNameByPhoneNumber(phoneNumber);

        if (phoneNumberOptional.isPresent()){
            return phoneNumberOptional.get();
        }else if (nameOptional.isPresent()){
            return nameOptional.get();
        }

        return phoneBook.findPhoneNumberByName(name)
                .or(() -> phoneBook.findNameByPhoneNumber(phoneNumber))
                .orElse(phoneBook.findPhoneNumberByName("Jos de Vos").orElse(null));
    }
    public String findPhoneNumberByNameOrNameByPhoneNumber2(String name, String phoneNumber){

        Optional<String> phoneNumberOptional = phoneBook.findPhoneNumberByName(name);
        Optional<String> nameOptional = phoneBook.findNameByPhoneNumber(phoneNumber);

        if (phoneNumberOptional.isPresent()){
            return phoneNumberOptional.get();
        }else if (nameOptional.isPresent()){
            return nameOptional.get();
        }

        return phoneBook.findPhoneNumberByName(name)
                .orElse(phoneBook.findNameByPhoneNumber(phoneNumber)
                        .orElse(phoneBook.findPhoneNumberByName("Jos de Vos").orElse(null)));
    }

    public PhoneBook getPhoneBook(){
        return phoneBook;
    }

}