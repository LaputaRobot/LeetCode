import java.util.ArrayList;
import java.util.List;

public class LC763 {
    public static void main(String[] args) {
        System.out.println(new LC763().partitionLabels("ababcbacadefegdehijhklij"));
    }
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        for (int i = s.length()-1; i >= 0; i--) {
            if (last[s.charAt(i)-'a']==0)
                last[s.charAt(i)-'a']=i;
        }
        List<Integer> res=new ArrayList<>();
        int left=0,right=last[s.charAt(0)-'a'];
        for (int i = 1; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (i>right){
                res.add(right-left+1);
                left=i;
                right=last[ch-'a'];
            }else {
                right=Math.max(last[ch-'a'],right);
            }
            if (right==s.length()-1){
                res.add(right-left+1);
                break;
            }
        }
        return res;
    }
}
