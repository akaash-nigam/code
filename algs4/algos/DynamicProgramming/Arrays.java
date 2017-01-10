public List<Integer> findDisappearedNumbers(int[] nums) {
    
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
        int index = Math.abs(nums[i])-1;
        if(nums[index] > 0)
            nums[index] = -nums[index];
    }

    for (int index = 0; index < nums.length; ++index) 
        if(nums[index] > 0) result.add(index +1);
    
    return result;
    
}