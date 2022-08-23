import java.util.Arrays;
import java.util.List;

public class LC75 {
    public void sortColors(int[] nums) {
        int p0=0,p1=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==2){
                continue;
            }
            else if (nums[i]==1){
                int temp=nums[i];
                nums[i]=nums[p1];
                nums[p1]=temp;
                p1++;
            }
            else {
                if (p0<p1){
                    int temp=nums[i];
                    nums[i]=nums[p0];
                    nums[p0]=temp;
                    temp=nums[i];
                    nums[i]=nums[p1];
                    nums[p1]=temp;
                    p0++;
                    p1++;
                }
                else {
                    int temp=nums[i];
                    nums[i]=nums[p0];
                    nums[p0]=temp;
                    p0++;
                    p1++;
                }
            }
        }
    }

    /***
     * 双指针
     * 2022-08-18
     * @param nums
     */
    public void sortColors0818(int[] nums) {
        int start1=-1;
        int start2=-1;
        for (int i = 0; i < nums.length; i++) {
            if (start1==-1&&nums[i]==1){
                start1=i;
            }
            if (start2==-1&&nums[i]==2){
                start2=i;
            }
            if (start1!=-1&&start2!=-1&&start1>start2){
                int tmp=nums[start1];
                nums[start1]=nums[start2];
                nums[start2]=tmp;
                start1=start2;
                start2++;
            }
            if (nums[i]==0){
                if (start1!=-1){
                    nums[start1]=0;
                    nums[i]=1;
                    start1++;
                }
                if (start2!=-1){
                    nums[start2]=nums[i];
                    nums[i]=2;
                    start2++;
                }
            }else if(nums[i]==1){
                if (start2!=-1){
                    nums[start2]=nums[i];
                    nums[i]=2;
                    start2++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={2,1,1,1,0};
//        new LC75().sortColors(nums);
        new LC75().sortColors0818(nums);
        System.out.println(Arrays.toString(nums));
    }
}
