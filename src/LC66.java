import java.util.Arrays;

public class LC66 {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int[] res;
        int i=len-1;
        while (i>=0){
            if (digits[i]+1>9) {
                digits[i]=0;
                i--;
            }
            else {
                digits[i] += 1;
                break;
            }
        }
        if (i==-1){
            res=new int[len+1];
            res[0]=1;
            for (int j = 0; j < len; j++) {
                res[j+1]=digits[j];
            }
        }
        else res=digits;
        return res;
    }
    public int[] plusOne1(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9剑指
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
    public static void main(String[] args) {
        int[] digits={9,9,9};
        System.out.println(Arrays.toString(new LC66().plusOne1(digits)));
    }
}
