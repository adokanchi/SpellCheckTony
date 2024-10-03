public class TSTNode {
    private TSTNode[] next;
    private boolean isWord;
    private char value;
    private final char EMPTY = '~';

    public TSTNode() {
        next = new TSTNode[3];
        isWord = false;
        value = EMPTY;
    }

    public TSTNode(char value) {
        next = new TSTNode[3];
        isWord = false;
        this.value = value;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord() {
        isWord = true;
    }

    public TSTNode[] getNext() {
        return next;
    }

    public TSTNode getNext(int i) {
        return next[i];
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
