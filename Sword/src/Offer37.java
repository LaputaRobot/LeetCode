import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "[]";
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        StringBuilder res= new StringBuilder();
        res.append('[');
        while (!queue.isEmpty()){
                TreeNode treeNode=queue.poll();
                if (treeNode!=null) {
                    res.append(treeNode.val).append(",");
                    queue.add(treeNode.left);
                    queue.add(treeNode.right);
                }
                else res.append("null,");
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] nums=data.split(",");
        if (nums.length==0) return null;
        int len=2;
        TreeNode root=new TreeNode(Integer.parseInt(nums[0].substring(1)));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int start=1;
        while (len>0){
            int tmpLen=0;
            TreeNode node = null;
            for (int i = start; i < start+len; i++) {
                if (i%2!=0) {
                    node = queue.poll();
                    if (!nums[i].equals("null")) {
                        node.left = new TreeNode(Integer.parseInt(nums[i]));
                        tmpLen+=2;
                        queue.add(node.left);
                    }
                }
                else {
                    if (!nums[i].equals("null")&&!nums[i].equals("null]")) {
                        node.right = new TreeNode(Integer.parseInt(nums[i]));
                        tmpLen+=2;
                        queue.add(node.right);
                    }
                }
            }
            start=start+len;
            len=tmpLen;
        }
        return root;
    }
}

public class Offer37 {
    public static void main(String[] args) {
        Object[] values= {};
        TreeNode treeNode=TreeNode.getTree(values);
        String str=new Codec().serialize(treeNode);
        System.out.println(str);
        System.out.println(new Codec().deserialize(str));
        System.out.println(treeNode);
    }
}
