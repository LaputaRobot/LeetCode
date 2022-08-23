package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Jitizhao {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine().trim();
        String[] numsStr;
        if (str.equals("")||(numsStr=str.split(",")).length<1) System.out.println(0);
        else {
            if (numsStr.length == 0) System.out.println(0);
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            int[] tmp = Arrays.copyOfRange(nums, 0, nums.length);
//        System.out.println(Arrays.toString(tmp));
            Arrays.sort(tmp);
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != tmp[i])
                    res++;
            }
            System.out.println(res);
        }
    }
}
