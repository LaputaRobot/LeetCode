import java.util.ArrayList;
import java.util.List;

/*
*还未使用迭代法过，空间复杂度较高
*/
public class lc94 {
    public static List<Integer> inOrder(TreeNode root,ArrayList<Integer> list) {
        if(root==null) return list;
        if(root.left!=null) inOrder(root.left,list);
        list.add(root.val);
        if(root.right!=null) inOrder(root.right,list);
        return list;
    }
    public static List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> arrayList=new ArrayList<>();
        return  inOrder(root,arrayList);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2,null,null);
        root.right.left=new TreeNode(3,null,null);
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println(inorderTraversal(root));
    }
}
