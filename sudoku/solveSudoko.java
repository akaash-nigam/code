private char[][] b;
public void solveSudoku(char[][] board) {
    if(board == null || board.length < 9) return;
    b = board;
    solve(0);
}
public boolean solve(int ind){
    if(ind==81) return true; 
    int i=ind/9, j=ind%9;
    if(b[i][j]!='.') return solve(ind+1);
    else{
        for(char f = '1'; f <= '9'; f++){
            if(isValidFill(i, j, f)){
                b[i][j]= f;
                if(solve(ind+1)) return true;                
                b[i][j]='.';
            }
        }
        return false;
    }
}
public boolean isValidFill(int i, int j, char fill){
    for(int k=0; k<9; k++){
        int r= i/3*3+j/3;   //select the block
        if(b[i][k]==fill || b[k][j]==fill || b[r/3*3+k/3][r%3*3+k%3]==fill) 
            return false; //check row, column, block
    }            
    return true;
}
