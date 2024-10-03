public class TSTTree {
    private final int LEFT = 0;
    private final int MIDDLE = 1;
    private final int RIGHT = 2;
    private final char EMPTY = '~';

    private final TSTNode root;

    public TSTTree() {
        root = new TSTNode('m');
    }

    public void insert(String s) {
        // If the tree is empty and this is the first word being added
        if (root.getValue() == EMPTY) {
            root.setValue(s.charAt(0));
        }

        TSTNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == node.getValue()) { // If we're at the correct node
                if (i == s.length() - 1) { // If this is the last letter, make it considered a word
                    node.setWord();
                    return;
                }
                // Accept the character by moving down
                if (node.getNext()[MIDDLE] == null) node.getNext()[MIDDLE] = new TSTNode(c);
                node = node.getNext()[MIDDLE];
            }
            else if (c < node.getValue()) { // If we need to move left
                // Move left
                if (node.getNext()[LEFT] == null) node.getNext()[LEFT] = new TSTNode(c);
                node = node.getNext()[LEFT];
                // Don't accept the character
                i--;
            }
            else { // If we need to move right
                // Move right
                if (node.getNext()[RIGHT] == null) node.getNext()[RIGHT] = new TSTNode(c);
                node = node.getNext()[RIGHT];
                // Don't accept the character
                i--;
            }
        }
    }

    public boolean lookup(String s) {
        // If the tree is empty and there are no valid words
        if (root.getValue() == EMPTY) {
            return false;
        }

        TSTNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == node.getValue()) {
                // Accept the character
                if (i == s.length() - 1) { // If this is the last letter, check if it's considered a word
                    return node.isWord();
                }
                // Move down
                if (node.getNext()[MIDDLE] == null) return false;
                node = node.getNext()[MIDDLE];
            }
            else if (c < node.getValue()) { // If we need to move left
                // Move left
                if (node.getNext()[LEFT] == null) return false;
                node = node.getNext()[LEFT];
                // Don't accept the character
                i--;
            }
            else { // If we need to move right
                // Move right
                if (node.getNext()[RIGHT] == null) return false;
                node = node.getNext()[RIGHT];
                // Don't accept the character
                i--;
            }
        }
        // Should never reach here
        return false;
    }
}
