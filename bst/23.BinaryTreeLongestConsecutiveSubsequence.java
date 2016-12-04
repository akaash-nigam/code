public int longestConsecutive(TreeNode root) {
    if(root==null)
        return 0;
 
    LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    LinkedList<Integer> sizeQueue = new LinkedList<Integer>();
 
    nodeQueue.offer(root);
    sizeQueue.offer(1);
    int max=1;
 
    while(!nodeQueue.isEmpty()){
        TreeNode head = nodeQueue.poll();
        int size = sizeQueue.poll();
 
        if(head.left!=null){
            int leftSize=size;
            if(head.val==head.left.val-1){
                leftSize++;
                max = Math.max(max, leftSize);
            }else{
                leftSize=1;
            }
 
            nodeQueue.offer(head.left);
            sizeQueue.offer(leftSize);
        }
 
        if(head.right!=null){
            int rightSize=size;
            if(head.val==head.right.val-1){
                rightSize++;
                max = Math.max(max, rightSize);
            }else{
                rightSize=1;
            }
 
            nodeQueue.offer(head.right);
            sizeQueue.offer(rightSize);
        }
 
 
    }
 
    return max;
}


public class Solution {
    int max=0;
 
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
 
    public int helper(TreeNode root) {
        if(root==null)
            return 0;
 
        int l = helper(root.left);
        int r = helper(root.right);
 
        int fromLeft = 0;
        int fromRight= 0;
 
        if(root.left==null){
            fromLeft=1;
        }else if(root.left.val-1==root.val){
            fromLeft = l+1;
        }else{
            fromLeft=1;
        }
 
        if(root.right==null){
            fromRight=1;
        }else if(root.right.val-1==root.val){
            fromRight = r+1;
        }else{
            fromRight=1;
        }
 
        max = Math.max(max, fromLeft);
        max = Math.max(max, fromRight);
 
        return Math.max(fromLeft, fromRight);
    }
 
}