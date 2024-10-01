import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
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
        DictionaryTree dict = new DictionaryTree();
        for (String s : dictionary) {
            dict.insert(s);
        }

        ArrayList<String> wrong = new ArrayList<String>();
        DictionaryTree wrongTree = new DictionaryTree();

        for (String word : text) {
            if (!dict.lookup(word) && !wrongTree.lookup(word)) {
                wrong.add(word);
                wrongTree.insert(word);
            }
        }

        String[] wrongArr = new String[wrong.size()];
        for (int i = 0; i < wrong.size(); i++) {
            wrongArr[i] = wrong.get(i);
        }
        return wrongArr;
    }
}