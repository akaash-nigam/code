 public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) {
            return result;
        }
        int left = 0, top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;

        while(left <= right && top <= bottom) {
            
            for(int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if(top > bottom) {
                continue;
            }
            for(int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if(right < left) {
                continue;
            }
            for(int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }



public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0)
            return res;
        int n = matrix[0].length;
        int layer = (n - 1) / 2;
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




public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix ==null ||  matrix.length<1)
                return result;
        int indexX = 0 ,indexY = 0 , endX = matrix[0].length -1 , endY = matrix.length -1 ;
        int loop = 0;
        /**
         * 0 = right , 1 down , 2 = left , 3 = up;
        */
        while(indexX <= endX && indexY <= endY){
            final int gowhere = loop % 4;
            switch(gowhere){
                case 0:{
                    for(int i = indexX ; i <= endX ; i++)
                        result.add(matrix[indexY][i]);
                    indexY++;
                    break;
                }
                 case 1:{
                    for(int i = indexY ; i <= endY ; i++)
                        result.add(matrix[i][endX]);
                    endX--;
                    break;
                }
                 case 2:{
                    for(int i = endX ; indexX <= i; i--)
                        result.add(matrix[endY][i]);
                    endY--;
                    break;
                }
                 case 3:{
                    for(int i = endY ; indexY <= i  ; i--)
                        result.add(matrix[i][indexX]);
                    indexX++;
                    break;
                }
            }
            loop++;
        }
        return result;
    }
}


public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> re = new ArrayList<Integer>();
    if(matrix == null || matrix.length == 0) return re;
    int m = matrix.length;
    int n = matrix[0].length;
    int start = 0;
    int upRow = 0, boRow = m-1, leCol = 0, riCol = n-1;
    while(true){
        for(int i = start; i <= riCol; i++){
            re.add(matrix[upRow][i]);
        }
        if(re.size() == m*n) return re;
        start++;
        for(int i = start; i <= boRow; i++){
            re.add(matrix[i][riCol]);
        }
        if(re.size() == m*n) return re;
        for(int i = n - 1 - start; i >= leCol; i--){
            re.add(matrix[boRow][i]);
        }
        if(re.size() == m*n) return re;
        for(int i = m - 1 - start; i > upRow; i--){
            re.add(matrix[i][leCol]);
        }
        if(re.size() == m*n) return re;
        riCol--; boRow--; leCol++; upRow++;
    }
}


public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length==0) {
            return list;
        }
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int i = 0;
        int j = 0;
        Direction to = Direction.RIGHT;
        while (true) {
            if (t > b || l > r) {
                break;
            }
            switch (to) {
                case RIGHT:
                    if (j <= r) {
                        list.add(matrix[i][j]);
                        j++;
                    } else {
                        to = Direction.DOWN;
                        i++;
                        j--;
                        t++;
                    }
                    break;
                case DOWN:
                    if (i <= b) {
                        list.add(matrix[i][j]);
                        i++;
                    } else {
                        to = Direction.LEFT;
                        j--;
                        i--;
                        r--;
                    }
                    break;
                case LEFT:
                    if (j >= l) {
                        list.add(matrix[i][j]);
                        j--;
                    } else {
                        to = Direction.UP;
                        i--;
                        j++;
                        b--;
                    }
                    break;
                case UP:
                    if (i >= t) {
                        list.add(matrix[i][j]);
                        i--;
                    } else {
                        to = Direction.RIGHT;
                        j++;
                        i++;
                        l++;
                    }
                    break;
            }
        }
        return list;
    }



public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0){
            return list;
        }
        int m = matrix.length, n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        int dir = 1;
        int mx = m - 1, ny = n - 1;
        for (int i = 0; i < n; i++){
            list.add(matrix[0][i]);
        }
        if (mx == 0){
            return list;
        }
        while (mx > 0 && ny > 0){
            if (dir == 0){
                for (int i = 0; i < ny; i++){
                    list.add(matrix[x][++y]);
                }
                
                ny--;
                dir++;
            } else if (dir == 1){
                for (int i = 0; i < mx; i++){
                    list.add(matrix[++x][y]);
                }
                mx--;
                dir++;
            } else if (dir == 2){
                for (int i = 0; i < ny; i++){
                    list.add(matrix[x][--y]);
                }
                ny--;
                dir++;
            } else {
                for (int i = 0; i < mx; i++){
                    list.add(matrix[--x][y]);
                }
                mx--;
                dir = 0;
            }
        }
        
        if (mx == 0 && ny != 0){
            if (dir == 0){
                for (int i = 0; i < ny; i++){
                    list.add(matrix[x][++y]);
                }
            } else {
                for (int i = 0; i < ny; i++){
                    list.add(matrix[x][--y]);
                }
            }
        } else if (ny == 0 && mx != 0){
            if (dir == 1){
                for (int i = 0; i < mx; i++){
                    list.add(matrix[++x][y]);
                }
            } else {
                for (int i = 0; i < mx; i++){
                    list.add(matrix[--x][y]);
                }
            }
        }
        return list;
    }
}


public class Solution {
    private static final int[][] DIRS = new int[][]{{0, 1},{1, 0},{0, -1}, {-1, 0}};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        search(0, 0, 0, matrix, visited, res);
        return res;
    }
    
    private void search(int x, int y, int index, int[][] matrix, boolean[][] visited, List<Integer> res) {
        res.add(matrix[x][y]);
        visited[x][y] = true;
        
        int[] dir = DIRS[index % 4];
        int i = x + dir[0];
        int j = y + dir[1];
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            int[] dir2 = DIRS[(++index) % 4];
            i = x + dir2[0];
            j = y + dir2[1];
            if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
                return;
            }
        }
        search(i, j, index, matrix, visited, res);
    }
}

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<Integer>();
        
        if(matrix.length == 0) {
            return l;
        }
        
        int i = 0, j = 0, rmin = 0, rmax = matrix.length-1, cmin = 0, cmax = matrix[0].length-1;
        boolean horizontal = true;
        int direction = 1;
        l.add(matrix[0][0]);
        
        while(rmin <= rmax && cmin <= cmax) {
            if(horizontal) {
                if(direction == 1) {
                    if(i < cmax) {
                        i++;
                    } else {
                        rmin++;
                        horizontal = false;
                        continue;
                    }
                } else {
                    if(i > cmin) {
                        i--;
                    } else {
                        rmax--;
                        horizontal = false;
                        continue;
                    }
                }
            } else {
                if(direction == 1) {
                    if(j < rmax) {
                        j++;
                    } else {
                        direction = -1;
                        cmax--;
                        horizontal = true;
                        continue;
                    }
                } else {
                    if(j > rmin) {
                        j--;
                    } else {
                        direction = 1;
                        cmin++;
                        horizontal = true;
                        continue;
                    }
                }
            }
            l.add(matrix[j][i]);
        }
        return l;
    }
}