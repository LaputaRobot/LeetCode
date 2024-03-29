class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}

public class LC116 {
    public static Node connect(Node root) {
        if (root==null||root.right==null||root.left==null) return root;
        root.left.next=root.right;
        if (root.next!=null) root.right.next=root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2,new Node(4),new Node(5),null);
        root.right=new Node(3,new Node(6),new Node(7),null);
        root=connect(root);
        System.out.println(root);
    }
}
