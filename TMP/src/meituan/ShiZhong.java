package meituan;


import java.util.Scanner;

public class ShiZhong {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String str2=scanner.nextLine();
//        int  res=0;
        int h1=Integer.parseInt(str1.split(" ")[0]);
        int m1=Integer.parseInt(str1.split(" ")[1]);
        int h2=Integer.parseInt(str2.split(" ")[0]);
        int m2=Integer.parseInt(str2.split(" ")[1]);
        System.out.println((h2-h1)*60+m2-m1);
    }
}
