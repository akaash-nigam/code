    public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i=0;i<=len-3;i++){
            if (i>0 && nums[i]==nums[i-1]) continue; // avoid dup
            if (nums[i]+nums[i+1]+nums[i+2]>target) {
                if (diff > nums[i]+nums[i+1]+nums[i+2]-target){
                    diff = nums[i]+nums[i+1]+nums[i+2]-target;
                    res = nums[i]+nums[i+1]+nums[i+2];
                }
                continue;
            } 
            if (nums[i]+nums[len-2]+nums[len-1]<target){
                if (diff > target-nums[i]-nums[len-2]-nums[len-1]){
                    diff = target-nums[i]-nums[len-2]-nums[len-1];
                    res = nums[i]+nums[len-2]+nums[len-1];
                }
                continue;
            }
            int l=i+1,r=len-1;
            while(l<r){
                if (nums[i]+nums[l]+nums[r]>target) {
                    if (diff > nums[i]+nums[l]+nums[r] -target){
                        diff = nums[i]+nums[l]+nums[r]-target;
                        res = nums[i]+nums[l]+nums[r];
                    }
                    r--;
                }
                else if(nums[i]+nums[l]+nums[r]<target){
                    if (diff > target-nums[i]-nums[l]-nums[r] ){
                        diff = target-nums[i]-nums[l]-nums[r];
                        res = nums[i]+nums[l]+nums[r];
                    }
                    l++;
                }
                else return nums[i]+nums[l]+nums[r];
            }            
        }
        return res;
    }
}
