import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (queue.size()!=0){
            TreeNode r=queue.poll();
            if (r!=null) {
                stringBuilder.append(r.val);
                stringBuilder.append(",");
                queue.add(r.left);
                queue.add(r.right);
            }
            else {
                stringBuilder.append("null");
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] value=data.split(",");
        if (value[0].equals("null")) return null;
        TreeNode p = new TreeNode(Integer.parseInt(value[0]));
        TreeNode q = p;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int i = 0;
        while (p != null) {
            if (2 * i + 1 < value.length) {
                if (!value[2 * i + 1].equals("null")) {
                    p.left = new TreeNode(Integer.parseInt(value[2 * i + 1]));
                    queue.add(p.left);
                }
            }
            if (2 * i + 2 < value.length) {
                if (!value[2 * i + 2] .equals("null")) {
                    p.right = new TreeNode(Integer.parseInt(value[2 * i + 2]));
                    queue.add(p.right);
                }
            }
            p = queue.poll();
            i += 1;
        }
        return q;
    }
}
public class LC297 {
    public static void main(String[] args) {
//        TreeNode root=TreeNode.getTree(new Object[]{1,2,3,null,null,4,5,null,null,6});
        TreeNode root=new TreeNode(1);
        Codec codec=new Codec();
        String s=codec.serialize(root);
        System.out.println(s);
        TreeNode r=codec.deserialize(s);
        String s1=codec.serialize(r);
        System.out.println(s1);
    }
}
