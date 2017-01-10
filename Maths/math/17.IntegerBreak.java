public int integerBreak(int n) {
    int[] dp = new int[n+1];
 
    for(int i=1; i<n; i++){
        for(int j=1; j<i+1; j++){
            if(i+j<=n){
                dp[i+j]=Math.max(Math.max(dp[i],i)*Math.max(dp[j],j), dp[i+j]);
            }
        }
    }
 
    return dp[n];
}


public int integerBreak(int n) {
 
    if(n==2) return 1;
    if(n==3) return 2;
    if(n==4) return 4;
 
    int result=1;
    if(n%3==0){
        int m = n/3;
        result = (int) Math.pow(3, m);
    }else if(n%3==2){
        int m=n/3;
        result = (int) Math.pow(3, m) * 2;
    }else if(n%3==1){
        int m=(n-4)/3;
        result = (int) Math.pow(3, m) *4;
    }
 
    return result;
}
