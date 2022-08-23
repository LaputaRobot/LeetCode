import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res=new LinkedList<>();
        LinkedList<Integer> record=new LinkedList<>();
        dfs(root,target,record,res);
        return res;
    }
    public void dfs(TreeNode root,int target,LinkedList<Integer> record,List<List<Integer>> res){
        if (root==null) return;
        if (root.left==null&&root.right==null) {
            if (root.val==target){
                record.add(root.val);
                res.add((List<Integer>) record.clone());
                record.removeLast();
            }
            return;
        }
        record.add(root.val);
        dfs(root.left,target- root.val,record,res);
        dfs(root.right,target-root.val,record,res);
        record.removeLast();
    }
    public static void main(String[] args) {
        Object[] values=new Object[]{5,-5,8,5,null,13,4,7,-5,null,null,5,1};
        TreeNode root=TreeNode.getTree(values);
        System.out.println(new Offer34().pathSum(root,0));
    }
}
