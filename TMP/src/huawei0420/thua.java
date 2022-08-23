package huawei0420;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class thua {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] line1=scanner.nextLine().split(",");
        int[] tree1=new int[line1.length];
        for (int i = 0; i < tree1.length; i++) {
            if (i==0)
                tree1[i]=Integer.parseInt(line1[i].substring(1));
            else if(i==tree1.length-1)
                tree1[i]=Integer.parseInt(line1[i].substring(0,line1[i].length()-1));
            else
                tree1[i]=Integer.parseInt(line1[i]);
        }
        String[] line2= scanner.nextLine().split("/");
//        int pathLen=0;
//        for (int i = 0; i < line2.length; i++) {
//            if (!line2[i].equals(""))
//                pathLen++;
//        }
        int[] path=new int[line2.length-1];
        for (int i = 1; i < line2.length; i++) {
            if (!line2[i].equals(""))
            path[i-1]=Integer.parseInt(line2[i]);
        }

        String[] line3=scanner.nextLine().split(",");
        int[] tree2=new int[line3.length];
        for (int i = 0; i < tree2.length; i++) {
            if (i==0)
                tree2[i]=Integer.parseInt(line3[i].substring(1));
            else if(i==tree2.length-1)
                tree2[i]=Integer.parseInt(line3[i].substring(0,line3[i].length()-1));
            else
                tree2[i]=Integer.parseInt(line3[i]);
        }
        if (path.length==1){
            System.out.println(Arrays.toString(tree1));
            return;
        }
        int p=0;
        for (int i = 1; i < path.length; i++) {
            p=2*p+1;
            if (path[i]!=tree1[p])p++;
        }
        int pL=getLevel(p);
        int resLen=getLevel(tree2.length)+pL-1;
        int[] resArr=new int[(int) (Math.pow(2,resLen)-1)];
        System.arraycopy(tree1,0,resArr,0,tree1.length);
//        System.out.println(p);
        int p2=0;
        int len=1;
        while (p2<tree2.length){
            if (len >= 0) System.arraycopy(tree2, p2, resArr, p, len);
            p2=2*p2+1;
            p=2*p+1;
            len*=2;
        }
        System.out.print("[");
        System.out.print(resArr[0]);
        int range=(int) Math.pow(2,resLen-1);
        for (int i = 1; i < resArr.length; i++) {
            if (i>=resArr.length-range&&resArr[i]==0)continue;
            System.out.print(", "+resArr[i]);
        }
        System.out.println("]");

    }
    public static int getLevel(int len){
        int sum=0;
        int x=1;
        int res=0;
        while (sum<len){
            sum+=x;
            res++;
            x*=2;
        }
        return res;
    }

//    public static int getChIndex(int p,int level){
//
//    }
}
