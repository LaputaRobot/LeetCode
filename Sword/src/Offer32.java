import java.util.*;

public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[]{};
        Queue<TreeNode> queue=new ArrayDeque<>();
        ArrayList<Integer> res=new ArrayList<Integer>();
        queue.add(root);
        while (queue.size()!=0){
            TreeNode treeNode=queue.poll();
            res.add(treeNode.val);
            if (treeNode.left!=null)queue.add(treeNode.left);
            if (treeNode.right!=null)queue.add(treeNode.right);

        }
        int[] resArr=new int[res.size()];
        int i=0;
        for (Integer num : res) {
            resArr[i++]=num;
        }
        return resArr;
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        ArrayList<Integer> level=new ArrayList<>();
        queue.add(root);
        int times=1;
        while (queue.size()!=0){
            TreeNode treeNode=queue.poll();
            times--;
            level.add(treeNode.val);
            if (treeNode.left!=null)queue.add(treeNode.left);
            if (treeNode.right!=null)queue.add(treeNode.right);
            if (times==0){
                times=queue.size();
                res.add(level);
                level=new ArrayList<>();
            }
        }
        return res;
    }
    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        LinkedList<Integer> level=new LinkedList<>();
        queue.add(root);
        int times=1;
        int direction=0;
        while (queue.size()!=0){
            TreeNode treeNode=queue.poll();
            times--;
            if (direction==0)
                level.add(treeNode.val);
            else
                level.addFirst(treeNode.val);
            if (treeNode.left!=null)queue.add(treeNode.left);
            if (treeNode.right!=null)queue.add(treeNode.right);
            if (times==0){
                if (direction==0)  direction=1;
                else direction=0;
                times=queue.size();
                res.add(level);
                level=new LinkedList<>();
            }
        }
        return res;
    }

}
