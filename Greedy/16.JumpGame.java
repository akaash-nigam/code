public boolean canJump(int[] A) {
    int max = 0;
    for(int i=0;i<A.length;i++){
        if(i>max) {return false;}
        max = Math.max(A[i]+i,max);
    }
    return true;
}


public boolean canJump(int[] nums) {
    int reachable = 0;
    for (int i=0; i<nums.length; ++i) {
        if (i > reachable) return false;
        reachable = Math.max(reachable, i + nums[i]);
    }
    return true;
}


public boolean canJump(int[] nums) {
    int dis = 0;
    for (int i = 0; i <= dis; i++) {
        dis = Math.max(dis, i + nums[i]);
        if (dis >= nums.length-1) {
            return true;
        }
    }
    return false;
}   