package tencent;

import java.util.Scanner;

public class GongFang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int[] left=new int[n];
        int[] right=new int[n];
        String str=scanner.nextLine();
        int gong=0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i)=='0')gong+=(i+1);
            left[i]=gong;
        }
        int fang=0;
        for (int i = n-1; i >=0; i--) {
            if (str.charAt(i)=='1')fang+=(i+1);
            right[i]=fang;
        }
        int res=right[0];
        for (int i = 0; i < n-1; i++) {
            int tmp=Math.abs(left[i]-right[i+1]);
            if (tmp<res)
                res=tmp;
        }
        if (left[n-1]<res)res=left[n-1];
        System.out.println(res);
    }
}
