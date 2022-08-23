package huawei0420;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.ArrayList;
import java.util.Scanner;

public class KaoShi1 {
    static int pan=10;
    static int xuan=10;
    static int duo=5;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int score= Integer.parseInt(scanner.nextLine());
        ArrayList<int[]> cc=new ArrayList<>();
        for (int i = 0; i <= pan; i++) {
            for (int j = 0; j <= 10; j++) {
                for (int k = 0; k <= 5; k++) {
                    if (2*i+4*j+8*k==score)
                        cc.add(new int[]{i,j,k});
                }
            }
        }
        int[] max=new int[]{10,10,5};
        int res=0;
        for (int[] c : cc) {
            int tmp=0;
            for (int i = 0; i < c.length; i++) {
                long fm=1;
                long fz=1;
                int x=1;
                for (int j = max[i]; j >max[i]-c[i]+1 ; j--) {
                    fm*=j;
                    fz*=(x++);
                }
                tmp+=fm/fz;
            }
            res+=tmp;
        }
        System.out.println(res);
    }
}
