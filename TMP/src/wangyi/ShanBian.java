package wangyi;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShanBian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int[] values = new int[n + 1];
        strings = scanner.nextLine().split(" ");
        for (int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(strings[i - 1]);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        HashSet<Integer> set = new HashSet<>();
        long weiSum = 0;
        for (int i = 0; i < m; i++) {
            strings = scanner.nextLine().split(" ");
            int s = Integer.parseInt(strings[0]);
            int d = Integer.parseInt(strings[1]);
            int w = getWei(values[s], values[d]);
            weiSum = weiSum + w;
            queue.add(new int[]{w, s, d});
        }
        long weiSum1 = 0;
        while (queue.size() > 0) {
            int[] edges = queue.poll();
            if (!set.contains(edges[1]) || !set.contains(edges[2])) {
                weiSum1 = weiSum1 + edges[0];
                set.add(edges[1]);
                set.add(edges[2]);
            }
        }
        System.out.println(weiSum - weiSum1);
    }

    public static int getWei(int x, int y) {
        long tmp = (long) x * y;
        String str = "" + tmp;
        int res = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') res++;
            else break;
        }
        return res;
    }
}
