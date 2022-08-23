package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class MoFa {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[ ] strings=scanner.nextLine().split(" ");
        int A=Integer.parseInt(strings[0]);
        int B=Integer.parseInt(strings[1]);
        if (A>B) {
            int tmp=A;
            A=B;
            B=tmp;
        }
        int[] dpA=new int[B+1];
        int[] dpB=new int[B+1];
        Arrays.fill(dpA,Integer.MAX_VALUE);
        Arrays.fill(dpB,Integer.MAX_VALUE);
        dpA[A]=0;
        dpB[B]=0;
        boolean flag=true;
        while (flag){
            flag=false;
            for (int i = 1; i < dpA.length; i++) {
                int min=getMin(dpA,i);
                if (min!=Integer.MAX_VALUE) {
                    dpA[i] = min + 1;
                    flag=true;
                }
            }
        }
        flag=true;
        while (flag){
            flag=false;
            for (int i = 1; i < dpB.length; i++) {
                int min=getMin(dpB,i);
                if (min!=Integer.MAX_VALUE) {
                    dpB[i] = min + 1;
                    flag=true;
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < dpA.length; i++) {
           if (dpA[i]+dpB[i]<res)res=dpA[i]+dpB[i];
        }
        System.out.println(res);
    }
    public static int getMin(int[] dp,int i){
        int res=Integer.MAX_VALUE;
        if (i%2==0){
            if (dp[i/2]<res) res=dp[i/2];
            if (i-1>=1&&dp[i-1]<res) res=dp[i-1];
            if (2*i<dp.length&&dp[2*i]<res) res=dp[2*i];
            if (2*i+1<dp.length&&dp[2*i+1]<res) res=dp[2*i+1];
        }else {
            if (i-1>=1&&dp[i-1]<res) res=dp[i-1];
            if (2*i<dp.length&&dp[2*i]<res) res=dp[2*i];
            if (2*i+1<dp.length&&dp[2*i+1]<res) res=dp[2*i+1];
        }
        return res;
    }
}
