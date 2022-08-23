import java.util.Stack;

public class lc42 {
    public int trap(int[] height) {
        //接雨水
        int res=0;
        int left=0;
        int max=0;
        for (int i = 0; i < height.length; i++) {
            if (height[i]>=max){
                while (left<i){
                    if (height[left]<max){
                        res+=(max-height[left]);
                    }
                    left++;
                }
                max=height[i];
            }
        }
        if (left == height.length-1)return res;
        int right=height.length-1;
        max=0;
        for (int i = height.length-1; i >=left ; i--) {
            if (height[i]>=max){
                while (right>i){
                    if (height[right]<max){
                        res+=(max-height[right]);
                    }
                    right--;
                }
                max=height[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new lc42().trap(new int[]{4,2,3}));
    }
}
