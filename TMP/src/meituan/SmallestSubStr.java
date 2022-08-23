package meituan;

import java.util.HashMap;
import java.util.Scanner;

public class SmallestSubStr {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String str2=scanner.nextLine();
        if (str2.equals("")){
            System.out.println(str1);
            return;
        }
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch=str1.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch=str2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if (!map1.containsKey(ch)||map2.get(ch)>map1.get(ch)){
                System.out.println("");
                return;
            }
        }
        int left=0,right=str1.length()-1;
        while (left<right){
            char ch1=str1.charAt(left);
            while (!map2.containsKey(ch1)){
                left++;
                ch1=str1.charAt(left);
            }
            char ch2=str1.charAt(right);
            while (!map2.containsKey(ch2)){
                right--;
                ch2=str1.charAt(right);
            }
            boolean f=false;
            if (map1.get(ch1)>map2.get(ch1)){
                left++;
                f=true;
                map1.put(ch1,map1.get(ch1)-1);
            }
            if (map1.get(ch2)>map2.get(ch2)){
                right--;
                f=true;
                map1.put(ch2,map1.get(ch2)-1);
            }
            if (!f)break;
        }
        System.out.println(getMinString(str1,str2));
//        System.out.println(str1.substring(left,right+1));
    }

    static boolean isEq(int[] cnt1, int[] cnt2) {
        for(int i=0; i < 128; i++)
            if(cnt2[i] != 0 && cnt2[i] > cnt1[i])
                return false;
        return true;
    }
    public static String getMinString(String s, String t) {
        if(t.equals("")) return s;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int n = s1.length, m = t1.length;
        int[] cnt1 = new int[128];
        int[] cnt2 = new int[128];
        for(int i=0; i < m; i++) cnt2[t1[i]] ++;
        String res = "";
        for(int i=0, j=0; j < n; j++) {
            cnt1[s1[j]]++;
            while(i <= j && isEq(cnt1, cnt2)) {
                if((res.equals("") || res.length() > j-i+1))
                    res = s.substring(i, j+1);
                cnt1[s1[i++]]--;
            }
        }
        return res;
    }

}
