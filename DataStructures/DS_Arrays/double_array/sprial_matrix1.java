public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0)
            return res;
        int n = matrix[0].length;
        int layer = (n - 1) /
         2;
        int start = 0;
        while(layer >= 0 && start <= m - 1){
            if(n - start == 1){
                for(int i = start; i <= m - 1; i++)
                    res.add(matrix[i][start]);
                return res;
            }
            for(int i = start; i <= n - 1; i++)
                res.add(matrix[start][i]);
            for(int i = start + 1; i < m - 1 && n - 1 > start; i++)
                res.add(matrix[i][n - 1]);
            for(int i = n - 1; i > start && m - 1 > start; i--)
                res.add(matrix[m - 1][i]);
            for(int i = m - 1; i > start; i--)
                res.add(matrix[i][start]);
            
            layer--;
            m--;
            n--;
            start++;
        }
        
        return res;
    }
}