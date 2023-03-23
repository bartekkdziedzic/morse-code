package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MorseCodeEncoder {


    private final static String LETTER_DELIMITER = " ";
    private final static String WORD_DELIMITER = "  ";

    private final MorseCodeDictionary dictionary;

    public MorseCodeEncoder(MorseCodeDictionary dictionary){
        this.dictionary = dictionary;
    }

//    public String encode(String text) {
//        text = text.toUpperCase();
//
////      "SIEMANKO SDA"
////      new String[]{"SIEMANKO", "SDA"}
//        String[] words = text.split("\\s+");
//
//        StringBuilder sb = new StringBuilder();
//        for (String word : words) {
//            //      new String[]{"S","D","A"}
//            String[] letters = word.split("");
//
//            for (String letter : letters) {
//                String code = dictionary.getCode(letter);
//                sb.append(code).append(LETTER_DELIMITER);
//            }
//            sb.append(WORD_DELIMITER);
//        }
//
//        return sb.toString().trim();
//    }


    public String encode(String text) {
        return Arrays.stream(text.toUpperCase().split("\\s+"))
                .map(w -> w.split(""))
                .map(this::createWord)
                .collect(Collectors.joining("   "));
    }

    private String createWord(String[] letters) {
        return Arrays.stream(letters)
                .map(dictionary::getCode)
                .collect(Collectors.joining(LETTER_DELIMITER));
    }
}

