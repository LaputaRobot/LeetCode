package wangyi;

import java.util.Scanner;

public class ShuZU {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] s=scanner.nextLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[1]);
        int x=Integer.parseInt(s[2]);
        if (n>k) System.out.println(-1);
        if (x>k*(1+k)/2) System.out.println(-1);
    }
}
