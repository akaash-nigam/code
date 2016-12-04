public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null)
        return null;
 
    if(root==p || root==q)
        return root;
 
    TreeNode l = lowestCommonAncestor(root.left, p, q);
    TreeNode r = lowestCommonAncestor(root.right, p, q);
 
    if(l!=null&&r!=null){
        return root;
    }else if(l==null&&r==null){
        return null;
    }else{
        return l==null?r:l;
    }
}
}

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode m = root;
 
    if(m.val > p.val && m.val < q.val){
        return m;  
    }else if(m.val>p.val && m.val > q.val){
        return lowestCommonAncestor(root.left, p, q);
    }else if(m.val<p.val && m.val < q.val){
        return lowestCommonAncestor(root.right, p, q);
    }
 
    return root;
}