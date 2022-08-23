public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return root;
        TreeNode parent=root;
        TreeNode son=root;
        if (root.val==key){
            if (root.left==null)root=root.right;
            else if(root.right==null) root=root.left;
            else {
                TreeNode r=root.right;
                while (r.left!=null)r=r.left;
                r.left=root.left;
                root=root.right;
            }
            return root;
        }
        while (son!=null){
            if (son.val>key){
                parent=son;
                son=son.left;
            }
            else if (son.val<key){
                parent=son;
                son=son.right;
            }
            else {
                if (parent.left==son) {
                    if (son.left==null){
                        parent.left=son.right;
                        break;
                    }
                    else if(son.right==null){
                        parent.left=son.left;
                        break;
                    }
                    parent.left = son.right;
                    while (parent.left!=null)parent=parent.left;
                    parent.left=son.left;
                }
                else if (parent.right==son){
                    if (son.left==null){
                        parent.right=son.right;
                        break;
                    }
                    else if(son.right==null){
                        parent.right=son.left;
                        break;
                    }
                    parent.right = son.left;
                    while (parent.right!=null)parent=parent.right;
                    parent.right=son.right;
                }
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=TreeNode.getTree(new Object[]{5,3,6,2,4,null,7});
        System.out.println(new LC450().deleteNode(root,5));
    }
}
