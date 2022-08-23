import java.util.ArrayList;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(){}

    @Override
    public String toString() {

        return "->" +
                "val=" + val +
                ", next=" + next +
                ", random=" + (random==null?"null":random.val) +
                '}';
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        ArrayList<Node> l1=new ArrayList<>();
        ArrayList<Node> l2=new ArrayList<>();
        while (head!=null){
            l1.add(head);
            l2.add(new Node(head.val));
            head=head.next;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (i<l1.size()-1)l2.get(i).next=l2.get(i+1);
            if (l1.get(i).random==null) continue;
            int index=l1.indexOf(l1.get(i).random);
            l2.get(i).random = l2.get(index);
        }
        return l2.get(0);
    }
    
}

public class Offer35 {
    public static void main(String[] args) {
        ArrayList<Node> help=new ArrayList<Node>();
        Node node1=new Node(7);
        Node node2=new Node(13);
        Node node3=new Node(11);
        Node node4=new Node(10);
        Node node5=new Node(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node2.random=node1;
        node3.random=node5;
        node4.random=node3;
        node5.random=node1;
        System.out.println(new Solution().copyRandomList(node1));
        System.out.println(node1);
    }
}
