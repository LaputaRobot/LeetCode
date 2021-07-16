import java.util.*;

public class lc102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if (root==null) return res;
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node=queue.poll();
                level.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(6, null, null), new TreeNode(3, null, null));
        root.right = new TreeNode(2, new TreeNode(3, null, null), new TreeNode(6, null, null));
        for (List list: levelOrder(root)) {
            for (Object i : list) {
                System.out.print(""+i+", ");
            }
            System.out.println();
        }
    }
}
