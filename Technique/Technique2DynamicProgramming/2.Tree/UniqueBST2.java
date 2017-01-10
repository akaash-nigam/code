public int numTrees (int n){
    int[] count=new int[n+1];
    count[0]=1;
    count[1]=1;
    for (int i=2;i<n;i++){
        for (int j=0;j<=i-1;j++){
            count[i]=count[i]+count[j]*count[i-j-1];
        }
    }
}



public List<TreeNode> generateTrees(int n){
    if (n==0){
        return new ArrayList(TreeNode);
        return backtrack(1,n);
    }
}

public  List<TreeNode> backtrack(int m,int n){
    List<TreeNode> result = new ArrayList<TreeNode>();
    if (m>n){
        result.add(null);
        return result;
    }
    for (int i=m;i<n;i++){
        List<TreeNode> ls = backtrack(m,i-1);
        List<TreeNode> rs = backtrack(i+1,n);
        for (TreeNode l: ls){
            for( TreeNode l: ls){
                TreeNode curr = new TreeNode(i);
                curr.left=l;
                curr.right=r;
                result.add(curr);
            }
        }
    }
}
