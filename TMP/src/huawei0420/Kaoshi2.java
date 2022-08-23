package huawei0420;

import java.util.ArrayList;
import java.util.Scanner;

public class Kaoshi2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int score= Integer.parseInt(scanner.nextLine());
        if (score<14){
            System.out.println(getJie((score)/2+2,2));
        }

//        System.out.println(res);
    }
    public static int getJie(int x,int y){
        long fm=1;
        long fz=1;
        int z=1;
        for (int j = x; j >=x-y+1 ; j--) {
            fm*=j;
            fz*=(z++);
        }
        return (int) (fm/fz);
    }
}
