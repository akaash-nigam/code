/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        List<Integer> currentResult = new LinkedList<Integer>();
        backtrack(root,sum,currentResult,list);
        return list;
    }

public void backtrack(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result){
    if (root==null)return;
    currentResult.add(new Integer(root.val));
    if (root.left==null&& root.right==null && sum==root.val){
        result.add(new LinkedList(currentResult));
        currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
        return;
    }else{
        backtrack(root.left, sum - root.val, currentResult, result);
        backtrack(root.right, sum - root.val, currentResult, result);
    }
    currentResult.remove(currentResult.size() - 1);
}
}


//Summation of the Paths

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int result = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return result;
        helper(root, sum, false);
        return result;
    }
    
    private void helper(TreeNode node, int sum, boolean hasParent) {
        if (node == null) return;
        if (node.val == sum) {
            result++;
        }
        helper(node.left, sum - node.val, true);
        if (!hasParent) helper(node.left, sum, false);
        helper(node.right, sum - node.val, true);
        if (!hasParent) helper(node.right, sum, false);
    }
}