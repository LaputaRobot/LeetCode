package huawei;

import java.util.Scanner;
import java.util.TreeMap;

public class WordsF {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N;
        int M;
        TreeMap<String,Integer> map=new TreeMap<>();
        TreeMap<String,Integer> tMap=new TreeMap<>();
        String[] nums=sc.nextLine().split(" ");
        N=Integer.parseInt(nums[0]);
        M=Integer.parseInt(nums[1]);
        String[][] titles=new String[M][];
        String[][] contents=new String[M][];
        for(int i=0;i<M;i++){
            titles[i]=sc.nextLine().split(" ");
            contents[i]=sc.nextLine().split(" ");
        }
        for(String[] t:titles){
            for(String word:t){
                tMap.put(word,tMap.getOrDefault(word,0)+3);
                map.put(word,map.getOrDefault(word,0)+3);
            }
        }
        for(String[] c:contents){
            for(String word:c){
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }
        System.out.println();
        System.out.println(map);
    }
}
