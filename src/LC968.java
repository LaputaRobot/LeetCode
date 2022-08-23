import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class LC968 {
    public static void main(String[] args) {
        System.out.println(new LC968().minCameraCover(TreeNode.getTree(new Object[]{0,0,null,0,null,0,null,null,0})));
    }
    public int minCameraCover(TreeNode root) {
        HashSet<TreeNode> marked=new HashSet<>();
        PriorityQueue<TreeNode> nodes=new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return getDegree(o2,root,marked)-getDegree(o1,root,marked);
            }
        });
        addQueue(root,nodes);
        int res=0;
        while (!nodes.isEmpty()){
            TreeNode node=nodes.poll();
            if (getDegree(node,root,marked)>0){
                res++;
                marked.add(node);
                if(node.left!=null)marked.add(node.left);
                if(node.right!=null)marked.add(node.right);
            }
        }
        return res;
    }
    public void addQueue(TreeNode root,PriorityQueue<TreeNode> nodes){
        if (root==null)return;
        nodes.add(root);
        addQueue(root.left,nodes);
        addQueue(root.right,nodes);

    }
    public int getDegree(TreeNode node, TreeNode root,HashSet<TreeNode> marked){
        int degree=0;
        if (node.left!=null&&!marked.contains(node.left))degree++;
        if (node.right!=null&&!marked.contains(node.right))degree++;
        if (node!=root&&!marked.contains(node))degree++;
        return degree;
    }
}
