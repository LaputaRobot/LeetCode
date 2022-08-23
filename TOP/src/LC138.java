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
    @Override
    public String toString() {

        return "->" +
                "{val=" + val +
                ", next=" + next +
                ", random=" + (random==null?"null":random.val) +
                '}';
    }
}

public class LC138 {
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node H=head;
        while (head!=null){
            Node newNode=new Node(head.val);
            newNode.next=head.next;
            head.next=newNode;
            head=head.next.next;
        }
        Node nH=H.next;
        Node head1=H;
        Node head2=nH;
        while (true){
            if (head1.random!=null)
                head2.random=head1.random.next;
            head1=head2.next;
            if (head1==null) break;
            head2=head1.next;
        }
        head1=H;
        head2=nH;
        while (true){
            head1.next=head2.next;
            head1=head1.next;
            if (head1==null) break;
            head2.next=head1.next;
            head2=head2.next;
        }
        return nH;
    }

    public static void main(String[] args) {
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
        System.out.println(new LC138().copyRandomList(node1));
        System.out.println(node1);
    }
}
