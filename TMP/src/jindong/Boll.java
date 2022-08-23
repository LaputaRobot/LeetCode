package jindong;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Boll {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T =Integer.parseInt(scanner.nextLine());
        int[] ress=new int[T];
        for (int i = 0; i < T; i++) {
            int res=0;
            int n=Integer.parseInt(scanner.nextLine());
            int[] nums1=new int[n];
            String[] strings=scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                nums1[j]=Integer.parseInt(strings[j]);
            }
            int m=Integer.parseInt(scanner.nextLine());
            int[] nums2=new int[m];
            strings=scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                nums2[j] = Integer.parseInt(strings[j]);
            }
            TreeSet<Integer> set=new TreeSet<>();
            for (int len = 0; len < n; len++) {
                for (int j = 0; j < 1; j++) {

                }
            }
            res=n;
            ress[i]=res;
        }
        for (int i = 0; i < T; i++) {
            System.out.println(ress[i]);
        }
    }
}
