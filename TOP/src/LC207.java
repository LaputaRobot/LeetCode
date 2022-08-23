import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] degrees=new int[numCourses];
        Queue<Integer> queue=new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
            degrees[p[1]]+=1;
        }
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i]==0) {
                queue.add(i);
                numCourses--;
            }
        }
        while (!queue.isEmpty()){
            for (Integer dst : adj.get(queue.poll())) {
                degrees[dst]-=1;
                if (degrees[dst]==0) {
                    queue.add(dst);
                    numCourses--;
                }
            }
        }
        return numCourses==0;
    }
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] flags=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj,flags,i)) return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adj,int[] flags,int i){
        if (flags[i]==1)return false;
        if (flags[i]==-1) return true;
        for (int dst : adj.get(i)) {
            flags[i]=1;
            if (!dfs(adj,flags,dst)) return false;
        }
        flags[i]=-1;
        return true;
    }
    public static void main(String[] args) {
        int numCourses=4;
//        int[][] prerequisites={{0,1},{1,3},{2,3},{2,1}};
        int[][] prerequisites={{0,1},{1,0}};
        System.out.println(new LC207().canFinish1(numCourses,prerequisites));
    }
}
