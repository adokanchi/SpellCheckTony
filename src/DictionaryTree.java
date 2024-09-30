import java.util.ArrayList;

public class DictionaryTree {
    private String word;
    private ArrayList<DictionaryTree> subBranches;

    public DictionaryTree(String word) {
        subBranches = new ArrayList<DictionaryTree>();
        this.word = word;
    }

    public ArrayList<DictionaryTree> getSubBranches() {
        return subBranches;
    }

    public String getWord() {
        return word;
    }

    public int indexOfWord(String word) {
        for (int i = 0; i < subBranches.size(); i++) {
            if (subBranches.get(i).getWord().equals(word)) {
                return i;
            }
        }
        return -1;
    }
}
