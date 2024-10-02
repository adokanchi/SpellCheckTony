public class DictionaryNode {
    private DictionaryNode[] next;
    private boolean isWord;

    public DictionaryNode() {
        isWord = false;
        next = new DictionaryNode[256];
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord() {
        isWord = true;
    }

    public DictionaryNode[] getNext() {
        return next;
    }

    public DictionaryNode getNext(int i) {
        return next[i];
    }
}
