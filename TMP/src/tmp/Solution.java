package tmp;

import java.util.HashMap;
import java.util.Scanner;
// import java.util.List;
import java.util.ArrayList;

public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int lineNum=Integer.parseInt(sc.nextLine());
        String[] names=new String[lineNum];
        for(int i=0;i<lineNum;i++){
            names[i]=sc.nextLine();
        }
        for(int i=0;i<lineNum;i++){
            if(!isCorrect(names[i]))
                System.out.println("Wrong");
            else
                System.out.println("Accept");
        }
    }
    private static boolean isCorrect(String str){
        if(str.length()==0)return false;
        char ch=str.charAt(0);
        if (!(ch>='A'&&ch<='Z'||ch>='a'&&ch<='z'))return false;
        int fNum=0;
        int cNum=1;
        for(int i=1;i<str.length();i++){
            ch=str.charAt(i);
            if(ch>='A'&&ch<='Z'||ch>='a'&&ch<='z')
                cNum++;
            else if(ch>='0'&&ch<='9')
                fNum++;
            else
                return false;

        }
        return fNum>1&&cNum>1;
    }
}