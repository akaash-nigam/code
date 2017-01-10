

public boolean searchMatrix(int[][] matrix, int target) {
    int i1=0; 
    int i2=matrix.length-1;
    int j1=0;
    int j2=matrix[0].length-1;
 
    return helper(matrix, i1, i2, j1, j2, target);
}
 
public boolean helper(int[][] matrix, int i1, int i2, int j1, int j2, int target){
 
    if(i1>i2||j1>j2)
        return false;
 
    for(int j=j1;j<=j2;j++){
        if(target < matrix[i1][j]){
            return helper(matrix, i1, i2, j1, j-1, target);
        }else if(target == matrix[i1][j]){
            return true;
        }
    }
 
    for(int i=i1;i<=i2;i++){
        if(target < matrix[i][j1]){
            return helper(matrix, i1, i-1, j1, j2, target);
        }else if(target == matrix[i][j1]){
            return true;
        }
    }
 
    for(int j=j1;j<=j2;j++){
        if(target > matrix[i2][j]){
            return helper(matrix, i1, i2, j+1, j2, target);
        }else if(target == matrix[i2][j]){
            return true;
        }
    }
 
    for(int i=i1;i<=i2;i++){
        if(target > matrix[i][j2]){
            return helper(matrix, i1, i+1, j1, j2, target);
        }else if(target == matrix[i][j2]){
            return true;
        }
    }
 
    return false;
}





public boolean searchMatrix(int[][] matrix, int target) {
    int m=matrix.length-1;
    int n=matrix[0].length-1;
 
    int i=m; 
    int j=0;
 
    while(i>=0 && j<=n){
        if(target < matrix[i][j]){
            i--;
        }else if(target > matrix[i][j]){
            j++;
        }else{
            return true;
        }
    }
 
    return false;
}

public boolean searchMatrix(int[][] matrix, int target) {
    int m=matrix.length-1;
    int n=matrix[0].length-1;
 
    int i=m; 
    int j=0;
 
    while(i>=0 && j<=n){
        if(target < matrix[i][j]){
            i--;
        }else if(target > matrix[i][j]){
            j++;
        }else{
            return true;
        }
    }
 
    return false;
}