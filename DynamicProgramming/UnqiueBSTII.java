    public class Solution {
    TreeNode deepCopy(TreeNode root){
        if(root == null) return null;
        TreeNode tmp = new TreeNode(1);
        tmp.left = deepCopy(root.left);
        tmp.right = deepCopy(root.right);
        return tmp;
    }
    int cur = 0;
    void setValue(TreeNode root){
        if(root.left != null){
            setValue(root.left);
        }
        root.val = cur++;
        if(root.right != null){
            setValue(root.right);
        }
        
    }
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0){
            List<TreeNode> res =new ArrayList<TreeNode>();
            res.add(null);
            return res;
        }
        
        List<TreeNode>[] dp = new ArrayList [n+1];
        for(int i = 0; i < n+1; ++i){
            dp[i] =  new ArrayList<TreeNode>();
        }
        
        dp[0].add(null);
        
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j < i; ++j){
                for(int k = 0; k < dp[j].size(); ++k){
                    for(int l = 0; l < dp[i-1-j].size(); ++l){
                        TreeNode tmp = new TreeNode(1);
                        tmp.left = deepCopy(dp[j].get(k));
                        tmp.right = deepCopy(dp[i-1-j].get(l));
                        dp[i].add(tmp);
                    }
                }
            }
        }
        
        for(int i = 0; i < dp[n].size(); ++i){
            cur = 1;
            setValue(dp[n].get(i));
        }
        return dp[n];
    }
}

public List<TreeNode> generateTrees(int n) {

List<TreeNode>[] res = new List[n+1];
res[0] = new ArrayList();
if(n == 0) return res[0];
res[0].add(null);
res[1] = new ArrayList();
res[1].add(new TreeNode(1));
for(int i=2;i<=n;i++){
    res[i] = new ArrayList();
    for(int j=1;j<=i;j++){
        for(TreeNode nodeL: res[j-1]){
            for(TreeNode nodeR: res[i-j]){
                TreeNode node = new TreeNode(j);
                node.left = nodeL;
                node.right = clone(nodeR, j);
                res[i].add(node);
            }
        }
    }
}
return res[n];
}

static TreeNode clone(TreeNode node, int offset){
if(node == null) return null;
TreeNode newNode = new TreeNode(node.val + offset);
newNode.left = clone(node.left, offset);
newNode.right = clone(node.right, offset);
return newNode;
}




public class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        
        return gen(1, n);
    }
    
    List<TreeNode> gen(int start, int end) {
        ArrayList<TreeNode> heads = new ArrayList<TreeNode>();
        if(start > end) {
            heads.add(null);
            return heads;
        }
        
        for(int i = start; i <= end; i++) {
            
            List<TreeNode> lefts = gen(start, i - 1);
            List<TreeNode> rights = gen(i + 1, end);
            
            for(TreeNode left : lefts) {
                for(TreeNode right : rights) {
                    TreeNode head = new TreeNode(i);
                    head.left = left;
                    head.right = right;
                    heads.add(head);
                }
            }
        }
        
        return heads;
        
    }
}




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
    public TreeNode[] recursion(int s, int e, int[] dp){
        TreeNode[] roots = null;
        int curlen = 0;
        if(s > e){
            roots = new TreeNode[1];
            roots[0] = null;
            return roots;
        }
        roots = new TreeNode[dp[e - s + 1]];
        for(int i = s; i <= e; i++){
            TreeNode[] lefts = recursion(s, i - 1, dp);
            TreeNode[] rights = recursion(i + 1, e, dp);
            for(TreeNode left : lefts){
                for(TreeNode right : rights){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    roots[curlen++] = root;
                }
            }
        }
        return roots;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new ArrayList<TreeNode>();
        else{
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= n; i++)
                for(int j = 1; j <= i; j++)
                    dp[i] += dp[j - 1] * dp[i - j];
            TreeNode[] resarr =  recursion(1, n, dp);
            List<TreeNode> res = new ArrayList<>();
            for(TreeNode node : resarr){
                res.add(node);
            }
            return res;
        }
    }
}