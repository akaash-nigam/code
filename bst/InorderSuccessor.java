public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if(root==null || p==null)
        return null;
 
    stack.push(root);
    boolean isNext = false;
    while(!stack.isEmpty()){
        TreeNode top = stack.pop();
 
        if(top.right==null&&top.left==null){
            if(isNext){
                return top;
            }
 
            if(p.val==top.val){
                isNext = true;
            }
            continue;
        }
 
        if(top.right!=null){
            stack.push(top.right);
            top.right=null;
        }
 
        stack.push(top);
 
        if(top.left!=null){
            stack.push(top.left);
            top.left=null;
        }
    }
 
    return null;
}


public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(root==null)
        return null;
 
    TreeNode next = null;
    TreeNode c = root;
    while(c!=null && c.val!=p.val){
        if(c.val > p.val){
            next = c;
            c = c.left;
        }else{
            c= c.right;
        }
    }
 
    if(c==null)        
        return null;
 
    if(c.right==null)
        return next;
 
    c = c.right;
    while(c.left!=null)
        c = c.left;
 
    return c;
}