import java.util.*;

public class LC210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        int[] degrees = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
            degrees[p[1]] += 1;
        }
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
                numCourses--;
                res[numCourses] = i;
            }
        }
        while (!queue.isEmpty()) {
            for (Integer dst : adj.get(queue.poll())) {
                degrees[dst] -= 1;
                if (degrees[dst] == 0) {
                    queue.add(dst);
                    numCourses--;
                    res[numCourses] = dst;
                }
            }
        }
        return numCourses == 0 ? res : new int[]{};
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{0, 1}, {1, 3}, {2, 3}, {2, 1}};
//        int[][] prerequisites={{0,1},{1,0}};
        System.out.println(Arrays.toString(new LC210().findOrder(numCourses, prerequisites)));
    }
}
