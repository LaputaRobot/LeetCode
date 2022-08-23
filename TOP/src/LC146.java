import java.util.*;

class hListNode{
    public hListNode pre;
    public int key;
    public int value;
    public hListNode next;
    public hListNode(){}
    public hListNode(int key,int value){
        this.key=key;
        this.value=value;
    }
    public hListNode(int value,hListNode next){this.value=value;this.next=next;}

    @Override
    public String toString() {
        return "{"+"key=" + key +
                "->" + next +
                '}';
    }
}
class LRUCache {
    hListNode head=new hListNode();
    hListNode tail;
    int len=0;
    int maxLen=0;
    HashMap<Integer,hListNode> map=new HashMap<>();

    public LRUCache(int capacity) {
        this.maxLen=capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            hListNode t=map.get(key);
            if (t.pre==head) return t.value;
            hListNode p=t.pre;
            hListNode n=t.next;
            p.next=n;
            if (t==tail) {
                tail = p;
            }else {
                n.pre=p;
            }
            t.next=head.next;
            t.pre=head;
            head.next=t;
            if (t.next!=null) {
                t.next.pre = t;
            }
            return t.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            hListNode t=map.get(key);
            hListNode p=t.pre;
            hListNode n=t.next;
            p.next=n;
            if (t==tail) {
                tail = p;
            }else {
                n.pre=p;}
        }
        else len++;
        hListNode node=new hListNode(key,value);
        if (len==1) tail=node;
        node.next=head.next;
        node.pre=head;
        head.next=node;
        if (node.next!=null) {
            node.next.pre = node;
        }
        map.put(key,node);
        if (len>maxLen){
            hListNode tailPre=tail.pre;
            tailPre.next=null;
            map.remove(tail.key);
            tail=tailPre;
            len--;
        }
    }
}


public class LC146 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(10);
        System.out.println(lRUCache.get(1));
        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println((lRUCache.get(1)));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(3));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }
}
