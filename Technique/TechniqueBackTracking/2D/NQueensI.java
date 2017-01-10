public class Solution {


public List<List<String>> solveNQueens(int n){
    List<List<String>> result = new ArrayList();
    if (n<0) return result;
    boolean[] cols = new boolean[n];
    boolean[] d1 = new boolean[2*n-1];
    boolean[] d2 = new boolean[2*n-1];
    backtrack (n,0,cols,d1,d2,new ArrayList<String>(), result);
    return result; 
}

private void backtrack(int n, int rowidx, boolean[] cols, boolean[] d1, boolean[] d2, List<String> oneSolution, List<List<String> solutions){
    if (rowidx=n){
        list.add(new ArrayList<String)(OneSolution));
    }
    char[] row = new char[n];
    Arrays.fill(row,.);
      for(int colidx = 0; colidx < n; colidx++){
                int d1idx = colidx - rowidx + n - 1;
                int d2idx = (n-colidx) - rowidx + n - 2;
            if(!cols[colidx] && !d1[d1idx] && !d2[d2idx]){
                    row[colidx] = 'Q';
                    oneSolution.add(new String(row));
                    cols[colidx] = d1[d1idx] = d2[d2idx] = true;
                
                solveNQueens(n, rowidx+1, cols, d1, d2, oneSolution, solutions);
          
                    row[colidx] = '.';
                    oneSolution.remove(oneSolution.size()-1);
                    cols[colidx] = d1[d1idx] = d2[d2idx] = false; 
        }
}

