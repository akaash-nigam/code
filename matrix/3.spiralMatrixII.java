public int[][] generateMatrix(int n) {
    int total = n*n;
    int[][] result= new int[n][n];
 
    int x=0;
    int y=0;
    int step = 0;
 
    for(int i=0;i<total;){
        while(y+step<n){
            i++;
            result[x][y]=i; 
            y++;
 
        }    
        y--;
        x++;
 
        while(x+step<n){
            i++;
            result[x][y]=i;
            x++;
        }
        x--;
        y--;
 
        while(y>=0+step){
            i++;
            result[x][y]=i;
            y--;
        }
        y++;
        x--;
        step++;
 
        while(x>=0+step){
            i++;
            result[x][y]=i;
            x--;
        }
        x++;
        y++;
    }
 
    return result;
}



public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
 
    int k=1; 
    int top=0;
    int bottom=n-1;
    int left=0;
    int right=n-1;
 
    while(k<=n*n){
        for(int i=left; i<=right; i++){
            result[top][i]=k;
            k++;
        }    
        top++;
 
        for(int i=top; i<=bottom; i++){
            result[i][right]=k;
            k++;
        }
        right--;
 
        for(int i=right; i>=left; i--){
            result[bottom][i]=k;
            k++;
        }
        bottom--;
 
        for(int i=bottom; i>=top; i--){
            result[i][left] = k;
            k++;
        }
        left++;
    }
 
    return result;
}