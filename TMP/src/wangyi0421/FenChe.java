package wangyi0421;

import java.util.Scanner;

public class FenChe {
    public static void main(String[] args) {
        Scanner  scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= 2*n-1; i++) {
            if (i==1){
                System.out.print("*");
                for (int j = 2; j <=2*n-1; j++) {
                    if (j>=n) System.out.print("*");
                    else System.out.print(" ");
                }
            }
            else if (i<n){
                System.out.print("*");
                for (int j = 2; j <= 2*n-1; j++) {
                    if (j==i||j==2*n-i||j==n){
                        System.out.print("*");
                    }
                    else System.out.print(" ");
                }
            }
            else if (i==n){
                for (int j = 0; j < 2*n-1; j++) {
                    System.out.print("*");
                }
            }
            else if(i<2*n-1){
                for (int j = 1; j < 2*n-1; j++) {
                    if (j==(n-i+n)||j==i||j==n){
                        System.out.print("*");
                    }
                    else System.out.print(" ");
                }
                System.out.print("*");
            }
            else {
                for (int j = 1; j <2*n-1; j++) {
                    if (j<=n) System.out.print("*");
                    else System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
