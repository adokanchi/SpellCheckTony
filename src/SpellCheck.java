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
        return checkWordsTST(text, dictionary);
    }

    public String[] checkWordsTST(String[] text, String[] dictionary) {
        // Create dict
        TSTTree dict = new TSTTree();
        insert(dictionary, dict, dictionary.length / 2, 1);
        for (String s : dictionary) {
            dict.insert(s);
        }

        // Find non-duplicate wrong words
        ArrayList<String> wrong = new ArrayList<String>();
        TSTTree wrongTree = new TSTTree();
        TSTTree rightTree = new TSTTree();

        for (String word : text) {
            // If we have seen this word before
            if (rightTree.lookup(word) || wrongTree.lookup(word)) {
                continue;
            }
            if (dict.lookup(word)) {
                rightTree.insert(word);
            }
            else {
                wrongTree.insert(word);
                wrong.add(word);
            }
        }

        // Return
        return wrong.toArray(new String[wrong.size()]);
    }

    // Recursive method that adds words from String[] dictionary to TSTTree dict in a binary search-like manner.
    // Helps ensure dict has all paths of roughly equal length, speeding up lookups.
    // Starts by taking index = length / 2 and count = 1
    public void insert(String[] dictionary, TSTTree dict, int index, int count) {
        if (count > Math.log(dictionary.length)) {
            return;
        }

        dict.insert(dictionary[index]);

        int offset = (int) (dictionary.length / Math.pow(2, count + 1));
        insert(dictionary, dict, index - offset, count + 1);
        insert(dictionary, dict, index + offset, count + 1);
    }

    public String[] checkWordsTrie(String[] text, String[] dictionary) {
        DictionaryTree dict = new DictionaryTree();
        for (String s : dictionary) {
            dict.insert(s);
        }

        ArrayList<String> wrong = new ArrayList<String>();
        DictionaryTree wrongTree = new DictionaryTree();
        DictionaryTree rightTree = new DictionaryTree();

        for (String word : text) {
            if (wrongTree.lookup(word) || rightTree.lookup(word)) {
                continue;
            }
            if (dict.lookup(word)) {
                rightTree.insert(word);
            }
            else {
                wrong.add(word);
                wrongTree.insert(word);
            }
        }

        return wrong.toArray(new String[wrong.size()]);
    }
}