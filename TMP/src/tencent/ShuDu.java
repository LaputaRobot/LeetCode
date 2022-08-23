package tencent;

import java.util.Arrays;
import java.util.Scanner;

public class ShuDu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= Integer.parseInt(scanner.nextLine());
        String line1=scanner.nextLine();
        int[] nums=new int[line1.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Integer.parseInt(""+line1.charAt(i));
        }
        for (int i = 1; i < n; i++) {
            String line =scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                nums[j]=nums[j]*10+Integer.parseInt(""+line.charAt(j));
            }

        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i!= nums.length-1)
                System.out.print(""+nums[i]+" ");
            else System.out.println(""+nums[i]);
        }
    }
}
