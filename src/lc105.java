import java.util.HashMap;
import java.util.Map;

public class lc105 {
    private static Map<Integer,Integer> indexInorder;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        indexInorder=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexInorder.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,0,preorder.length-1,
                0,inorder.length-1);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight){
        if(preorderLeft>preorderRight) return null;
        TreeNode root=new TreeNode(preorder[preorderLeft]);
        int preRoot=preorderLeft;
        int rootVal=preorder[preorderLeft];
        int inRoot=indexInorder.get(rootVal);
        int leftSize=inRoot-inorderLeft;
        root.left=buildTree(preorder,inorder,
                preRoot+1,
                preRoot+leftSize,
                inorderLeft,
                inRoot-1);
        root.right=buildTree(preorder,inorder,
                preRoot+leftSize+1,
                preorderRight,
                inRoot+1,
                inorderRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        TreeNode treeNode=buildTree(preorder,inorder);
        System.out.println(treeNode);
    }
}
