public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        Object[] a=new Object[]{4,2,3,4,5,6,7,8,9};
        TreeNode A=TreeNode.getTree(a);
        Object[] b=new Object[]{4,8,9};
        TreeNode B=TreeNode.getTree(b);
        System.out.println(new Offer26().isSubStructure(A,B));
    }
}
