public class DictionaryTree {
    private DictionaryNode root;

    public DictionaryTree() {
        root = new DictionaryNode();
    }

    public void insert(String s) {
        DictionaryNode node = root;
        for (int i = 0; i < s.length(); i++) {
            DictionaryNode nextNode = root.getNext()[s.charAt(i)];
            if (nextNode == null) {
                nextNode = new DictionaryNode();
            }
            node = nextNode;
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
