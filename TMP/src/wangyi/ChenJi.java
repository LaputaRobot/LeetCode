package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class ChenJi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= Integer.parseInt(scanner.nextLine());
        int[] nums=new int[n];
        String[] strings=scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(strings[i]);
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            int tmp=nums[i];
            res+=getWei(tmp);
            for (int j = i+1; j < n; j++) {
                tmp*=nums[j];
                res+=getWei(tmp);
            }
        }
        System.out.println(res);
    }
    public static int getWei(int x) {
        String str = "" + (long) x;
        int res = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') res++;
            else break;
        }
        return res;
    }
}
