public class DictionaryTree {
    private DictionaryNode root;

    public DictionaryTree() {
        root = new DictionaryNode();
    }

    public void insert(String s) {
        DictionaryNode node = root;
        for (int i = 0; i < s.length(); i++) {
            if (node.getNext()[s.charAt(i)] == null) {
                node.getNext()[s.charAt(i)] = new DictionaryNode();
            }
            node = node.getNext(s.charAt(i));
        }
        node.setWord();
    }

    public boolean lookup(String s) {
        DictionaryNode node = root;
        for (int i = 0; i < s.length(); i++) {
            node = node.getNext()[s.charAt(i)];
            if (node == null) {
                return false;
            }
        }
        return node.isWord();
    }
}
