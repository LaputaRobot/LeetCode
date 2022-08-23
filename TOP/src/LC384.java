import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class LC384 {
    class Solution {
        int[] source;
        int[] res;
        Random random=new Random();
        public Solution(int[] nums) {
            source=nums;
            res=new int[nums.length];
            System.arraycopy(source, 0, res, 0, source.length);
        }

        public int[] reset() {
            return source;
        }

        public int[] shuffle() {
            for (int i = res.length-1; i >0; i--) {
                int index=random.nextInt(i+1);
                int tmp=res[i];
                res[i]=res[index];
                res[index]=tmp;
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
