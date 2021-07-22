import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class lc3 {
    public static int lengthOfLongestSubstring(String s) {
        int[] flag=new int[95];
        ArrayDeque<Character> queue=new ArrayDeque<>();
        int result=0;
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
            if (flag[s.charAt(i)-' ']!=1){
                flag[s.charAt(i)-' ']=1;
            }else {
                char c;
                do {
                    c= queue.poll().charValue();
                    flag[c-' ']=0;
                }while (c!=s.charAt(i));
                flag[s.charAt(i)-' ']=1;
            }
            if (queue.size()>result) result=queue.size();
        }
        return  result;
    }
public static int lengthOfLongestSubstring1(String s) {
        HashMap hashMap=new HashMap();
        int result=0;
        int left=0,right=0;
        while (right<=s.length()-1){
            if (hashMap.containsKey(s.charAt(right))&&(int)hashMap.get(s.charAt(right))+1>left){
                left= (int) hashMap.get(s.charAt(right))+1;
            }
            if (right-left+1>result) result=right-left+1;
            hashMap.put(s.charAt(right),right);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));

    }
}
