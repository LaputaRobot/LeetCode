import java.util.Stack;

public class LC222 {
    static int maxDeep;
    static int leafNum;

    public int countNodes(TreeNode root) {
        maxDeep=1;
        leafNum=0;
        if (root == null) return 0;
        TreeNode r=root;
        while (r.left != null) {
            r = r.left;
            maxDeep++;
        }
        interOrder(root, 1);
        return (int) Math.pow(2, maxDeep - 1)-1 + leafNum;
    }

    public boolean interOrder(TreeNode root, int deep) {
        if (root.left == null && root.right == null) {
            if (deep == maxDeep) {
                leafNum++;
                return true;
            } else return false;
        }
        if (root.left != null) {
            if (!interOrder(root.left, deep + 1)) return false;
            if (root.right==null) return false;
            else return interOrder(root.right, deep + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        for (int x = 1; x < 50; x++) {
            maxDeep=1;
            leafNum=0;
            Object[] nums=new Object[x];
            for (int i = 0; i < x; i++) {
                nums[i]=i;
            }
            TreeNode root=TreeNode.getTree(nums);
            System.out.println(new LC222().countNodes(root));
        }
    }
}
