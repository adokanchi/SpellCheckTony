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
        DictionaryTree start = new DictionaryTree("");
        DictionaryTree branch = start;
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                int subBranchIndex = branch.indexOfWord(word.substring(0,i+1));
                if (subBranchIndex != -1) {
                    branch = branch.getSubBranches().get(subBranchIndex);
                }
            }
            branch.getSubBranches().add(new DictionaryTree(word));
        }

        ArrayList<String> wrong = new ArrayList<String>();
        for (String word : text) {
            if (!inDict(word, start)) {
                wrong.add(word);
            }
        }
        String[] wrongArr = new String[wrong.size()];
        return wrong.toArray(wrongArr);
    }

    public boolean inDict(String word, DictionaryTree start) {
        DictionaryTree branch = start;
        for (int i = 0; i < word.length(); i++) {
            int subBranchIndex = branch.indexOfWord(word.substring(0,i+1));
            if (subBranchIndex != -1) {
                branch = branch.getSubBranches().get(subBranchIndex);
            }
        }
        return word.equals(branch.getWord());

    }
}