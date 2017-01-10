public int minSubArrayLen(int s, int[] nums) {
    if(nums==null || nums.length==1)
        return 0;
 
    int result = nums.length;
 
    int start=0;
    int sum=0;
    int i=0;
    boolean exists = false;
 
    while(i<=nums.length){
        if(sum>=s){
            exists=true; //mark if there exists such a subarray 
            if(start==i-1){
                return 1;
            }
 
            result = Math.min(result, i-start);
            sum=sum-nums[start];
            start++;
 
        }else{
            if(i==nums.length)
                break;
            sum = sum+nums[i];
            i++;    
        }
    }
 
    if(exists)
        return result;
    else
        return 0;
}


public int minSubArrayLen(int s, int[] nums) {
    if(nums==null||nums.length==0)
        return 0;
 
    int i=0; 
    int j=0;
    int sum=0;
 
    int minLen = Integer.MAX_VALUE;
 
    while(j<nums.length){
        if(sum<s){
            sum += nums[j];
            j++;        
        }else{
            minLen = Math.min(minLen, j-i);
            if(i==j-1)
                return 1;
 
            sum -=nums[i];
            i++;
        }
    }
 
    while(sum>=s){
        minLen = Math.min(minLen, j-i);
 
        sum -=nums[i++];
    }
 
    return minLen==Integer.MAX_VALUE? 0: minLen;
}