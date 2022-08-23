package tencent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class HeBing {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a ListNode类一维数组 指向每段碎片的开头
     * @return ListNode类
     */
    public ListNode solve(ListNode[] a) {
        // write code here
        ListNode merged = a[0];
        HashSet<Integer> unmerged = new HashSet<>();
        for (int i = 1; i < a.length; i++) {
            ListNode tmp = merge1(a[i], merged);
            if (tmp == null) {
                unmerged.add(i);
            } else
                merged = tmp;
        }
        while (!unmerged.isEmpty()) {
            for (int i : unmerged) {
                ListNode tmp = merge1(a[i], merged);
                if (tmp != null) {
                    merged = tmp;
                    unmerged.remove(i);
                }
            }
        }
        System.out.println(merged);
        ArrayList<ListNode> arrayList=new ArrayList<>();
        while (merged!=null){
            arrayList.add(merged);
            merged=merged.next;
        }
        int min=Integer.MAX_VALUE;
        int minIndex=0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).val<min){
                min=arrayList.get(i).val;
                minIndex=i;
            }
        }
        int n=arrayList.size();
        int left;
        if (minIndex==0){
            left=n-1;
        }
        else
            left=minIndex-1;
        int right=(minIndex+1)%n;
        int index=minIndex;
        ListNode res= arrayList.get(minIndex);
        if (arrayList.get(left).val>arrayList.get(right).val){
            index=minIndex==n-1?0:minIndex+1;
            while (arrayList.get(index).val!=arrayList.get(minIndex).val) {
                res.next = arrayList.get(index);
                res=res.next;
                index=index==n-1?0:index+1;
            }
            res.next=null;
        }
        else {
            index=minIndex==0?n-1:minIndex-1;
            while (arrayList.get(index).val!=arrayList.get(minIndex).val) {
                res.next = arrayList.get(index);
                res=res.next;
                index=index==0?n-1:index-1;
            }
            res.next=null;
        }
        return arrayList.get(minIndex);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode h1 = list1;
        ListNode h2 = list2;
        while (list1 != null) {
            if (h2.val == list1.val) {
                list1.next = h2.next;
                return h1;
            }
            list1 = list1.next;
        }
        while (list2 != null) {
            if (h1.val == list2.val) {
                list2.next = h1.next;
                return h2;
            }
            list2 = list2.next;
        }
        return null;
    }
    public ListNode merge1(ListNode l1,ListNode l2){
        LinkedHashSet<Integer> set=new LinkedHashSet<>();
        boolean f=false;
        while (l1!=null) {
            set.add(l1.val);
            l1=l1.next;
        }
        ListNode ll2=l2;
        while (ll2!=null){
            if(!set.add(ll2.val))
                f=true;
            ll2=ll2.next;
        }
        if (!f)return null;
        else {
            ListNode res=new ListNode(0);
            ListNode l=res;
            for (Integer i : set) {
                l.next=new ListNode(i);
                l=l.next;
            }
            return res.next;
        }
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{
                new ListNode(5, new ListNode(8, new ListNode(9))),
                new ListNode(7, new ListNode(4, new ListNode(11,new ListNode(1,new ListNode(10,new ListNode(3)))))),
                new ListNode(3,new ListNode(6,new ListNode(12,new ListNode(5,new ListNode(8)))))
            };
        System.out.println(new HeBing().solve(listNodes));
    }

}
