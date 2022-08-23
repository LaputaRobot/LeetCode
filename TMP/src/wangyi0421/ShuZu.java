package wangyi0421;

import java.util.Scanner;

public class ShuZu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] line1=scanner.nextLine().split(" ");
        int n=Integer.parseInt(line1[0]);
        int p=Integer.parseInt(line1[1]);
        int x=Integer.parseInt(line1[2]);
        int[] nums=new int[n];
        String[] line2=scanner.nextLine().split(" ");
        int sum=0;
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(line2[i]);
            sum+=nums[i];
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            int newSum=sum-nums[i];
            if (newSum+p<x) continue;
            int j=x-newSum%x;
            if (j<p) {
                res++;
                res += ((p - j) / x);
            }
            if (sum%x==0&&nums[i]>=1&&nums[i]<=p)res--;
        }
        System.out.println(res);
    }
}
