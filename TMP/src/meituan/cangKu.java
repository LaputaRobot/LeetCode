package meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class cangKu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] weights=new int[len];
        int[] gets=new int[len];
        for(int i=0;i<len;i++){
            weights[i]=sc.nextInt();
        }
        for(int i=0;i<len;i++){
            gets[i]=sc.nextInt();
        }
        boolean[] flags=new boolean[len];
        UnionFind unionFind=new UnionFind(len,weights);
        for (int i = len-1; i >=0 ; i--) {
            flags[gets[i]-1]=true;
            if (weights[gets[i]-1]>unionFind.max)
                unionFind.max=weights[gets[i]-1];
                unionFind.res[i]=unionFind.max;
            if (gets[i] - 2>=0&&flags[gets[i] - 2]){
                unionFind.union(gets[i]-2,gets[i]-1,i);
            }
            if (gets[i]<len&&flags[gets[i]]){
                unionFind.union(gets[i]-1,gets[i],i);
            }
        }
        for (int i = 1; i < len; i++) {
            System.out.println(unionFind.res[i]);
        }
        System.out.println(0);
    }
    static class UnionFind {
        public int[] sizes;
        public int[] parent;
        public int[] res;
        int max=0;

        public UnionFind(int n,int[] weights) {
            this.sizes=new int[n];
            this.parent = new int[n];
            this.res = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                sizes[i] = weights[i] ;
            }
        }

        public int find(int x) {
            while(x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y,int index) {
            int yP=find(y);
            parent[x]=yP;
            sizes[yP]+=sizes[x];
            if (sizes[yP]>max)
                max=sizes[yP];
            res[index]=max;
        }
    }
}

