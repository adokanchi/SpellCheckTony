import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Tony Dokanchi
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */

    public String[] checkWords(String[] text, String[] dictionary) {

        int maxLength = 0;
        String longest = "";
        for (String word : dictionary) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longest = word;
            }
        }
        System.out.println(maxLength);
        System.out.println(longest);
        return null;
        /*
        ArrayList<String> wrongWords = new ArrayList<String>();
        for (String word : text) {
            if (!inDict(word, dictionary)) {
                wrongWords.add(word);
            }
        }

        String[] wrongWordsArr = new String[wrongWords.size()];
        int i = 0;
        while (!wrongWords.isEmpty()) {
            wrongWordsArr[i] = wrongWords.remove(0);
            i++;
        }
        return wrongWordsArr;
        */
    }

    public boolean inDict(String word, String[] dictionary) {
        int startIndex = 0;
        int endIndex = dictionary.length;

        // Make dictionary lowercase
        for (int i = 0; i < word.length(); i++) {

            while (!word.substring(0,i).equals(dictionary[startIndex].substring(0,i))) {

            }
        }
        while (!word.equals(dictionary[startIndex])) {
            int middleIndex = (startIndex + endIndex) / 2;
            if (dictionary[middleIndex].charAt(0) > word.charAt(0)) {
                endIndex = middleIndex;
            }
            else {
                startIndex = middleIndex;
            }
        }


        return false;
    }
}
