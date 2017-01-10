public class Solution {
    public int trapRainWater(int[][] heightMap) {
        /*FIRST STEP*/
        if(heightMap.length == 0) return 0;
        int[][] wetMap = new int[heightMap.length][heightMap[0].length];
        int sum = 0;
        /*row by row*/
        for(int i = 1; i < wetMap.length - 1; i++){
            wetMap[i] = calculate(heightMap[i]);
        }
        /*column by column*/
        for(int i = 1; i < heightMap[0].length - 1; i++){
            int[] col = new int[heightMap.length];
            for(int j = 0; j < heightMap.length; j++){
                col[j] = heightMap[j][i];
            }
            int[] colResult = calculate(col);
            /*update the wetMap to be the bigger value between row and col, later we can spill, don't worry*/
            for(int j = 0; j < heightMap.length; j++){
                wetMap[j][i] = Math.max(colResult[j], wetMap[j][i]);
                sum += wetMap[j][i];
            }
        }
        /*SECOND STEP*/
        boolean spillWater = true;
        int[] rowOffset = {-1,1,0,0};
        int[] colOffset = {0,0,1,-1};
        while(spillWater){
            spillWater = false;
            for(int i = 1; i < heightMap.length - 1; i++){
                for(int j = 1; j < heightMap[0].length - 1; j++){
                    /*If this slot has ever gotten wet, exammine its 4 neightbors*/
                    if(wetMap[i][j] != 0){
                        for(int m = 0; m < 4; m++){
                            int neighborRow = i + rowOffset[m];
                            int neighborCol = j + colOffset[m];
                            int currentHeight = wetMap[i][j] + heightMap[i][j];
                            int neighborHeight = wetMap[neighborRow][neighborCol] + 
                                                              heightMap[neighborRow][neighborCol];
                            if(currentHeight > neighborHeight){
                                int spilledWater = currentHeight - Math.max(neighborHeight, heightMap[i][j]);
                                wetMap[i][j] = Math.max(0, wetMap[i][j] - spilledWater);
                                sum -= spilledWater;
                                spillWater = true;
                            }
                        }    
                    }    
                }
            }
        }
        return sum;
    }
    
    /*Nothing interesting here, the same function for trapping water 1*/
    private int[] calculate (int[] height){
        int[] result = new int[height.length];
        Stack<Integer> s = new Stack<Integer>();
        int index = 0;
        while(index < height.length){
            if(s.isEmpty() || height[index] <= height[s.peek()]){
                s.push(index++);
            }else{
                int bottom = s.pop();
                if(s.size() != 0){
                    for(int i = s.peek() + 1; i < index; i++){
                        result[i] += (Math.min(height[s.peek()], height[index]) - height[bottom]);
                    }    
                }
            }
        }
        return result;
    }   
    
}

public class Solution {

    public class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];

        // Initially, add all the Cells which are on borders to the queue.
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heights[i][0]));
            queue.offer(new Cell(i, n - 1, heights[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heights[0][i]));
            queue.offer(new Cell(m - 1, i, heights[m - 1][i]));
        }

        // from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
       // add all its neighbors to the queue.
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    res += Math.max(0, cell.height - heights[row][col]);
                    queue.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
                }
            }
        }
        
        return res;
    }
}