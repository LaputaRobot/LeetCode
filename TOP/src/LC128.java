import java.util.HashSet;
import java.util.Set;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int res=0;
        for (int num :nums ) {
            if (!hashSet.contains(num-1)) {
                int tmp=1;
                int tmpNum=num;
                while (hashSet.contains(tmpNum+1)) {
                    tmp++;
                    tmpNum++;
                }
                res=Math.max(tmp,res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC128().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
