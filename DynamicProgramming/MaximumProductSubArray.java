public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int maxProduct = nums[0];
        int minProduct = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int prevMaxProduct = maxProduct;
            int prevMinProduct = minProduct;
            maxProduct = Math.max(nums[i], Math.max(nums[i] * prevMaxProduct, nums[i] * prevMinProduct));
            minProduct = Math.min(nums[i], Math.min(nums[i] * prevMaxProduct, nums[i] * prevMinProduct));
            max = Math.max(max, maxProduct);
        }
        
        return max;
    }

public int maxProduct(int[] nums) {
    int[] max = new int[nums.length];
    int[] min = new int[nums.length];
 
    max[0] = min[0] = nums[0];
    int result = nums[0];
 
    for(int i=1; i<nums.length; i++){
        if(nums[i]>0){
            max[i]=Math.max(nums[i], max[i-1]*nums[i]);
            min[i]=Math.min(nums[i], min[i-1]*nums[i]);
        }else{
            max[i]=Math.max(nums[i], min[i-1]*nums[i]);
            min[i]=Math.min(nums[i], max[i-1]*nums[i]);
        }
 
        result = Math.max(result, max[i]);
    }
 
    return result;
}