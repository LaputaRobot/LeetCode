package meituan;

import java.util.Scanner;

public class HeiDong {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int res=0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' ')res++;
        }
        System.out.println(res);
    }
}
