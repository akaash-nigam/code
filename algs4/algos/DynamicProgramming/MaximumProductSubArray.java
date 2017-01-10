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