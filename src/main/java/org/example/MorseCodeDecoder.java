package org.example;

public class MorseCodeDecoder {


    private static final String WORD_DELIMITER = "   ";
    private static final String LETTER_DELIMITER = " ";

    private final MorseCodeDictionary dictionary;

    public MorseCodeDecoder(MorseCodeDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String decode(String morseCode) {
        // morseCode = "... --- ...   ... --- ..."

        // words = new String[]{"... --- ...", "... --- ..."}
        String[] words = morseCode.split(WORD_DELIMITER);

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            // letters = new String[]{"...", "---", "..."}
            String[] letters = word.split(LETTER_DELIMITER);
            for (String letter : letters) {
                sb.append(dictionary.getLetter(letter));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

//    public String decode(String morseCode) {
//        return Arrays.stream(morseCode.split(WORD_DELIMITER))
//                .map(this::parseWord)
//                .collect(Collectors.joining(" "));
//    }
//
//    private String parseWord(String word){
//        return Arrays.stream(word.split(LETTER_DELIMITER))
//                .map(dictionary::getLetter)
//                .collect(Collectors.joining());
//    }
}




