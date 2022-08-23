import java.util.*;

public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if (root==null) return res;
        Deque<TreeNode> deque1=new ArrayDeque<>();
        Deque<TreeNode> deque2=new ArrayDeque<>();
        boolean rev=false;
        deque1.addLast(root);
        while (!deque1.isEmpty()||!deque2.isEmpty()){
            List<Integer> tmp=new LinkedList<>();
            if (!rev){
                while (!deque1.isEmpty()){
                    TreeNode node=deque1.poll();
                    tmp.add(node.val);
                    if (node.left!=null)
                    deque2.addFirst(node.left);
                    if (node.right!=null)
                    deque2.addFirst(node.right);
                }
                res.add(tmp);
            }
            else {
                while (!deque2.isEmpty()){
                    TreeNode node=deque2.poll();
                    tmp.add(node.val);
                    if (node.right!=null)
                        deque1.addFirst(node.right);
                    if (node.left!=null)
                    deque1.addFirst(node.left);
                }
                res.add(tmp);
            }
            rev=!rev;
        }
        return res;
    }
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
    public static void main(String[] args) {
        TreeNode treeNode=TreeNode.getTree(new Object[]{3, 9, 20, 7,2, 15, 7,3,4,null,6,7,null,9,10});
        System.out.println(new LC103().zigzagLevelOrder1(treeNode));
    }
}
