package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public void  sort(int[] nums){
        helper(nums,0,nums.length-1);
    }
    public void helper(int[] nums,int left,int right){
        if (left>=right) return;
        int i=left+1;
        int j=right;
        while (i<j){
            while (j>=0&&nums[j]>=nums[left]) j--;
            while (i<nums.length&&nums[i]<nums[left]) i++;
            if (i>=j) break;
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        i--;
        int tmp=nums[i];
        nums[i]=nums[left];
        nums[left]=tmp;
        helper(nums,left,i);
        helper(nums,i+1,right);
    }
    @Test
    public void test(){
        QuickSort quickSort=new QuickSort();
        Random random=new Random(1);
        for (int i = 0; i < 100000; i++) {
            int len=random.nextInt(100);
            int[] nums=new int[len];
            for (int j = 0; j < len; j++) {
                nums[j]=random.nextInt(1000);
            }
//            quickSort.sort(nums);
            Arrays.sort(nums);
        }


    }
}
