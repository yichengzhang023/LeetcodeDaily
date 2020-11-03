import java.util.Random;

/**
 * SkipList
 */
public class SkipList {

    private int size;
    private int height;

    private Node head;
    private Node tail;

    private Random random;

    /**
     * InnerSkipList
     */
    public class Node {
        private Integer key;
        private Integer value;
        private Node up;
        private Node down;
        private Node right;
        private Node left;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{key:");
            builder.append(key);
            builder.append("; value: ");
            builder.append(value);
            builder.append(" }");
            return builder.toString();
        }
    }

}